package com.jsp.SpringBootCRUD_BE.service;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jsp.SpringBootCRUD_BE.dto.Student;
import com.jsp.SpringBootCRUD_BE.exception.StudentAlreadyExistsException;
import com.jsp.SpringBootCRUD_BE.exception.StudentNotFoundException;
import com.jsp.SpringBootCRUD_BE.repo.StudentRepository;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import static com.jsp.SpringBootCRUD_BE.constant.Constant.PHOTO_DIRECTORY;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor

public class StudentService {

	private static final String PHOTO_DIRECTORY = "uploads/";
	
	@Value("${photo.directory:uploads}") 
    private String photoDirectory;

	
	@Autowired private StudentRepository studentRepository;
	
//List The Students
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
  
//Add the students
    public Student saveStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())){
            throw  new StudentAlreadyExistsException(student.getEmail()+ " already exists!");
        }
        return studentRepository.save(student);
    }
    
    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
 
    
//UploadImage.
    
    public Student getStudent(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }  
    
    public String uploadPhoto(String id, MultipartFile file) {
        Student student = getStudent(id);
        String filename = id + getFileExtension(file.getOriginalFilename());

        try {
            
            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if (!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }

           
            Path filePath = fileStorageLocation.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Generate accessible photo URL
            String photoUrl = "/students/image/" + filename;
            student.setPhotoUrl(photoUrl);
            studentRepository.save(student);

            return photoUrl;
        } catch (Exception e) {
            throw new RuntimeException("Unable to save image", e);
        }
    }

    
  // Serve uploaded profile photo
    public Resource getImage(String filename) {
        try {
            Path filePath = Paths.get(PHOTO_DIRECTORY).resolve(filename).normalize();
            return new UrlResource(filePath.toUri());
        } catch (Exception e) {
            throw new RuntimeException("Unable to load image", e);
        }
    }

    private String getFileExtension(String filename) {
        return filename.contains(".") ? filename.substring(filename.lastIndexOf(".")) : ".png";
    }

    
    
	    
//Update Student
    public Student updateStudent(Student student, String id) {
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            st.setAadharNumber(student.getAadharNumber());
            st.setPhotoUrl(student.getPhotoUrl());
            
//            if (student.getPhotoUrl() != null && !student.getPhotoUrl().isEmpty()) {
//                st.setPhotoUrl(student.getPhotoUrl());
//            }

            
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }
    
// GetStudentById 
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" +id));
    }
    
//Delete By Id
    public void deleteStudent(String id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found");
        }
        studentRepository.deleteById(id);
    }
    
    
}
