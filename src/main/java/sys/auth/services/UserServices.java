package sys.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sys.auth.entities.User;
import sys.auth.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public User CreateUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<User> _user = userRepository.findById(user.getId());
        if(_user.isPresent()){
            User updateUser =_user.get();
            updateUser.setUserName(user.getUserName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());

            updateUser = userRepository.save(updateUser);
            return updateUser;
        }else{
            userRepository.save(user);
            return user;
        }
    }
    public void DeleteUser(Long Id){
         userRepository.deleteById(Id);
    }
    public Long CountUser(){
        return userRepository.count();
    }
    public List<User> GetAll(){
        List<User> userList = userRepository.findAll();
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }
}
