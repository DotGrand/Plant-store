package org.project.plantstore.service;

import org.project.plantstore.dao.OrderInfoDAO;
import org.project.plantstore.dao.PlantDAO;
import org.project.plantstore.entity.OrderInfo;
import org.project.plantstore.entity.Plant;
import org.project.plantstore.exception.NotEnoughPlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

    private final static String STATUS_ORDERED = "ORDERED";
    private final static String STATUS_REJECTED = "REJECTED";

    @Autowired
    private OrderInfoDAO orderInfoDAO;

    @Autowired
    private PlantDAO plantDAO;

    @Override
    public List<OrderInfo> getOrderList() {
        return orderInfoDAO.getOrderList();
    }

    @Override
    public void saveOrder(OrderInfo orderInfo) {
        Long plantId = orderInfo.getPlant().getId();

        changePlantQuantityAfterOrder(plantId);

        Plant plant = plantDAO.getPlant(plantId);
        plant.addClient(orderInfo.getClient());

        orderInfo.setDateOfOrder(new Date());
        orderInfo.setStatus(STATUS_ORDERED);

        orderInfoDAO.saveOrder(orderInfo);
    }

    @Override
    public void deleteOrder(Long id) {
        OrderInfo orderInfo = orderInfoDAO.getOrder(id);

        if (orderInfo != null) {
            orderInfo.getPlant().removeClient(orderInfo.getClient());
        }

        if (orderInfo.getPlant() == null) {
        } else if (orderInfo.getStatus().equals(STATUS_ORDERED)) {
            // if delete orderInfo when order "REJECTED" set plant quantity +1 to avoid plant leak
            orderInfo.getPlant().setQuantity(orderInfo.getPlant().getQuantity() + 1);
        }
        orderInfoDAO.deleteOrder(id);
    }

    @Override
    public OrderInfo getOrder(Long id) {
        return orderInfoDAO.getOrder(id);
    }

    @Override
    public void changeOrderStatus(Long id) {
        OrderInfo orderInfo = orderInfoDAO.getOrder(id);
        String orderStatus = orderInfo.getStatus();

        if (orderInfo.getPlant() == null) {
            if (orderStatus.equals(STATUS_ORDERED)) {
                orderStatus = STATUS_REJECTED;
            } else {
                orderStatus = STATUS_ORDERED;
            }
        } else {
            if (orderStatus.equals(STATUS_ORDERED)) {
                orderInfo.getPlant().removeClient(orderInfo.getClient());
                orderStatus = STATUS_REJECTED;
                orderInfo.getPlant().setQuantity(orderInfo.getPlant().getQuantity() + 1);
            } else {
                orderInfo.getPlant().addClient(orderInfo.getClient());
                orderStatus = STATUS_ORDERED;
                orderInfo.getPlant().setQuantity(orderInfo.getPlant().getQuantity() - 1);
            }
        }
        orderInfo.setStatus(orderStatus);
    }

    @Override
    public List<OrderInfo> getOrderedPlants() {
        return orderInfoDAO.getOrderedPlants();
    }

    @Override
    public List<OrderInfo> getRejectedOrders() {
        return orderInfoDAO.getRejectedOrders();
    }

    @Override
    public List<OrderInfo> searchOrderByOrderId(Long orderId) {
        return orderInfoDAO.searchOrderByOrderId(orderId);
    }

    @Override
    public List<OrderInfo> searchOrderByClientId(Long clientId) {
        return orderInfoDAO.searchOrderByClientId(clientId);
    }

    @Override
    public List<OrderInfo> searchOrderByPlantId(Long plantId) {
        return orderInfoDAO.searchOrderByPlantId(plantId);
    }

    private void changePlantQuantityAfterOrder(Long plantId) {
        Plant plant = plantDAO.getPlant(plantId);
        int plantQuantity = plant.getQuantity();

        if (plantQuantity > 0) {
            plant.setQuantity(plantQuantity - 1);
        } else {
            throw new NotEnoughPlantException();
        }
    }
}
