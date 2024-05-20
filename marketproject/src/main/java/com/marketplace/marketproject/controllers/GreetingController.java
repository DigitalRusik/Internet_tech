package com.marketplace.marketproject.controllers;

import com.marketplace.marketproject.models.User;
import com.marketplace.marketproject.models.UserService;
import com.marketplace.marketproject.functions.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import jakarta.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class GreetingController {
    @Autowired
    private static UserService userService;
    String response = "false";
    String hashpass = "";
    @ResponseBody
    @PostMapping("/api/greeting1")
    public String ApiLogin(HttpSession session,@RequestParam(name="lemail", required=false) String email, @RequestParam(name="lpass", required=false) String pass, Model model) {
        pass = pass.trim();
        String username = "";
        email = email.trim().toLowerCase();
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String passkey = user.getPasskey();
            String hashpass = Function.md5(passkey + pass);
            username = user.getName();
            if (email.equals(user.getEmail()) && hashpass.equals(user.getPassword())) {
                session.setAttribute("username", username);
                response = "Вход выполнен!";
            } else {
                response = "Неверные данные!";
            }
        } else {
            response = "Такого логина не существует!";
        }
        return response;
    }
    @GetMapping("/api/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/greeting";
    }
    @ResponseBody
    @PostMapping("/api/greeting")
    public String ApiRegister(HttpSession session,@RequestParam(name = "username", required = false) String username, @RequestParam(name="email", required = false) String email, @RequestParam(name="pass", required = false) String pass, Model model) {
        username = username.trim();
        email = email.trim();
        email = email.toLowerCase();
        pass = pass.trim();
        String passkey = Function.generateRandomString(10);
        Optional<User> userOptional = UserService.getUserByEmail(email);
        User user = userOptional.orElse(null);
        if (user != null) {
            return "Такая почта уже существует!";
        }
        if (email == "" || pass == "" || username == "") {
            return "Заполните все поля!";
        }

        if (!Function.isValidEmail(email)) {
            return "Почта невалидна!";
        }
        hashpass = Function.md5(passkey + pass);
        User registerUser = new User();
        registerUser.setEmail(email);
        registerUser.setPassword(hashpass);
        registerUser.setName(username);
        registerUser.setPasskey(passkey);
        registerUser.setDelete(false);
        UserService.createUser(registerUser);
        session.setAttribute("username", username);
        return "Ваш аккаунт зарегистрирован!";
    }
}

