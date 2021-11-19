package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.exception.ResourceNotFoundException;
import be.azsa.apptaxi.model.HistoryOrder;
import be.azsa.apptaxi.repository.HistoryOrderRepository;
import be.azsa.apptaxi.service.HistoryOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryOrderServiceImpl implements HistoryOrderService {

    private HistoryOrderRepository historyOrderRepository;

    public HistoryOrderServiceImpl(HistoryOrderRepository historyOrderRepository) { this.historyOrderRepository = historyOrderRepository; }

    @Override
    public HistoryOrder save(HistoryOrder historyOrder) { return historyOrderRepository.save(historyOrder); }

    @Override
    public List<HistoryOrder> getAllHistoryOrder() { return historyOrderRepository.findAll(); }
    @Override
    public List<HistoryOrder> getAllHistoryOrderByDriver(long idDriver) { return historyOrderRepository.findByDriver(idDriver); }
    @Override
    public List<HistoryOrder> getAllHistoryOrderByCar(long idCar) {
        return historyOrderRepository.findByCar(idCar);
    }

    @Override
    public HistoryOrder updateHistoryOrder(HistoryOrder historyOrder, long idHistoryOrder) {
        HistoryOrder existingOH = historyOrderRepository.findById(idHistoryOrder).orElseThrow(
                () -> new ResourceNotFoundException("HistoryOrder", "Id", idHistoryOrder));

        existingOH.setCar(historyOrder.getCar());
        existingOH.setCar(historyOrder.getCar());

        historyOrderRepository.save(existingOH);
        return existingOH;
    }

    @Override
    public void deleteHistoryOrder(long idHistoryOrder) {
        historyOrderRepository.findById(idHistoryOrder).orElseThrow(
                ()-> new ResourceNotFoundException("HistoryOrder", "Id", idHistoryOrder));

        historyOrderRepository.deleteById(idHistoryOrder);
    }
}
