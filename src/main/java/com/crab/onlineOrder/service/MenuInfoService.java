package com.crab.onlineOrder.service;


import com.crab.onlineOrder.dao.MenuInfoDao;
import com.crab.onlineOrder.entity.MenuItem;
import com.crab.onlineOrder.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuInfoService {


    private final MenuInfoDao menuInfoDao;


    public MenuInfoService(MenuInfoDao menuInfoDao) {
        this.menuInfoDao = menuInfoDao;
    }


    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }


    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }


    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}
