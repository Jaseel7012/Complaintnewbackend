package com.example.complaints1Backend.Dao;

import com.example.complaints1Backend.Model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `email`, `name`, `password`, `pno` FROM `user1` WHERE `email` =:email AND `password` =:password",nativeQuery = true)
    List<UserModel> LoginUser(@Param("email") String email,@Param("password") String password);

    @Query(value = "SELECT * FROM `user1` WHERE `id` =:id",nativeQuery = true)
    List<UserModel> UserInfoById(@Param("id") Integer id);
}
