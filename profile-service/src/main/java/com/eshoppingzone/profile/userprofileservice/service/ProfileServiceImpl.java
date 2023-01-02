package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.userprofileservice.exception.ProfileNotFoundException;
//import com.casestudy.exception.ProductNotFoundException;
//import com.casestudy.productservice.entity.Product;
import com.eshoppingzone.profile.userprofileservice.models.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	ProfileRepository profileRepository;

	@Override
	public UserProfile addNewCustomerProfile(UserProfile userProfile) {

		return profileRepository.insert(userProfile);
	}

	@Override
	public List<UserProfile> getAllProfiles() {

		return profileRepository.findAll();
	}

	@Override
	public Optional<UserProfile> getByProfileId(int profileId) throws ProfileNotFoundException{
         if(profileRepository.existsById(profileId))
         {
		return profileRepository.findById(profileId);
         }
         else
         {
        	  throw new ProfileNotFoundException("PROFILE NOT FOUND WITH ID "+profileId);
         }
	}

	@Override
	public UserProfile updateUserProfile(UserProfile userProfile) 
	{
		
		
		/*
		 * UserProfile updatedProfile=profileRepository.findById(id).orElseThrow();
		 * updatedProfile.setProfileId(userProfile.getProfileId());
		 * updatedProfile.setFullName(userProfile.getFullName());
		 * updatedProfile.setImage(userProfile.getImage());
		 * updatedProfile.setEmailId(userProfile.getEmailId());
		 * updatedProfile.setMobileNumber(userProfile.getMobileNumber());
		 * updatedProfile.setAbout(userProfile.getAbout());
		 * updatedProfile.setDateOfBirth(userProfile.getDateOfBirth());
		 * updatedProfile.setGender(userProfile.getGender());
		 * updatedProfile.setRole(userProfile.getRole());
		 * updatedProfile.setPassword(userProfile.getPassword());
		 * 
		 * final UserProfile finalUpdatedProfile =
		 * profileRepository.save(updatedProfile);
		 * 
		 * 
		 * return finalUpdatedProfile;
		 */
		return profileRepository.save(userProfile);
		
	}

	@Override
	public void deleteProfile(int profileId) throws ProfileNotFoundException {
		if(profileRepository.existsById(profileId))
		{
		profileRepository.deleteById(profileId);
		}
		else
		{
			throw new ProfileNotFoundException("PROFILE NOT EXISTS WITH ID " +profileId);
		}
		}

	@Override
	public UserProfile addNewMerchantProfile(UserProfile userProfile) {
		return profileRepository.insert(userProfile);

	}

	@Override
	public UserProfile addNewDelivaryProfile(UserProfile userProfile) {
		return profileRepository.insert(userProfile);

	}

	@Override
	public UserProfile findByMobileNo(Long mobileNumber) {
		
		return profileRepository.findAllByMobileNumber(mobileNumber);
	}

	

}
