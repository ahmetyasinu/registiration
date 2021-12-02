package com.api.system.registration.Controller;

import com.api.system.registration.Entity.Login;
import com.api.system.registration.Service.LoginDTO.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/otomasyon")
public class LoginController {
    private final Logger Log = LoggerFactory.getLogger(LoginController.class);
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }



 /*   @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public LoginDTO loginDTO(@RequestBody LoginDTO loginDTO){
        LoginDTO loginDto =loginService.findByUserNameAndPassword(loginDTO.getUserName(),loginDTO.getUserName());
        if (loginDto==null){
            throw new RuntimeException("Şifre veya Parola hatalı.");
        }
        return loginDto;
    }*/


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO Login, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(Login.getUserName(),Login.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("");
    }

}
