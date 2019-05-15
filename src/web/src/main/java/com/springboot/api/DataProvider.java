package com.springboot.api;

import com.springboot.model.Candidate;
import com.springboot.service.CandidateDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data")
public class DataProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataProvider.class);

    @Autowired
    CandidateDetailsService candidateDetailsService;

    @PostConstruct
    public void init(){
        LOGGER.info("DataProvider API activated.");
    }

    @GetMapping("/hello/{name}")
    public String helloUser(@PathVariable String name){
        return String.format("Hello %s", name);
    }

    @GetMapping("/init")
    public String initialize(){
        candidateDetailsService.saveAll();

        return "Success";
    }

    @GetMapping("/candidate/all")
    public List<Candidate> getAllCandidates(){
        return candidateDetailsService.getCandidates();
    }

    @GetMapping("/candidate/{name}")
    public Candidate getCandidate(@PathVariable String name){
        LOGGER.info("getting details for {}", name);
        Optional<Candidate> candidate = candidateDetailsService.getCandidate(name);
        return candidate.isPresent()?candidate.get():null;
    }
}
