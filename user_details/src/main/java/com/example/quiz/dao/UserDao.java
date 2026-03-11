package com.example.quiz.dao;

import com.example.quiz.Userdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Userdetails, Integer> {
 List<Userdetails> findByName(String name);
}
