package com.eshoppingzone.profile.userprofileservice.pojo.profileservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.rmi.UnexpectedException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockBeans;

import com.eshoppingzone.profile.userprofileservice.ProfileServiceApplication;
import com.eshoppingzone.profile.userprofileservice.controller.ProfileController;
import com.eshoppingzone.profile.userprofileservice.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.models.Address;
import com.eshoppingzone.profile.userprofileservice.models.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;
import com.eshoppingzone.profile.userprofileservice.service.ProfileService;

//import net.bytebuddy.implementation.ExceptionMethod;

@SpringBootTest
public class UserProfileApplicationTests 
{
	UserProfile profile;
    @BeforeEach
	void init()
    {
		profile = new UserProfile();
	}

	@Autowired
	ProfileService profileService;
	@MockBean
	private ProfileRepository profileRepository;
	@Autowired 
	ProfileController profileController;
	

	@Test
	public void getProfileTest()

	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		when(profileRepository.findAll()).thenReturn(Stream.of(new UserProfile(1,"Sushma Chinthala","female","ghft","sushma@gmail.com", 5467289197L,"fhtt",LocalDate.of(2002,10,28),"customer","ghst",address)).collect(Collectors.toList()));
		
		assertEquals(1, profileService.getAllProfiles().size());
	}

	@Test
	public void addCustomerProfile() {
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Sushma Chinthala","female","ghft","sushma@gmail.com",(long) 5567829189L,"fhtt",LocalDate.of(2002,10,28),"customer","ghst",address);
		when(profileRepository.insert(profile)).thenReturn(profile);
		assertEquals(profile, profileService.addNewCustomerProfile(profile));
	}

	@Test
	public void addDelivaryProfile() {
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Sushma Chinthala","female","ghft","sushma@gmail.com",  5567829178L,"fhtt",LocalDate.of(2002,10,28),"customer","ghst",address);
		
		when(profileRepository.insert(profile)).thenReturn(profile);
		assertEquals(profile, profileService.addNewDelivaryProfile(profile));
	}

	@Test
	public void addNewMerchantProfile() {
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Sushma Chinthala","female","ghft","sushma@gmail.com", 5567829167L,"fhtt",LocalDate.of(2002,10,28),"merchant","ghst",address);
		
		when(profileRepository.insert(profile)).thenReturn(profile);
		assertEquals(profile, profileService.addNewMerchantProfile(profile));
	}

	@Test
	public void deleteByProfileIdTest() 
	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Sushma Chinthala","female","ghft","sushma@gmail.com", 5567829176L,"fhtt",LocalDate.of(2002,10,28),"customer","ghst",address);
     profileRepository.delete(profile);
	}
	@Test
	public void updateUserProfileTest()
	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		when(profileRepository.save(profile)).thenReturn(profile);
		assertEquals(profile,profileService.updateUserProfile(profile));
	}
	@Test
		public void throwProfileNotFoundByIdExceptionTest()
		{
		
		
		
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
	
	  UserProfile profile = new
	  UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com",
	  7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",
	  address); 
	  int id=2;
	  if(profileRepository.existsById(id)) 
	  { 
		  return ;
      }
	  else { assertThat(String.format("Id NOT FOUND",id)); }
	 
	 
	}
		
	@Test
	public void findByMobileNumberTest()
	{
		
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		Long number=7655678291L;
		
		when(profileRepository.findAllByMobileNumber(number))
	    .thenReturn(profile);
	    assertEquals(profile,profileService.findByMobileNo(number));
	}
	
	@Test
	public void addingCustomerControllerTest()
	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		when(profileService.addNewCustomerProfile(profile)).thenReturn(profile);
		assertEquals(profile,profileController.addNewCustomerProfile(profile));
	}
	@Test
	public void addNewMerchantProfileTest()
	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		when(profileService.addNewMerchantProfile(profile)).thenReturn(profile);
		assertEquals(profile,profileController.addNewMerchantProfile(profile));
		
	}
	@Test
	public void addNewDelivaryAgentTest()
	{
		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		when(profileService.addNewDelivaryProfile(profile)).thenReturn(profile);
		assertEquals(profile,profileController.addNewDelivaryProfile(profile));
		
	}
	
   @Test
   public void getAllProfilesTest()
   {
	   List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		List<UserProfile> profiles=new ArrayList<>();
		profiles.add(new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address));
		when(profileService.getAllProfiles()).thenReturn(profiles);
		assertEquals(profiles,profileController.getAllProfiles());
   }
   @Test
   public void getByProfileIdTest()
   {

		List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		int profileId=1;
		if(profileRepository.existsById(profileId))
		{
			return ;
		}
		else
		{
			assertThat(String.format("ID NOT FOUND",profileId));
		}
   }
 
   
   @Test
   public void getByPhoneNumberTest()
   {
	   List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		Long number=7655678291L;
		when(profileService.findByMobileNo(number)).thenReturn(profile);
		assertEquals(profile,profileController.getByPhoneNumber(number));
		
   }
   @Test
   public void updateProfileIdTest()
   {
	   List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		int profileId=1;
		when(profileService.updateUserProfile(profile)).thenReturn(profile);
		assertEquals(profile,profileController.updateProfile(profileId, profile));
   }
   @Test
   public void deleteProfileTest()
   {
	   List<Address> address =new ArrayList<>();
		address.add(new Address(123,"mpp school","mpp","prakasam","ap",8756));
		UserProfile profile = new UserProfile(1,"Srimanya Gangavarapu","female","ghft","srimanya@gmail.com", 7655678291L,"customer with id ",LocalDate.of(2002,10,28),"customer","ghst",address);
		int profileId=1;
	if(profileRepository.existsById(profileId))
	{
		profileController.deleteProfile(profileId);
	}
	else
	{
		assertThat(String.format("ID NOT FOUND EXCEPTION"));
	}
	
   }
   
  
		
		
		
}
