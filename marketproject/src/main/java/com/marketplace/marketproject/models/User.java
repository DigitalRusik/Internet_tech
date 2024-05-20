package com.marketplace.marketproject.models;
//import jakarta.persistence.*;
import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "passkey")
    private String passkey;
    // Конструкторы, геттеры и сеттеры
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.username = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDelete(boolean deleted) {
        this.deleted = deleted;
    }
    public void setPasskey(String passkey) { this.passkey = passkey; }
    public Long getId() {
        return id;
    }
    public String getName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean getDelete() {
        return deleted;
    }
    public String getEmail() {
        return email;
    }
    public String getPasskey() {return passkey; }

}