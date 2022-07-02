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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city")
    private String city;
    @Column(name = "external_id")
    private String externalId;
    @Column(name = "winnings_amount")
    private Integer winningsAmount;
    @Column(name = "participated_at")
    private Instant participatedAt;
    @Column(name = "created_at", columnDefinition = "timestamp not null default now()", insertable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private Instant createdAt;
}
