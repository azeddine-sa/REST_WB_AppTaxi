package be.azsa.apptaxi.service;

import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.model.User;

import java.util.Date;
import java.util.List;

public interface OrderService {
    //POST
    Order saveOrder(Order order);

    //GET
    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order getOrderByDatetime(Date datetime);
    List<Order> getAllUserOrders(User user);

    //PUT
    Order updateOrder(Order order, long id);

    //DELETER
    void deleteOrder(long id);

}
