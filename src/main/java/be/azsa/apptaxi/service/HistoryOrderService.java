package be.azsa.apptaxi.service;

import be.azsa.apptaxi.model.HistoryOrder;

import java.util.List;

public interface HistoryOrderService {
    //POST
    HistoryOrder save(HistoryOrder idHistoryOrder);

   //GET
    List<HistoryOrder> getAllHistoryOrder();
    List<HistoryOrder> getAllHistoryOrderByDriver(long idDriver);
    List<HistoryOrder> getAllHistoryOrderByCar(long idCar);

    //PUT
    HistoryOrder updateHistoryOrder(HistoryOrder historyOrder, long idHistoryOrder);

    //DELETER
    void deleteHistoryOrder(long idHistoryOrder);
}
