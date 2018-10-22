package com.example.demo.Service;

import com.example.demo.DAO.UserDao;
import com.example.demo.Exceptions.EmailExistsException;
import com.example.demo.models.User;

public interface UserServiceI {

    User registerNewUserAccount(UserDao account) throws EmailExistsException 
    {
            throw new EmailExistsException("Email exists");
    }
}