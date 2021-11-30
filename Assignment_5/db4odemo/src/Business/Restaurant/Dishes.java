/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

/**
 *
 * @author siddharthasavant
 */
public class Dishes {
    
    private String nameOfDish;
    private String descriptionOfDish;
    private String costOfDish;


    public Dishes(String name, String description, String price) {
        this.nameOfDish = name;
        this.costOfDish = price;
        this.descriptionOfDish = description;
    }
    
    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }
    
    public String getDescriptionOfDish() {
        return descriptionOfDish;
    }

    public void setDescriptionOfDish(String descriptionOfDish) {
        this.descriptionOfDish = descriptionOfDish;
    }

    public String getCostOfDish() {
        return costOfDish;
    }

    public void setCostOfDish(String costOfDish) {
        this.costOfDish = costOfDish;
    }

    @Override
    public String toString() {
        return nameOfDish;
    }
}
