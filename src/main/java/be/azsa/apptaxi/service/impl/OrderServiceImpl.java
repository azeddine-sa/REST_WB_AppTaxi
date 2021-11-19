package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.exception.ResourceNotFoundException;
import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.repository.OrderRepository;
import be.azsa.apptaxi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) { return orderRepository.save(order); }

    @Override
    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Order", "Id", id));
    }

    @Override
    public Order getOrderByDatetime(Date datetime) {
        return orderRepository.findByDatetime(datetime).orElseThrow(
                ()-> new ResourceNotFoundException("Order", "Datetime", datetime));
    }

    @Override
    public Order updateOrder(Order order, long id) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Order", "Id", id));

        existingOrder.setDeparture(order.getDeparture());
        existingOrder.setArrival(order.getArrival());
        existingOrder.setDatetime(order.getDatetime());
        existingOrder.setInfos(order.getInfos());

        //save existing order to DB
        orderRepository.save(existingOrder);
        return existingOrder;
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Order", "Id", id));

        orderRepository.deleteById(id);
    }
}
