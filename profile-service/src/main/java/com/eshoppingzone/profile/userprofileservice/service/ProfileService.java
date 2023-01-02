package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.userprofileservice.models.UserProfile;

@Service
public interface ProfileService 
{
public UserProfile addNewCustomerProfile(UserProfile userProfile);
public List<UserProfile> getAllProfiles();
public Optional<UserProfile> getByProfileId(int profileId);
public UserProfile updateUserProfile(UserProfile userProfile);
public void deleteProfile(int profileId);
public UserProfile addNewMerchantProfile(UserProfile userProfile);
public UserProfile addNewDelivaryProfile(UserProfile userProfile);
public UserProfile findByMobileNo(Long mobileNumber);

}
