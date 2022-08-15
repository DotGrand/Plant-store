package org.project.plantstore.controller;

import org.apache.log4j.Logger;
import org.project.plantstore.entity.User;
import org.project.plantstore.service.UserService;
import org.project.plantstore.user.PlantStorageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model model) {
        model.addAttribute("plantStorageUser", new PlantStorageUser());

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("plantStorageUser") PlantStorageUser plantStorageUser,
            BindingResult theBindingResult,
            Model model) {

        String userName = plantStorageUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        if (theBindingResult.hasErrors()) {
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("plantStorageUser", new PlantStorageUser());
            model.addAttribute("registrationError", "User name already exists.");

            logger.warn("User name already exists.");
            return "registration-form";
        }

        userService.save(plantStorageUser);
        logger.info("Successfully created user: " + userName);

        return "registration-confirmation";
    }
}

