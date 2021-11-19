package be.azsa.apptaxi.service;

import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    //POST
    OrderHistory save(OrderHistory orderHistory);

   //GET
    List<OrderHistory> getAllOrderHistory();
    List<OrderHistory> getAllOrderHistoryByDriver(long idDriver);
    List<OrderHistory> getAllOrderHistoryByCar(long idCar);
    List<OrderHistory> getAllOrderHistoryByUser(long userId);

    //PUT
    OrderHistory updateOrderHistory(OrderHistory orderHistory, long idOrderHistory);

    //DELETER
    void deleteOrderHistory(long idOrderHistory);
}
