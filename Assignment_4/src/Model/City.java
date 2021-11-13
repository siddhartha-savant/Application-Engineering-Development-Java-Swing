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
public class City {
    private String cityName;
    private Set<Community> communitySet;

    public City(String cityName) {
        this.cityName = cityName;
        this.communitySet = new HashSet<>();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Community> getCommunitySet() {
        return communitySet;
    }

    public void setCommunitySet(Set<Community> communitySet) {
        this.communitySet = communitySet;
    }
    
    public void addCommunity(Community community){
        this.communitySet.add(community);
    }
    
}


