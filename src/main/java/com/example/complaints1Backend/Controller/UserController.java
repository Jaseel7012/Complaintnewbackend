package com.example.complaints1Backend.Controller;

import com.example.complaints1Backend.Dao.UserDao;
import com.example.complaints1Backend.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private  UserDao userDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/reg",consumes = "application/json",produces = "application/json")
    public  HashMap<String, String> userreg(@RequestBody UserModel um){
        HashMap<String,String> hm=new HashMap<>();
        hm.put("status","success");
        userDao.save(um);


        return hm;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlog",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userLogin(@RequestBody UserModel userModel){
        List<UserModel> l=(List<UserModel>) userDao.LoginUser(userModel.getEmail(),userModel.getPassword());
        HashMap<String,String> hm=new HashMap<String,String>();
        if(l.size()==0){
            hm.put("status","failed");
        }else {
            hm.put("status","success");
            hm.put("User Id",String.valueOf(l.get(0).getId()));
        }
        return  hm;
    }

    @PostMapping(path = "/userbyid",consumes = "application/json",produces = "application/json")
    public List<UserModel> UserinfoById(@RequestBody UserModel um){
        List<UserModel> l1= userDao.UserInfoById(um.getId());
        return l1;

    }
}
