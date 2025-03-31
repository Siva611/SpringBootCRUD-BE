package com.jsp.SpringBootCRUD_BE.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Student")

public class Student {

	    @Id
	    
	    @UuidGenerator  //It will generate the Id Automatically 
	    
	    @Column(name = "id", unique = true, updatable = false)
	
//It will generate the Id Automatically :
//	    @GeneratedValue(generator = "uuid") 
//	    @GenericGenerator(name = "uuid", strategy = "uuid2") 
	    
	    private String id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String department;
	    private Long aadharNumber;
	    
		private String photoUrl;
	    
	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
		
		public Long getAadharNumber() {
			return aadharNumber;
		}

		public void setAadharNumber(Long aadharNumber) {
			this.aadharNumber = aadharNumber;
		}


		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}

		
	    
}
