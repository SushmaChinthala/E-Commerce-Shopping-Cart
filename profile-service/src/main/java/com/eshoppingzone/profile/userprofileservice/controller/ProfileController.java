package com.eshoppingzone.profile.userprofileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.profile.userprofileservice.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.models.UserProfile;
import com.eshoppingzone.profile.userprofileservice.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController
{
@Autowired
ProfileService profileService;

public ProfileController(@RequestBody ProfileService profileService) {
	super();
	this.profileService = profileService;
}

public ProfileController() {
	super();
}
@PostMapping("/addingcustomer")
public UserProfile addNewCustomerProfile(@RequestBody UserProfile userProfile)
{
	return profileService.addNewCustomerProfile(userProfile);
}
@PostMapping("/addingmerchant")
public UserProfile addNewMerchantProfile(@RequestBody UserProfile userProfile)
{
	return profileService.addNewMerchantProfile(userProfile);
}
@PostMapping("/addingdelivaryprofile")
public UserProfile addNewDelivaryProfile(@RequestBody UserProfile userProfile)
{
	return profileService.addNewDelivaryProfile(userProfile);
}
@GetMapping("/getallprofiles")
public List<UserProfile> getAllProfiles()
{
	return  profileService.getAllProfiles();
}
@GetMapping("/getbyprofileid/{profileId}") 
public Optional<UserProfile> getByProfileId(@PathVariable int profileId)
{
	return profileService.getByProfileId(profileId);
}
@GetMapping("/getbyphonenumber/{mobileNumber}")
public UserProfile getByPhoneNumber(@PathVariable Long mobileNumber)
{
	return  profileService.findByMobileNo(mobileNumber);
}
@PutMapping("/updateprofile/{profileId}")
public UserProfile updateProfile(@PathVariable int profileId,@RequestBody UserProfile userProfile)
{
	return  profileService.updateUserProfile(userProfile);
}
@DeleteMapping("/deleteprofile/{profileId}")
public void deleteProfile(@PathVariable int profileId)
{
	 profileService.deleteProfile(profileId);
}



}
