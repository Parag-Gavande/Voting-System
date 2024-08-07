package com.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.votingSystem.entity.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
