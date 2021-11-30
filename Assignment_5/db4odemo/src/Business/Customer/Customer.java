/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Order.Order;
import Business.Restaurant.Dishes;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Customer {
    
    private int id = 501;
    private String nameOfCustomer;
    private String userNameOfCustomer;
    private ArrayList<Order> orderList;
    private String address;
    private String number;
    
    public Customer(String UserName){
        this.userNameOfCustomer = UserName;
        orderList = new ArrayList<Order>();
    }
    
    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
    
    public String getUserNameOfCustomer() {
        return userNameOfCustomer;
    }

    public void setUserNameOfCustomer(String userNameOfCustomer) {
        this.userNameOfCustomer = userNameOfCustomer;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> order) {
        this.orderList = order;
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
    
    public void addOrder(String nameOfRestaurant, String nameOfCustomer, String deliveryPerson, ArrayList<Dishes> Order, String cost, String deliveryAddress) {
        Order order = new Order();
        order.setOrderID(String.valueOf(id));
        order.setCost(cost);
        order.setDeliveryAddress(deliveryAddress);
        order.setDeliveryMan(deliveryPerson);
        order.setNameOfCustomer(nameOfCustomer);
        order.setNameOfRestaurant(nameOfRestaurant);
        order.setOrder(Order);
        
        order.setStatus("New Order");
        orderList.add(order);
        id++;
    }

}
