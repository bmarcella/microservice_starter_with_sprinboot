package com.monkata.users.services;

import java.util.List;

import com.monkata.users.Entity.Users;

public interface IUserService {

 public Users save(Users l);

 public List<Users> findAll();
}
