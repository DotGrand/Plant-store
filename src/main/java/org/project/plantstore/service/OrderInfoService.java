package org.project.plantstore.service;

import org.project.plantstore.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> getOrderList();

    void saveOrder(OrderInfo orderInfo);

    void deleteOrder(Long id);

    OrderInfo getOrder(Long id);

    void changeOrderStatus(Long id);

    List<OrderInfo> getOrderedPlants();

    List<OrderInfo> getRejectedOrders();

    List<OrderInfo> searchOrderByOrderId(Long orderId);

    List<OrderInfo> searchOrderByClientId(Long clientId);

    List<OrderInfo> searchOrderByPlantId(Long plantId);


}
