package com.dicka.oauth2.oauth2resourceserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role",
        catalog = "db_oauth2")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrole")
    private Long idrole;

    @Column(name = "role", nullable = false)
    private String role;

    public Role(){

    }

    public Long getIdrole(){
        return idrole;
    }

    public void setIdrole(Long idrole){
        this.idrole=idrole;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role=role;
    }
}
