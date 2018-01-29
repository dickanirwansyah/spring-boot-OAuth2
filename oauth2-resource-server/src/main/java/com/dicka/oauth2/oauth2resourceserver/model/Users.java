package com.dicka.oauth2.oauth2resourceserver.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        catalog = "db_oauth2")
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers")
    private Long idusers;

    @Email(message = "email tidak valid")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "active")
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_role", joinColumns =
    @JoinColumn(name = "idusers"), inverseJoinColumns =
    @JoinColumn(name = "idrole"))
    private Set<Role> roles = new HashSet<Role>();

    public Users(){}

    public Users(Users users){

        this.active=users.active;
        this.name=users.name;
        this.lastname=users.lastname;
        this.password=users.password;
        this.email=users.email;
        this.idusers=users.idusers;
        this.roles=users.roles;

    }

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles){
        this.roles=roles;
    }

    public void setActive(int active){
        this.active=active;
    }

    public int getActive(){
        return active;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setIdusers(Long idusers){
        this.idusers=idusers;
    }

    public Long getIdusers(){
        return idusers;
    }
}
