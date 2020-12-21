package springangular.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String toHome() {
        return "index";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "authentication";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("usuarios")
    public String toUsers() {
        return "user";
    }
}
