package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        return UserProfile.builder()
                .id(id)
                .email(email)
                .build();
    }

    /**
     * Creates a full profile with all details.
     * The Builder handles validation automatically.
     */
    public UserProfile createFullProfile(String id, String email, String phone, 
                                       String displayName, String address, 
                                       boolean marketingOptIn, String twitter, String github) {
        return UserProfile.builder()
                .id(id)
                .email(email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }

    public UserProfile createSocialProfile(String id, String email, String twitter, String github) {
        return UserProfile.builder()
                .id(id)
                .email(email)
                .twitter(twitter)
                .github(github)
                .build();
    }

    public UserProfile updateDisplayName(UserProfile existingProfile, String newDisplayName) {
        Objects.requireNonNull(existingProfile, "Profile cannot be null");
        
        if (newDisplayName != null && newDisplayName.length() > 100) {
            newDisplayName = newDisplayName.substring(0, 100);
        }

        return UserProfile.builder()
                .id(existingProfile.getId())
                .email(existingProfile.getEmail())
                .phone(existingProfile.getPhone())
                .displayName(newDisplayName)
                .address(existingProfile.getAddress())
                .marketingOptIn(existingProfile.isMarketingOptIn())
                .twitter(existingProfile.getTwitter())
                .github(existingProfile.getGithub())
                .build();
    }

    public UserProfile updateProfile(UserProfile existingProfile, String newDisplayName, 
                                   String newAddress, boolean newMarketingOptIn) {
        Objects.requireNonNull(existingProfile, "Profile cannot be null");
        
        return UserProfile.builder()
                .id(existingProfile.getId())
                .email(existingProfile.getEmail())
                .phone(existingProfile.getPhone())
                .displayName(newDisplayName != null ? newDisplayName : existingProfile.getDisplayName())
                .address(newAddress != null ? newAddress : existingProfile.getAddress())
                .marketingOptIn(newMarketingOptIn)
                .twitter(existingProfile.getTwitter())
                .github(existingProfile.getGithub())
                .build();
    }
}
