
package com.jobportal.job.entity;
import javax.persistence.*;
@Entity
public class Job {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String title;
 private String location;
 // getters setters
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public String getTitle(){return title;}
 public void setTitle(String t){this.title=t;}
 public String getLocation(){return location;}
 public void setLocation(String l){this.location=l;}
}
