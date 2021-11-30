/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Restaurant.Dishes;
import java.util.ArrayList;

/**
 *
 * @author siddharthasavant
 */
public class Order {
    private String orderID;
    private String nameOfCustomer;
    private String nameOfRestaurant;
    private String cost;
    private String status;
    private String deliveryAddress;
    private String deliveryMan;
    private String feedback;
    private ArrayList<Dishes> Order;
    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
    
    public String getNameOfRestaurant() {
        return nameOfRestaurant;
    }

    public void setNameOfRestaurant(String nameOfRestaurant) {
        this.nameOfRestaurant = nameOfRestaurant;
    }
    
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public ArrayList<Dishes> getOrder() {
        return Order;
    }

    public void setOrder(ArrayList<Dishes> Order) {
        this.Order = Order;
    }

    @Override
    public String toString() {
        return orderID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
}
