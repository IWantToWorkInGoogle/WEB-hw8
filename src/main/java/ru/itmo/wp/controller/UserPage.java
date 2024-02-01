package ru.itmo.wp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.UserService;

@Controller
public class UserPage extends Page{

    private final UserService userService;

    //private final UserCredentials userCredentials;


    public UserPage(UserService userService) {//UserCredentials userCredentials) {
        this.userService = userService;
        //this.userCredentials = userCredentials;
    }


    @GetMapping("/user/{id}")
    public String user(Model model, @PathVariable("id") String id) {
        long user_id = -1;
        if (!id.isEmpty() && !id.equals(null) && !id.isBlank()) {
            try {
                user_id = Long.parseLong(id);
            } catch (NumberFormatException e) {
                //
            }
            model.addAttribute("profile", userService.findById(user_id));
        }
        return "UserPage";
    }

    @GetMapping("/user")
    public String user() { return "NotFoundPage"; }
}
