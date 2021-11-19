package be.azsa.apptaxi.controller;

import be.azsa.apptaxi.model.HistoryOrder;
import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.service.HistoryOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryOrderController {

    private HistoryOrderService historyOrderService;

    public HistoryOrderController(HistoryOrderService historyOrderService) { this.historyOrderService = historyOrderService; }

    //POST
    //build create historyOrder REST API
    @PostMapping("history/add")
    public ResponseEntity<HistoryOrder> saveHistoryOrder(@RequestBody HistoryOrder historyOrder){
        return new ResponseEntity<>(historyOrderService.save(historyOrder), HttpStatus.CREATED);
    }

    //GET
    //build get all historyOrder REST API
    @GetMapping("historys")
    public List<HistoryOrder> getAllHistory(){ return historyOrderService.getAllHistoryOrder(); }

    //build get historyOrder by driver REST API
    @GetMapping("history/driver/{idDriver}")
    public List<HistoryOrder> getHistoryByDriver(@PathVariable("id") long idDriver){
        return historyOrderService.getAllHistoryOrderByDriver(idDriver);
    }

    //build get historyOrder by car REST API
    @GetMapping("history/car/{idCar}")
    public List<HistoryOrder> getHistoryByCar(@PathVariable("id") long idCar){
        return historyOrderService.getAllHistoryOrderByCar(idCar);
    }

    //PUT
    //build update historyOrder REST API
    @PutMapping("history/{id}/edit")
    public ResponseEntity<HistoryOrder> updateHistory(@PathVariable("id") long idHistory, @RequestBody HistoryOrder historyOrder){
        return new ResponseEntity<>(historyOrderService.updateHistoryOrder(historyOrder, idHistory), HttpStatus.OK);
    }

    //DELETE
    //build delete historyOrder REST API
    @DeleteMapping("history/{id}/delete")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long idHistory){
        historyOrderService.deleteHistoryOrder(idHistory);
        return new ResponseEntity<String>("Order deleted succefully!", HttpStatus.OK);
    }
}
