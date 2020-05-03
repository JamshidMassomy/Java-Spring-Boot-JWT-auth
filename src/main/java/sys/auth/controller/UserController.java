package sys.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.auth.entities.User;
import sys.auth.services.UserServices;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

   /* @PostMapping(path = "user/CreateUser")
    public User CreateUser(@RequestBody User user){
        return userServices.CreateUser(user);
    }*/

    @GetMapping(path = "user/GetUsers")
    public List<User> GetUsers(){
        return userServices.GetAll();
    }
    @GetMapping(path = "user/GetUsersCount")
    public Long UsersCount(){
        return  userServices.CountUser();
    }
    @DeleteMapping(path = "/removeUsers/{Id}")
    public  void DeleteUser(@PathVariable Long Id){
        userServices.DeleteUser(Id);
    }

}
