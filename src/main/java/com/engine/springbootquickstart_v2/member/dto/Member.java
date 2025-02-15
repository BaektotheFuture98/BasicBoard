package com.engine.springbootquickstart_v2.member.dto;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "Member")
@Data
public class Member {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sequence;
    private String id;
    private String name;
    private String password;
}
