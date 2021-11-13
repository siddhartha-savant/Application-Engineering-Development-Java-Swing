/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author siddharthasavant
 */
public class Community {
    private String communityName;
    private Set<House> houseSet;
    private City city; 

    public Community(String communityName) {
        this.communityName = communityName;
        this.houseSet = new HashSet<>();
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Set<House> getHouseSet() {
        return houseSet;
    }

    public void setHouseSet(Set<House> houseSet) {
        this.houseSet = houseSet;
    }

    public void addHouse(House house){
        this.houseSet.add(house);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
