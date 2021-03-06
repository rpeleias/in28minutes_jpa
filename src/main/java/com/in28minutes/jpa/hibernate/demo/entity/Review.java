package com.in28minutes.jpa.hibernate.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String rating;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    public Review() {
    }
}
