package com.engine.springbootquickstart_v2.board.domain;


import lombok.Data;

@Data
public class Member {
    private String id;
    private String password;
    private long sequecne;

//    private void setId(String id) {
//        this.id = id;
//    }
//
//    private void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getId() {
//        return id;
//    }
//    public String getPassword() {
//        return password;
//    }
}
