/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author siddharthasavant
 */
public class FleetOfCars {
    private ArrayList<Car> totalDatabase;
    private ArrayList<Car> temporaryDatabase;
    private ArrayList<String> stringName;
    private HashSet<String> set;
    
    public FleetOfCars(){
        this.totalDatabase = new ArrayList<>();
        this.temporaryDatabase = new ArrayList<>();
        this.stringName = new ArrayList<>();
        this.set = new HashSet();
    }

    public ArrayList<Car> getTotalDatabase() {
        return totalDatabase;
    }

    public void setTotalDatabase(ArrayList<Car> totalDatabase) {
        this.totalDatabase = totalDatabase;
    }
    
    public void addCar(Car car){
        this.totalDatabase.add(car);
    }
    
    public void addCarToTemporaryDatabase(Car car){
        this.temporaryDatabase.add(car);
    }

    public ArrayList<Car> getTemporaryDatabase() {
        return temporaryDatabase;
    }

    public void setTemporaryDatabase(ArrayList<Car> temporaryDatabase) {
        this.temporaryDatabase = temporaryDatabase;
    }

    public ArrayList<String> getStringName() {
        return stringName;
    }

    public void setStringName(ArrayList<String> stringName) {
        this.stringName = stringName;
    }

    public HashSet<String> getSet() {
        return set;
    }

    public void setSet(HashSet<String> set) {
        this.set = set;
    }
    
    
    public int size(FleetOfCars fleet){
        return fleet.totalDatabase.size();
    }
    
    public void searchManufacturerName(String name){
        for(Car car: totalDatabase){
            if(car.getManufacturerName().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        } 
    }
    
    public void searchCarName(String name){
        for(Car car: totalDatabase){
            if(car.getCarName().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchModelName(String name){
        for(Car car: totalDatabase){
            if(car.getModelName().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchYearOfManufacture(String name){
        for(Car car: totalDatabase){
            if(car.getYearOfManufacture()==Integer.parseInt(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchNumberOfSeats(String name){
        for(Car car: totalDatabase){
            if(car.getNumberOfSeats()==Integer.parseInt(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchSerialNumber(String name){
        for(Car car: totalDatabase){
            if(car.getSerialNumberOfCar().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchCompanyName(String name){
        for(Car car: totalDatabase){
            if(car.getCompanyName().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchCityName(String name){
        for(Car car: totalDatabase){
            if(car.getCityName().equalsIgnoreCase(name)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchFirstAvailableCar(){
        for(Car car: totalDatabase){
            if(car.isAvailability()){
                this.temporaryDatabase.add(car);
                break;
            }
        }
    }
    
    public void numberOfAvailableCars(){
        for(Car car: totalDatabase){
            if(car.isAvailability()){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void clearTable(){
        temporaryDatabase.clear();
    }
    
    public void clearString(){
        stringName.clear();
    }
    
    public void searchMaintainanceCertificate(String name){
        String name2;
        for(Car car: totalDatabase){
            if(car.isMaintainanceCertificate()){
                name2 = "Valid";
            }else{
                name2 = "Expired";
            }
            if(name.equalsIgnoreCase(name2)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    
    public void searchAvailability(String name){
        String name2;
        for(Car car: totalDatabase){
            if(car.isAvailability()){
                name2 = "Yes";
            }else{
                name2 = "No";
            }
            if(name.equalsIgnoreCase(name2)){
                this.temporaryDatabase.add(car);
            }
        }
    }
    
    public void searchManufacturerList(){
        for(Car car : totalDatabase){
            stringName.add(car.getManufacturerName());
            stringName = (ArrayList) stringName.stream().distinct().collect(Collectors.toList());
        }
    }
    
    public void searchCarSeatsList(int min, int max){
        for(Car car: totalDatabase){
            if(min <= car.getNumberOfSeats() && max >= car.getNumberOfSeats()){
                temporaryDatabase.add(car);
            }
        }
    }
    
}
