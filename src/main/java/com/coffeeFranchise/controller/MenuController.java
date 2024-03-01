package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Menu;
import com.coffeeFranchise.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(@Autowired MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @PostMapping
    public Menu addMenuItem(@RequestBody Menu menuItem) {
        return menuRepository.save(menuItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuItemById(@PathVariable Integer id) {
        return menuRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenuItem(@PathVariable Integer id, @RequestBody Menu menuItemDetails) {
        return menuRepository.findById(id)
                .map(menuItem -> {
                    menuItem.setItemName(menuItemDetails.getItemName());
                    menuItem.setItemPrice(menuItemDetails.getItemPrice());
                    // Добавьте здесь обновление других полей, если они есть
                    Menu updatedMenuItem = menuRepository.save(menuItem);
                    return ResponseEntity.ok(updatedMenuItem);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Integer id) {
        return menuRepository.findById(id)
                .map(menuItem -> {
                    menuRepository.delete(menuItem);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}