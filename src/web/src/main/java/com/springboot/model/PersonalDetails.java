package com.springboot.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class PersonalDetails {

    private String name;
    private String email;
    private String phone;
    private String linkedInProfile;
    private String githubProfile;

    public PersonalDetails(String name, String email){
        this.name = name;
        this.email = email;
    }

    public PersonalDetails withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public PersonalDetails withLinkedInProfile(String profile){
        this.linkedInProfile = profile;
        return this;
    }

    public PersonalDetails withGithubProfile(String profile){
        this.githubProfile = profile;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(String linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PersonalDetails that = (PersonalDetails) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("email", email)
                .append("phone", phone)
                .append("linkedInProfile", linkedInProfile)
                .append("githubProfile", githubProfile)
                .toString();
    }
}
