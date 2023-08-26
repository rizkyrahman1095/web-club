package com.rungroop.web.repository;

import com.rungroop.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);
}
