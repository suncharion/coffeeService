package com.coffeeFranchise.service;

import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Menu;
import com.coffeeFranchise.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public Menu addMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found with id: " + id));
    }

    public Menu updateMenuItem(Long id, Menu menuDetails) {
        Menu menu = getMenuById(id);
        menu.setItemName(menuDetails.getItemName());
        menu.setItemPrice(menuDetails.getItemPrice());
        return menuRepository.save(menu);
    }

    public void deleteMenuItem(Long id) {
        Menu menu = getMenuById(id);
        menuRepository.delete(menu);
    }
}