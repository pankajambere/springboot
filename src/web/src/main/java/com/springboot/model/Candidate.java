package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Candidate {

    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private PersonalDetails personalDetails;
    private List<String> bullets;
    private List<String> skills;
    @Embedded
    private Set<ProjectSummary> projectSummaries;

    public Candidate(PersonalDetails personalDetails, List<String> skills){
        this.personalDetails = personalDetails;
        this.skills = skills;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Set<ProjectSummary> getProjectSummaries() {
        return projectSummaries;
    }

    public void setProjectSummaries(Set<ProjectSummary> projectSummaries) {
        this.projectSummaries = projectSummaries;
    }

    public List<String> getBullets() {
        return bullets;
    }

    public void setBullets(List<String> bullets) {
        this.bullets = bullets;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return new EqualsBuilder()
                .append(personalDetails, candidate.personalDetails)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(personalDetails)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("personalDetails", personalDetails)
                .append("skills", skills)
                .append("projectSummaries", projectSummaries)
                .toString();
    }
}
