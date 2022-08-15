package org.project.plantstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.Plant;
import org.project.plantstore.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // trims white spaces to resolve validation issue
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String listClients(Model model) {
        List<Client> clients = clientService.getClients();

        model.addAttribute("clients", clients);

        return "clients-list";
    }

    @GetMapping("/addClientForm")
    public String addClientForm(Model model) {
        Client client = new Client();

        model.addAttribute("client", client);

        return "client-save-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "client-save-form";
        } else {
            clientService.saveClient(client);
            return "redirect:/client/list";
        }
    }

    @GetMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") Long id, Model model) {
        Client client = clientService.getClient(id);

        model.addAttribute("client", client);

        return "client-save-form";
    }

    @GetMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") Long id) {
        clientService.deleteClient(id);

        return "redirect:/client/list";
    }

    @GetMapping("/searchByName")
    public String searchClients(@RequestParam("searchName") String searchName, Model model) {
        List<Client> clients = clientService.searchClients(searchName);

        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @GetMapping("/showClientPlants")
    public String showClientPlants(@RequestParam("clientId") Long id, Model model) {
        List<Plant> plants = clientService.getClientPlants(id);
        Client client = clientService.getClient(id);

        model.addAttribute("plants", plants);
        model.addAttribute("client", client);

        return "client-plants";
    }
}
