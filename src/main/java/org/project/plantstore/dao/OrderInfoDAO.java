package org.project.plantstore.dao;

import org.project.plantstore.entity.OrderInfo;

import java.util.List;

public interface OrderInfoDAO {

    List<OrderInfo> getOrderList();

    OrderInfo getOrder(Long id);

    void saveOrder(OrderInfo orderInfo);

    void deleteOrder(Long id);

    List<OrderInfo> getOrderedPlants();

    List<OrderInfo> getRejectedOrders();

    List<OrderInfo> searchOrderByOrderId(Long orderId);

    List<OrderInfo> searchOrderByClientId(Long clientId);

    List<OrderInfo> searchOrderByPlantId(Long plantId);
}
