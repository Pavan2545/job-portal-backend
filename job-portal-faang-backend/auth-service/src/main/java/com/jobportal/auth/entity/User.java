
package com.jobportal.auth.entity;
import javax.persistence.*;
@Entity
@Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @Column(unique=true)
 private String email;
 private String password;
 @Enumerated(EnumType.STRING)
 private Role role;
 // getters & setters
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public String getEmail(){return email;}
 public void setEmail(String e){this.email=e;}
 public String getPassword(){return password;}
 public void setPassword(String p){this.password=p;}
 public Role getRole(){return role;}
 public void setRole(Role r){this.role=r;}
}
