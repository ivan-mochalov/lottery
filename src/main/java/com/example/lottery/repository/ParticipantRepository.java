package com.example.lottery.repository;

import com.example.lottery.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Modifying
    @Query(value = "truncate table participants", nativeQuery = true)
    void deleteAll();
}
