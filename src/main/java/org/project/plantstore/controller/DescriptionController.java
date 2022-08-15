package org.project.plantstore.controller;

import org.project.plantstore.entity.Description;
import org.project.plantstore.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plant")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    // trims white spaces to resolve validation issue
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/addDescriptionForm")
    public String addDescriptionForm(Model model) {
        Description description = new Description();

        model.addAttribute("description", description);

        return "plant-save-form";
    }

    @PostMapping("/saveDescription")
    public String saveDescription(@Valid @ModelAttribute("description") Description description,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "plant-save-form";
        } else {
            descriptionService.saveDescription(description);
            return "redirect:/plant/list";
        }
    }

    @GetMapping("/updateDescription")
    public String updateDescription(@RequestParam("descriptionId") Long id, Model model) {
        Description description = descriptionService.getDescription(id);

        model.addAttribute("description", description);

        return "plant-save-form";
    }

    @GetMapping("/deleteDescription")
    public String deleteDescription(@RequestParam("descriptionId") Long id) {
        descriptionService.deleteDescription(id);

        return "plant-description-form";
    }
}
