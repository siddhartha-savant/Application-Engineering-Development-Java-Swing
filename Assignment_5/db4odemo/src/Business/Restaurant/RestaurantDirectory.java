/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
    private Restaurant restaurant;
    private ArrayList<Restaurant> listOfRestaurants;
    private Dishes menu;
    
    public RestaurantDirectory(){
        this.listOfRestaurants = new ArrayList<Restaurant>();
    }

    public ArrayList<Restaurant> getListOfRestaurants() {
        return listOfRestaurants;
    }

    public void setListOfRestaurants(ArrayList<Restaurant> listOfRestaurants) {
        this.listOfRestaurants = listOfRestaurants;
    }
    
    public Restaurant createRestaurantInfo(String userName){
        restaurant = new Restaurant(userName);
        listOfRestaurants.add(restaurant);
        return restaurant;
    }
    
    public void deleteRestaurent(String userName){
        for(int i=0; i<listOfRestaurants.size(); i++){
            if(listOfRestaurants.get(i).getUserNameOfAdmin().equals(userName)){
                listOfRestaurants.remove(i);
            }
        }
    }
    
    public void updateRestaurantInfo(Restaurant restaurantUpdate, String name, String number, String address){
        restaurantUpdate.setName(name);
        restaurantUpdate.setAddress(address);
        restaurantUpdate.setNumber(number);
    }
    
    public Dishes AddMenuDishes(Restaurant restaurantUpdate, String name, String desc, String amount){
        menu = new Dishes(name, desc, amount);
        restaurantUpdate.addDishes(menu);
        return menu;
    }
    
    public void DeleteDishes(Restaurant restro, Dishes menu){
        restro.removeDishes(menu);
        
    }
}
