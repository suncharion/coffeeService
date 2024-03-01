package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Orders;
import com.coffeeFranchise.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersRepository ordersRepository;

    public OrdersController(@Autowired OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // Получение списка всех заказов
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Создание нового заказа
    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    // Получение заказа по ID
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer id) {
        return ordersRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Обновление заказа
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer id, @RequestBody Orders orderDetails) {
        return ordersRepository.findById(id)
                .map(order -> {
                    // Предполагаем, что в вашем классе Orders есть методы set для обновления полей
                    // Пример обновления поля: order.setQuantity(orderDetails.getQuantity());
                    // Обновите поля заказа здесь, в соответствии с вашей моделью
                    Orders updatedOrder = ordersRepository.save(order);
                    return ResponseEntity.ok(updatedOrder);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Удаление заказа
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        return ordersRepository.findById(id)
                .map(order -> {
                    ordersRepository.delete(order);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}