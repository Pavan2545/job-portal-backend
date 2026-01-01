
package com.jobportal.job.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jobportal.job.repository.JobRepository;
import com.jobportal.job.entity.Job;
@RestController
@RequestMapping("/jobs")
public class JobController {
 private final JobRepository repo;
 public JobController(JobRepository r){repo=r;}
 @PostMapping public Job create(@RequestBody Job j){return repo.save(j);}
 @GetMapping("/search")
 public List<Job> search(@RequestParam String keyword){
  return repo.findByTitleContainingIgnoreCase(keyword);
 }
}
