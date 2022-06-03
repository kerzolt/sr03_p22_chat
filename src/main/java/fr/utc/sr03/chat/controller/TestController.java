package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * URL du endpoint : http://localhost:8080/test
 */
@Controller
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody // Pour faire sans template html
    public String test() {
        LOGGER.info("=== ALL USERS ===");
    	List<User> users = userRepository.findAll();
        users.forEach(user -> {
            LOGGER.info(user.getFirstName() + " : " + user.isAdmin());
        });

        LOGGER.info("=== ADMIN ONLY ===");
        List<User> admins = userRepository.findAdminOnly();
        admins.forEach(admin -> {
            LOGGER.info(admin.getFirstName() + " : " + admin.isAdmin());
        });

        return "ok";
    }
}
