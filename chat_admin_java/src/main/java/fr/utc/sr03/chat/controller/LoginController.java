package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * URL de base du endpoint : http://localhost:8080/login
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String postLogin(@ModelAttribute User user, Model model, WebRequest request) {
        User loggedUser = userRepository.findByMailAndPassword(user.getMail(), user.getPassword());

        if (loggedUser != null && loggedUser.isAdmin()){
            return "redirect:/admin/users";
        }
        else{
            model.addAttribute("msg", "login ou password incorrect");
            return "login";
        }
    }

    @PostMapping(value = "react", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User postLoginFromReact(@RequestBody User user) {
        User loggedUser = new User();

        // Check user + session
        if (user != null && user.getMail() != null && !user.getMail().isEmpty() && user.getPassword() != null && !user.getPassword().isEmpty()){
            loggedUser = userRepository.findByMailAndPassword(user.getMail(), user.getPassword());
        }

        return loggedUser;
    }
}
