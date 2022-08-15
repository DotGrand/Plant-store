package org.project.plantstore.controller;


import org.project.plantstore.entity.Description;
import org.project.plantstore.service.DescriptionService;
import org.project.plantstore.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.OrderInfo;
import org.project.plantstore.entity.Plant;
import org.project.plantstore.service.PlantService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private DescriptionService descriptionService;

    // trims white spaces to resolve validation issue
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String showPlants(Model model) {
        List<Plant> plants = plantService.getPlants();

        model.addAttribute("plants", plants);

        return "plants-list";
    }

    @GetMapping("/addPlantForm")
    public String addPlantForm(Model model) {
        Plant plant = new Plant();

        model.addAttribute("plant", plant);

        return "plant-save-form";
    }

    @PostMapping("/savePlant")
    public String savePlant(@Valid @ModelAttribute("plant") Plant plant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "plant-save-form";
        } else {
            plantService.savePlant(plant);
            return "redirect:/plant/list";
        }
    }

    @GetMapping("/updatePlant")
    public String updatePlant(@RequestParam("plantId") Long id, Model model) {
        Plant plant = plantService.getPlant(id);

        model.addAttribute("plant", plant);

        return "plant-save-form";
    }

    @GetMapping("/deletePlant")
    public String deletePlant(@RequestParam("plantId") Long id) {
        plantService.deletePlant(id);

        return "redirect:/plant/list";
    }

    @GetMapping("/orderPlant")
    public String orderPlant(@RequestParam("plantId") Long id, Model model) {
        Plant plant = plantService.getPlant(id);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPlant(plant);

        model.addAttribute("orderInfo", orderInfo);

        return "plant-order-form";
    }

    @PostMapping("/savePlantOrder")
    public String savePlantOrder(@ModelAttribute("orderInfo") OrderInfo orderInfo) {
        orderInfoService.saveOrder(orderInfo);

        return "redirect:/plant/list";
    }

    @GetMapping("/searchPlant")
    public String searchClientByName(@RequestParam("searchPlant") String searchPlant, Model model) {
        List<Plant> plants = plantService.searchPlant(searchPlant);

        model.addAttribute("plants", plants);

        return "plants-list";
    }

    @GetMapping("/showPlantClients")
    public String showPlantClients(@RequestParam("plantId") Long id, Model model) {
        List<Client> clients = plantService.getPlantClients(id);
        Plant plant = plantService.getPlant(id);

        model.addAttribute("clients", clients);
        model.addAttribute("plant", plant);

        return "plant-clients";
    }

    @GetMapping("/showPlantDescription")
    public String showPlantDescription(@RequestParam("plantId") Long id, Model model) {
        Plant plant = plantService.getPlant(id);
        Description description = descriptionService.getDescription(plant.getDescription().getId());

        model.addAttribute("plant", plant);
        model.addAttribute("description", description);

        return "plant-description-form";
    }
}