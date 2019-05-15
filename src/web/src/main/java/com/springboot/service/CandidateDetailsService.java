package com.springboot.service;

import com.springboot.model.Candidate;
import com.springboot.model.PersonalDetails;
import com.springboot.model.ProjectSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Service
public class CandidateDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateDetailsService.class);

    private List<Candidate> candidateList;

    @PostConstruct
    public void init(){
        LOGGER.info("Initializing candidates list");
        candidateList = new ArrayList<>();
        PersonalDetails personalDetails = new PersonalDetails("Pankaj Ambere", "pankaj.ambere@gmail.com")
                .withPhone("+1(551)225-9017")
                .withLinkedInProfile("https://www.linkedin.com/in/pankaj-ambere-b211322a/")
                .withGithubProfile("https://github.com/pankajambere");

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Apache Camel");
        skills.add("Spring Framework");
        skills.add("Python");

        Candidate candidate = new Candidate(personalDetails,skills);

        candidate.setBullets(Arrays.asList("Design and Implementation of Generic Order Management System",
                                            "Design and Implementation of Generic State Machine",
                                            "Design and Implementation of many frameworks"));

        ProjectSummary osmSummary = new ProjectSummary("Order State Manager", "Morgan Stanley")
                .withDescription("Generic order state manager to cater all the products")
                .withStartDate(LocalDate.parse("2018-05-15"))
                .withTechnologies(new HashSet<>(Arrays.asList("Java", "Apache Camel", "Python", "Spring Framework")));
        candidate.setProjectSummaries(new HashSet<>(Arrays.asList(osmSummary)));
        candidateList.add(candidate);
    }

    public List<Candidate> getCandidates(){
        LOGGER.info("Returning candidates: {}", candidateList);
        return candidateList;
    }

    public Optional<Candidate> getCandidate(String candidateName){
        return candidateList.stream().filter(c->c.getPersonalDetails().getName().equalsIgnoreCase(candidateName)).findFirst();
    }

}
