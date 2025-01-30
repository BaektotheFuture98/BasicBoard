package com.engine.springbootquickstart_v2.member.dto;


import lombok.Data;

@Data
public class Member {
    private String id;
    private String name;
    private String password;
    private long sequecne;
}
