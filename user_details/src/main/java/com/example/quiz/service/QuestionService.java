package com.example.quiz.service;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
@Autowired
QuestionDao questiondao;
    public List<Userdetails> getAllQuestions(){
   return questiondao.findAll();
    }

    public List<Userdetails> getQuestionsByCategory(String name) {
        return questiondao.findByName(name);
    }

    public String addQuestion(Userdetails question){
        questiondao.save(question);
        return "sucess";
    }

    public Optional<Userdetails> findById(Integer id){
        return questiondao.findById(id);
    }

    public Userdetails save(Userdetails user){
        return questiondao.save(user);
    }

    public String deletebyId(Integer id){
        if(!questiondao.existsById(id)){
            throw new RuntimeException("User not found");
        }
         questiondao.deleteById(id);
        return "deleted";
    }


};


