package com.example.demo.Service;

import com.example.demo.DAO.UserDao;
import com.example.demo.Exceptions.EmailExistsException;
import com.example.demo.Repository.UserLoginRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService  {
    @Autowired
    private UserLoginRepository repository;

    @Transactional
    public User registerNewUserAccount(UserDao accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmailId())) {
            throw new EmailExistsException(
                    "There is an account with that email address: " + accountDto.getEmailId());
        }
        User user = new User();
        if(accountDto.getPassword()!=accountDto.getPassword2())
        {
            return null;
        }
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setPassword2(accountDto.getPassword2());
        user.setEmailId(accountDto.getEmailId());
        return user;
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmailId(email);
        if (user != null) {
            return true;
        }
        return false;
    }


}