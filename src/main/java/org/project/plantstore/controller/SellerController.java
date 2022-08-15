package org.project.plantstore.controller;

import org.project.plantstore.entity.Seller;
import org.project.plantstore.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String showSellers(Model model) {
        List<Seller> sellers = sellerService.getSellers();

        model.addAttribute("sellers", sellers);

        return "sellers-list";
    }

    @GetMapping("/addSellerForm")
    public String addSellerForm(Model model) {
        Seller seller = new Seller();

        model.addAttribute("seller", seller);

        return "seller-save-form";
    }

    @PostMapping("/saveSeller")
    public String saveSeller(@Valid @ModelAttribute("seller") Seller seller, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "seller-save-form";
        } else {
            sellerService.saveSeller(seller);
        }

        return "redirect:/seller/list";
    }

    @GetMapping("/updateSeller")
    public String updateSeller(@RequestParam("sellerId") Long id, Model model) {
        Seller seller = sellerService.getSeller(id);

        model.addAttribute("seller", seller);

        return "seller-save-form";
    }

    @GetMapping("/deleteSeller")
    public String deleteSeller(@RequestParam("sellerId") Long id) {
        sellerService.deleteSeller(id);

        return "redirect:/seller/list";

    }

    @GetMapping("/searchSeller")
    public String searchSeller(@RequestParam("searchSeller") String searchSeller, Model model) {
        List<Seller> sellers = sellerService.searchSeller(searchSeller);

        model.addAttribute("sellers", sellers);

        return "sellers-list";
    }
}
