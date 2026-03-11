package com.example.quiz.service;

import com.example.quiz.dao.UserDao;
import com.example.quiz.Userdetails;
import com.example.quiz.dto.Userdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
@Autowired
UserDao userDao;
    public List<Userdetails> getAllQuestions(){
   return userDao.findAll();
    }

    public List<Userdetails> getQuestionsByCategory(String name) {
        return userDao.findByName(name);
    }


    public Userdto addUser(Userdto userdto){
        Userdetails newuser = new Userdetails(
                userdto.getId(),
                userdto.getName(),
                userdto.getUsername(),
                userdto.getEmail()

        );

        Userdetails savedUser = userDao.save(newuser);
        Userdto savedUserDto= new Userdto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getUsername(),
                savedUser.getEmail()

        );
        return savedUserDto;
    }

    public Optional<Userdetails> findById(Integer id){
        return userDao.findById(id);
    }

   public Userdetails save(Userdetails user){
        return userDao.save(user);
    }

    public String deletebyId(Integer id){
        if(!userDao.existsById(id)){
            throw new RuntimeException("User not found");
        }
         userDao.deleteById(id);
        return "deleted";
    }


};


