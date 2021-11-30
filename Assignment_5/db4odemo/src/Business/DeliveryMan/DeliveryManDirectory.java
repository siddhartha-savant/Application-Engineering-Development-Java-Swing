/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
    
    private DeliveryMan deliveryMan;
    private ArrayList<DeliveryMan> listOfDeliveryMan;
    
    public DeliveryManDirectory() {
        listOfDeliveryMan = new ArrayList<DeliveryMan>();
    }

    public ArrayList<DeliveryMan> getListOfDeliveryMan() {
        return listOfDeliveryMan;
    }

    public void setListOfDeliveryMan(ArrayList<DeliveryMan> listOfDeliveryMan) {
        this.listOfDeliveryMan = listOfDeliveryMan;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
    
    public DeliveryMan createDeliveryMan(String userName){
        deliveryMan = new DeliveryMan(userName);
        listOfDeliveryMan.add(deliveryMan);
        return deliveryMan;
    }
    
    public void deleteDeliveryMan(String userName){
        for(int i=0; i<listOfDeliveryMan.size(); i++){
            if(listOfDeliveryMan.get(i).getUserNameOfDeliveryMan().equals(userName)){
                listOfDeliveryMan.remove(i);
            }
        }
    }
}
