package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")

public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        

        if(verify == user.getPassword()){
            return "user/index";
        } else {
            return "user/add";
        }


    }


}
