package com.example.lottery.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "winners")
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private Integer age;
    private String city;
    @Column(name = "winnings_amount")
    private Integer winningsAmount;
    @Column(name = "participated_at")
    private Instant participatedAt;
    @Column(name = "created_at", columnDefinition = "timestamp not null default now()", insertable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private Instant createdAt;
}
