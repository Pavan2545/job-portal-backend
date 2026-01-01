
package com.jobportal.auth.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.jobportal.auth.repository.UserRepository;
import com.jobportal.auth.entity.*;
import com.jobportal.auth.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {
 private final UserRepository repo;
 private final JwtUtil jwt;
 private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
 public AuthController(UserRepository r,JwtUtil j){repo=r;jwt=j;}

 @PostMapping("/register")
 public ResponseEntity<?> register(@RequestBody User u){
  u.setPassword(encoder.encode(u.getPassword()));
  repo.save(u);
  return ResponseEntity.ok("registered");
 }

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody User u){
  User db=repo.findByEmail(u.getEmail()).orElseThrow();
  if(!encoder.matches(u.getPassword(),db.getPassword())) throw new RuntimeException();
  return ResponseEntity.ok(jwt.generateToken(db.getEmail(),db.getRole().name()));
 }
}
