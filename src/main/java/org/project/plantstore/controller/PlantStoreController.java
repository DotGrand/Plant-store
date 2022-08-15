package org.project.plantstore.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantStoreController {

    private static final Logger logger = Logger.getLogger(PlantStoreController.class);

    @GetMapping("/")
    public String showMainPage() {
        logger.info("Loading main page");
        return "redirect:plant/list";
    }
}
