package com.marketplace.marketproject.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "writer")
    private String writer;
    @Column(name = "receiver")
    private String receiver;
}
