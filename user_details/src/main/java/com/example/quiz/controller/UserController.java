package com.example.quiz.controller;

import com.example.quiz.dto.Userdto;
import com.example.quiz.service.UserService;
import com.example.quiz.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("details")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("allDetails")
    public List<Userdetails> getAllQuestions() {
        return userService.getAllQuestions();
    }

    @GetMapping("/name/{name}")
    public List<Userdetails> getQuestionsByCategory(@PathVariable String name) {
        return userService.getQuestionsByCategory(name);
    }
    @GetMapping("/{id}")
    public Userdetails getUserById(@PathVariable Integer id){
        return userService.findById(id).orElseThrow();
    }
    /*@PostMapping("add")
    public String addUser(@RequestBody Userdetails question) {
        return userService.addUser(question);
    }*/

    @PostMapping("add")
    public Userdto addUser(@RequestBody Userdto userdto) {
        return userService.addUser(userdto);
    }


    @PutMapping("/name/{id}")
    public Userdetails updateUser(@RequestBody Userdetails question,
                                  @PathVariable Integer id) {

        return userService.findById(id)
                .map(user -> {
                    user.setName(question.getName());
                    user.setUsername(question.getUsername());
                    user.setEmail(question.getEmail());
                    return userService.save(user);
                })
                .orElseThrow();
    }

    @DeleteMapping("/name/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deletebyId(id);

    }

}
