package com.example.profiles;

import java.util.Objects;

/**
 * Immutable user profile - once created, it can't be changed.
 * This prevents bugs from accidental modifications and makes the class thread-safe.
 */
public final class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(String id, String email, String phone, String displayName, 
                       String address, boolean marketingOptIn, String twitter, String github) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.displayName = displayName;
        this.address = address;
        this.marketingOptIn = marketingOptIn;
        this.twitter = twitter;
        this.github = github;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    @Override
    public String toString() {
        return String.format("UserProfile{id='%s', email='%s', phone='%s', displayName='%s', " +
                           "address='%s', marketingOptIn=%s, twitter='%s', github='%s'}", 
                           id, email, phone, displayName, address, marketingOptIn, twitter, github);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        UserProfile that = (UserProfile) obj;
        return marketingOptIn == that.marketingOptIn &&
               Objects.equals(id, that.id) &&
               Objects.equals(email, that.email) &&
               Objects.equals(phone, that.phone) &&
               Objects.equals(displayName, that.displayName) &&
               Objects.equals(address, that.address) &&
               Objects.equals(twitter, that.twitter) &&
               Objects.equals(github, that.github);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone, displayName, address, marketingOptIn, twitter, github);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn = false; 
        private String twitter;
        private String github;

        public Builder id(String id) {
            this.id = id;
            return this; // method chaining for fluent API
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder marketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder twitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder github(String github) {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            Validation.requireValidId(id);
            Validation.requireEmail(email);
            Validation.validateDisplayName(displayName);
            Validation.validatePhone(phone);
            Validation.validateTwitterHandle(twitter);
            Validation.validateGithubUsername(github);

            return new UserProfile(id, email, phone, displayName, address, marketingOptIn, twitter, github);
        }
    }
}
