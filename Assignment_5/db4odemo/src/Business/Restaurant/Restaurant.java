/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Order.Order;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Restaurant {
    
    private int id = 501;
    private String userNameOfAdmin;
    private String name;
    private String address;
    private String number;
    private ArrayList<Dishes> listOfDishes;
    private ArrayList<Order> listOfOrders;
    
    public Restaurant(String userName) {
        this.userNameOfAdmin = userName;
        listOfDishes = new ArrayList<Dishes>();
        listOfOrders = new ArrayList<Order>();
    }
    
    public String getUserNameOfAdmin() {
        return userNameOfAdmin;
    }

    public void setUserNameOfAdmin(String userNameOfAdmin) {
        this.userNameOfAdmin = userNameOfAdmin;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(ArrayList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public ArrayList<Dishes> getListOfDishes() {
        return listOfDishes;
    }
    
    public void addDishes(Dishes menu){
        listOfDishes.add(menu);
    }

    public void removeDishes(Dishes menu){
        listOfDishes.remove(menu);
    }
    
    public void addOrder(String nameOfRestaurant, String nameOfCustomer, String deliveryMan, ArrayList<Dishes> Order, String cost, String deliveryAddress) {
        Order order = new Order();
        order.setOrderID(String.valueOf(id));
        order.setOrder(Order);
        order.setCost(cost);
        order.setNameOfRestaurant(nameOfRestaurant);
        order.setNameOfCustomer(nameOfCustomer);
        order.setDeliveryMan(deliveryMan);   
        order.setDeliveryAddress(deliveryAddress);
        order.setStatus("New Order");
        listOfOrders.add(order);
        id++;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
