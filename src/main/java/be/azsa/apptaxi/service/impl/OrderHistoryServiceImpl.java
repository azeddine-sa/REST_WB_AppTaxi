package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.exception.ResourceNotFoundException;
import be.azsa.apptaxi.model.OrderHistory;
import be.azsa.apptaxi.repository.OrderHistoryRepository;
import be.azsa.apptaxi.service.OrderHistoryService;
import be.azsa.apptaxi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) { this.orderHistoryRepository = orderHistoryRepository; }

    @Override
    public OrderHistory save(OrderHistory orderHistory) { return orderHistoryRepository.save(orderHistory); }

    @Override
    public List<OrderHistory> getAllOrderHistory() { return orderHistoryRepository.findAll(); }

    @Override
    public List<OrderHistory> getAllOrderHistoryByDriver(long idDriver) {
        return orderHistoryRepository.findByDriver(idDriver);
    }

    @Override
    public List<OrderHistory> getAllOrderHistoryByCar(long idCar) {
        return orderHistoryRepository.findByCar(idCar);
    }

    @Override
    public List<OrderHistory> getAllOrderHistoryByUser(long userId) {
        return orderHistoryRepository.findByUser(userId);
    }

    @Override
    public OrderHistory updateOrderHistory(OrderHistory orderHistory, long idOrderHistory) {
        OrderHistory existingOH = orderHistoryRepository.findById(idOrderHistory).orElseThrow(
                () -> new ResourceNotFoundException("OrderHistory", "Id", idOrderHistory));

        existingOH.setCar(orderHistory.getCar());
        existingOH.setCar(orderHistory.getCar());

        orderHistoryRepository.save(existingOH);
        return existingOH;
    }

    @Override
    public void deleteOrderHistory(long idOrderHistory) {
        orderHistoryRepository.findById(idOrderHistory).orElseThrow(
                ()-> new ResourceNotFoundException("OrderHistory", "Id", idOrderHistory));

        orderHistoryRepository.deleteById(idOrderHistory);
    }
}
