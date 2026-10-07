package com.college.erp.dao;

import com.college.erp.model.User;

public interface UserDAO {

    User findByUsername(String username);
}