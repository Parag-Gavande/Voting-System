package com.votingSystem.service;

import java.util.List;
import com.votingSystem.entity.Voter;

public interface VoterService {
    Voter saveVoter(Voter voter);
    List<Voter> voterlist();
    Voter updateVoter(Voter voter, Long voterId);
    Voter findByUsernameAndPassword(String username, String password);
    void deleteById(Long voterId);
    Voter findById(Long voterId);
    //NEW12
	void updateVoter(Voter voter);
}

