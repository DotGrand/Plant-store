package org.project.plantstore.controller;

import org.project.plantstore.entity.Client;
import org.project.plantstore.entity.OrderInfo;
import org.project.plantstore.entity.Plant;
import org.project.plantstore.service.ClientService;
import org.project.plantstore.service.OrderInfoService;
import org.project.plantstore.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private PlantService plantService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/list")
    public String showOrders(Model model) {
        List<OrderInfo> orders = orderInfoService.getOrderList();

        model.addAttribute("orders", orders);

        return "orders-list";
    }

    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("statusId") Long id) {
        orderInfoService.changeOrderStatus(id);

        return "redirect:/order/list";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") Long id) {
        orderInfoService.deleteOrder(id);

        return "redirect:/order/list";
    }

    @GetMapping("/showOrderedPlants")
    public String showOrderedPlants(Model model) {
        List<OrderInfo> orderedPlants = orderInfoService.getOrderedPlants();

        model.addAttribute("orders", orderedPlants);

        return "orders-list";
    }

    @GetMapping("/showRejectedOrders")
    public String showRejectedOrders(Model model) {
        List<OrderInfo> rejectedOrders = orderInfoService.getRejectedOrders();

        model.addAttribute("orders", rejectedOrders);

        return "orders-list";
    }

    @GetMapping("/showMoreOrderDetails")
    public String showMoreOrderDetails(@RequestParam("orderId") Long orderId, Model model) {
        OrderInfo orderInfo = orderInfoService.getOrder(orderId);
        Plant plant = plantService.getPlant(orderInfo.getPlant().getId());
        Client client = clientService.getClient(orderInfo.getClient().getId());

        model.addAttribute("order", orderInfo);
        model.addAttribute("plant", plant);
        model.addAttribute("client", client);

        return "order-details";
    }

    @GetMapping("/searchByOrderId")
    public String searchByOrderId(@RequestParam("orderId") Long orderId, Model model) {
        List<OrderInfo> orders = orderInfoService.searchOrderByOrderId(orderId);

        model.addAttribute("orders", orders);

        return "orders-list";
    }

    @GetMapping("/searchByClientId")
    public String searchByClientId(@RequestParam("clientId") Long clientId, Model model) {
        List<OrderInfo> orders = orderInfoService.searchOrderByClientId(clientId);

        model.addAttribute("orders", orders);

        return "orders-list";
    }

    @GetMapping("/searchByPlantId")
    public String searchByPlantId(@RequestParam("plantId") Long plantId, Model model) {
        List<OrderInfo> orders = orderInfoService.searchOrderByPlantId(plantId);

        model.addAttribute("orders", orders);

        return "orders-list";
    }
}
