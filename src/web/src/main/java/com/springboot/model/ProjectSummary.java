package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Embeddable
public class ProjectSummary {

    private String projectName;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<String> highlights;
    private Set<String> technologies;

    public ProjectSummary(String projectName, String clientName){
        this.projectName = projectName;
        this.clientName = clientName;
    }

    public ProjectSummary withStartDate(LocalDate startDate){
        this.startDate = startDate;
        return this;
    }
    public ProjectSummary withEndDate(LocalDate endDate){
        this.endDate= endDate;
        return this;
    }

    public ProjectSummary withDescription(String description){
        this.description = description;
        return this;
    }

    public ProjectSummary withHighlights(List<String> highlights){
        this.description = description;
        return this;
    }

    public List<String> addHighlight(String highlight){
        if(!Objects.nonNull(highlights))
            highlights = new ArrayList<>();
        highlights.add(highlight);
        return highlights;
    }

    public ProjectSummary withTechnologies(Set<String> technologies){
        this.technologies = technologies;
        return this;
    }

    public Set<String> addTechnology(String technology){
        if(!Objects.nonNull(technologies))
            technologies = new HashSet<>();
        technologies.add(technology);
        return technologies;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<String> technologies) {
        this.technologies = technologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProjectSummary that = (ProjectSummary) o;

        return new EqualsBuilder()
                .append(projectName, that.projectName)
                .append(clientName, that.clientName)
                .append(startDate, that.startDate)
                .append(endDate, that.endDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(projectName)
                .append(clientName)
                .append(startDate)
                .append(endDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("projectName", projectName)
                .append("clientName", clientName)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("description", description)
                .append("highlights", highlights)
                .append("technologies", technologies)
                .toString();
    }
}
