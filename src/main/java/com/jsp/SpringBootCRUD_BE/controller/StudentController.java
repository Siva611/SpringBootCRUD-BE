package com.jsp.SpringBootCRUD_BE.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.SpringBootCRUD_BE.dto.Student;
import com.jsp.SpringBootCRUD_BE.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import static com.jsp.SpringBootCRUD_BE.constant.Constant.PHOTO_DIRECTORY;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

//@CrossOrigin("http://localhost:3000") To connect the fornt End & Back end

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	
	@Autowired
	private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }

//    @PostMapping
//    public Student addStudent(@RequestBody Student student){
//        return studentService.saveStudent(student);
//        
//    }
    
    
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    
    
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable(value = "id") String id){
        return studentService.getStudentById(id);
    }

    
 //Image Code     
    @PutMapping("/photo")
    public ResponseEntity<String> updatePhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        try {
            String photoUrl = studentService.uploadPhoto(id, file);
            return ResponseEntity.ok(photoUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating photo: " + e.getMessage());
        }
    }
    
    @GetMapping("/image/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource resource = studentService.getImage(filename);

        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) 
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  
// 
 

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable(value = "id") String id){
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") String id){
        studentService.deleteStudent(id);
    }

    
//    @GetMapping("/student/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") String id){
//        return ResponseEntity.ok().body(studentService.getStudentById(id));
//    }

}
