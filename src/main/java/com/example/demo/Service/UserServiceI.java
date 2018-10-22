package com.example.demo.Service;

import com.example.demo.models.User;

public interface UserServiceI {

    User registerNewUserAccount(User account) throws EmailExistsException 

    {    
            throws EmailExistsException;
    }
}