package com.example.quiz.controller;

import com.example.quiz.service.QuestionService;
import com.example.quiz.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("details")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allDetails")
    public List<Userdetails> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/name/{name}")
    public List<Userdetails> getQuestionsByCategory(@PathVariable String name) {
        return questionService.getQuestionsByCategory(name);
    }
    @GetMapping("/{id}")
    public Userdetails getUserById(@PathVariable Integer id){
        return questionService.findById(id).orElseThrow();
    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Userdetails question) {
        return questionService.addQuestion(question);
    }


    @PutMapping("/name/{id}")
    public Userdetails updateUser(@RequestBody Userdetails question,
                                  @PathVariable Integer id) {

        return questionService.findById(id)
                .map(user -> {
                    user.setName(question.getName());
                    user.setUsername(question.getUsername());
                    user.setEmail(question.getEmail());
                    return questionService.save(user);
                })
                .orElseThrow();
    }

    @DeleteMapping("/name/{id}")
    public String deleteUser(@PathVariable Integer id){
        return questionService.deletebyId(id);

    }

}