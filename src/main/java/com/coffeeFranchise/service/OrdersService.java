package com.coffeeFranchise.service;

import com.coffeeFranchise.dto.OrderDTO;
import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Orders;
import com.coffeeFranchise.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersService {

    public OrderDTO toOrderDTO(Orders order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getMenu().getId());
        dto.setQuantity(order.getQuantity());
        dto.getItemTotal(order.calculateItemTotal());
        return dto;
    }

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return ordersRepository.findAll();
    }

    public OrderDTO createOrder(OrderDTO order) {
        return ordersRepository.save(order);
    }

    public BigDecimal calculateTotalOrderCost(List<OrderDTO> orderDTOs) {
        return orderDTOs.stream()
                .map(OrderDTO::getItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OrderDTO getOrderById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDetails) {
        OrderDTO order = getOrderById(id);
        return ordersRepository.save(order);
    }

    public void deleteOrder(Long id) {
        OrderDTO order = getOrderById(id);
        ordersRepository.delete(order);
    }
}