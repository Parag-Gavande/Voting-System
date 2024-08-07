package com.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.votingSystem.entity.Election;
import com.votingSystem.repository.ElectionRepository;
import java.util.List;

@Service
public class ElectionService {
    @Autowired
    private ElectionRepository electionRepository;

    public void saveElection(Election election) {
        electionRepository.save(election);
    }

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }
}
