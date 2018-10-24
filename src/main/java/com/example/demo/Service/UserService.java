package com.example.demo.Service;

import com.example.demo.DAO.UserDao;
import com.example.demo.Exceptions.EmailExistsException;
import com.example.demo.Repository.UserLoginRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Service
public class UserService  {
    @Autowired
    private UserLoginRepository repository;

    @Transactional
    public User registerNewUserAccount(UserDao accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList("ROLE_USER"));
        if((emailExist(user.getEmail())))
        return repository.save(user);
        else
            return null;
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }


}