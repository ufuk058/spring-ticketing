package com.ticketing.service;

import com.ticketing.dto.UserDTO;

import java.util.List;

public interface UserService extends CRUDService <UserDTO,String> {

    List<UserDTO> findManagers();


    List<UserDTO> findEmployees();
}
