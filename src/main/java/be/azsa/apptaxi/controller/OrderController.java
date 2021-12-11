package be.azsa.apptaxi.controller;

import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.model.User;
import be.azsa.apptaxi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    //POST
    //build create order REST API
    @PostMapping("order/add")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    //GET
    //build get all ordres REST API
    @GetMapping("orders")
    public List<Order> getAllOrders(){ return orderService.getAllOrders();}

    //build get order by id REST API
    @GetMapping("order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long idOrder){
        return new ResponseEntity<>(orderService.getOrderById(idOrder), HttpStatus.OK);
    }

    //build get order by datetime REST API
    @GetMapping("order/date/{datetime}")
    public ResponseEntity<Order> getOrderByDatetime(@PathVariable("datetime") Date datetime){
        return new ResponseEntity<>(orderService.getOrderByDatetime(datetime), HttpStatus.OK);
    }

    //build get order by User
    @GetMapping("order/user")
    public List<Order> getOrderByUser (@RequestBody User user){
        return orderService.getAllUserOrders(user);
    }

    //PUT
    //build update order REST API
    @PutMapping("order/{id}/edit")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long idOrder, @RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrder(order, idOrder), HttpStatus.OK);
    }

    //DELETE
    //build delete order REST API
    @DeleteMapping("order/{id}/delete")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long idOrder){
        orderService.deleteOrder(idOrder);
        return new ResponseEntity<String>("Order deleted succefully!", HttpStatus.OK);
    }
}
