package com.api.system.registration.Service.Interface;

import com.api.system.registration.Entity.Login;
import com.api.system.registration.Service.LoginDTO.LoginDTO;

public interface LoginService {
    LoginDTO findByUserNameAndPassword(String userName, String password);

}
