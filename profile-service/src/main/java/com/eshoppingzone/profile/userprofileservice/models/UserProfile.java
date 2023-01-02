package com.eshoppingzone.profile.userprofileservice.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="profile")
public class UserProfile 
{
	private int id;
private String  fullName;

private String gender;
private String image;
private String emailId;
private Long mobileNumber;
private String about;

private LocalDate dateOfBirth;
private String role;
private String password;
private List<Address> address;



}
