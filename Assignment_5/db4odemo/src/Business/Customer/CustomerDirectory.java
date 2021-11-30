/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    
    private Customer customer;
    private ArrayList<Customer> listOfCustomers;
    
    public CustomerDirectory(){
        this.listOfCustomers = new ArrayList<Customer>();
    }
    
    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public Customer createCustomer(String userName){
        customer = new Customer(userName);
        listOfCustomers.add(customer);
        return customer;
    }
    
    public void deleteCustomer(String userName){
        for(int i=0; i<listOfCustomers.size(); i++){
            if(listOfCustomers.get(i).getUserNameOfCustomer().equals(userName)){
                listOfCustomers.remove(i);
            }
        }
    }
}
