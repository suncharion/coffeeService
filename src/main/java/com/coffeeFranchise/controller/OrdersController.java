package com.coffeeFranchise.controller;

import com.coffeeFranchise.dto.OrderDTO;
import com.coffeeFranchise.model.Orders;
import com.coffeeFranchise.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO order) {
        return ordersService.createOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO order = ordersService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDetails) {
        OrderDTO updatedOrder = ordersService.updateOrder(id, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> getOrderTotal(@PathVariable Long id) {
        OrderDTO order = ordersService.getOrderById(id);
        BigDecimal total = order.calculateItemTotal();
        return ResponseEntity.ok(total);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}