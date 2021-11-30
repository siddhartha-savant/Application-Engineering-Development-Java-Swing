/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.Order.Order;
import Business.Restaurant.Dishes;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryMan {
    private String nameOfDeliveryMan;
    private String userNameOfDeliveryMan;
    private String address;
    private String number;
    private ArrayList<Order> orderList;
    
    public DeliveryMan(String userName){
        this.userNameOfDeliveryMan = userName;
        orderList = new ArrayList<Order>();
    }
    
    public String getNameOfDeliveryMan() {
        return nameOfDeliveryMan;
    }

    public void setNameOfDeliveryMan(String nameOfDeliveryMan) {
        this.nameOfDeliveryMan = nameOfDeliveryMan;
    }
    
    public String getUserNameOfDeliveryMan() {
        return userNameOfDeliveryMan;
    }

    public void setUserNameOfDeliveryMan(String userNameOfDeliveryMan) {
        this.userNameOfDeliveryMan = userNameOfDeliveryMan;
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
    
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> order) {
        this.orderList = order;
    }
    
    public void addOrder(String nameOfRestaurant, String nameOfCustomer, String deliveryMan, ArrayList<Dishes> Order, String cost, String deliveryAddress) {
        
        Order order = new Order();
        order.setNameOfCustomer(nameOfCustomer);
        order.setCost(cost);
        order.setDeliveryMan(deliveryMan);
        order.setDeliveryAddress(deliveryAddress);
        order.setNameOfRestaurant(nameOfRestaurant);
        order.setOrder(Order);

        order.setStatus("New Order");
        orderList.add(order);
    }
    
    @Override
    public String toString() {
        return userNameOfDeliveryMan;
    }
}
