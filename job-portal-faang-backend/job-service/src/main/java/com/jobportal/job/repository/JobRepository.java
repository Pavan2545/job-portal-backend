
package com.jobportal.job.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.job.entity.Job;
import java.util.List;
public interface JobRepository extends JpaRepository<Job,Long>{
 List<Job> findByTitleContainingIgnoreCase(String title);
}
