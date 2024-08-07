package com.votingSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.votingSystem.entity.Voter;
import com.votingSystem.repository.VoterRepository;

@Service
public class VoterserviceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepository;
    
    @Override
    public Voter saveVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    @Override
    public List<Voter> voterlist() {
        return voterRepository.findAll();
    }

    
    //NEW12
    @Override
    public void updateVoter(Voter voter) {
        if (voter.getId() == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        voterRepository.save(voter);
    }

    @Override
    public Voter findByUsernameAndPassword(String username, String password) {
        return voterRepository.findByUsernameAndPassword(username, password);
    }

    //NEW
    @Override
    public void deleteById(Long id) {
        if (voterRepository.existsById(id)) {
            voterRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Voter ID does not exist.");
        }
    }
	
	//NEW13
	
	@Override
    public Voter findById(Long id) {
        return voterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid voter Id:" + id));
    }

    @Override
    public Voter updateVoter(Voter voter, Long voterId) {
       
        Voter existingVoter = voterRepository.findById(voterId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid voter Id: " + voterId));

        existingVoter.setVoterName(voter.getVoterName());
        existingVoter.setDob(voter.getDob());
        existingVoter.setGender(voter.getGender());
        existingVoter.setUsername(voter.getUsername());
        existingVoter.setPassword(voter.getPassword());

        return voterRepository.save(existingVoter);
    }
    
    

//	@Override
//	public void updateVoter(Voter voter) {
//		// TODO Auto-generated method stub
//		
//	}
}





