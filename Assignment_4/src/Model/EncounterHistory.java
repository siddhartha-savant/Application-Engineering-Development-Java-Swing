/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author siddharthasavant
 */
public class EncounterHistory {
    private Map<Patient, List<Encounter>> map;

    public EncounterHistory() {
        this.map = new HashMap<>();
    }

    
    public Map<Patient, List<Encounter>> getMap() {
        return map;
    }

    public void setMap(Map<Patient, List<Encounter>> map) {
        this.map = map;
    }
    
    public void addEncounter(Encounter encounter){
        if(!this.map.containsKey(encounter.getPatient())){
            List<Encounter> list = new ArrayList<>();
            list.add(encounter);
            this.map.put(encounter.getPatient(), list);
            System.out.println("Encounter is created");
            
        }else{
            List<Encounter> list = this.map.get(encounter.getPatient());
            list.add(encounter);
            System.out.println("More Encounters are added");
            for(Encounter e: list){
                System.out.println(e.getPatient().getFirstName() + " " + e.getVitalSigns().getBloodPressure()[0] + " " + e.getVitalSigns().getBloodPressure()[1]);
            }
        }
        
//        System.out.println(encounter.getPatient().getFirstName());
//        System.out.println(encounter.getPatient().getLastName());
//        System.out.println(encounter.getVitalSigns().getBloodPressure()[0]);
//        System.out.println(encounter.getVitalSigns().getBloodPressure()[1]);
        
        
    }
    
    public List<Encounter> searchAbnormalBP(String name){
        
        System.out.println(map.values());
        System.out.println(name);
        List<Encounter> abnormalList = new ArrayList<>();
//        for(Patient patient: map.keySet()){
//            if(patient.getHouse().getCommunity().getCommunityName().equals(name)){
//                List<Encounter> l = map.get(patient);
//                for(Encounter encounter: l){
//                    float sysBP = encounter.getVitalSigns().getBloodPressure()[0];
//                    float diaBP = encounter.getVitalSigns().getBloodPressure()[1];
//                    int age = encounter.getPatient().getAge();
//                    if(age>=21 && age<=25 && sysBP>120.5 && diaBP>78.5){
//                        abnormalList.add(encounter);
//                    }
//                }
//            }
//        }
        for(Map.Entry<Patient, List<Encounter>> e : this.map.entrySet()){
            if(e.getKey().getHouse().getCommunity().getCommunityName().equalsIgnoreCase(name)){
                for(Encounter en: e.getValue()){
                    float sysBP = en.getVitalSigns().getBloodPressure()[0];
                    float diaBP = en.getVitalSigns().getBloodPressure()[1];
                    int age = en.getPatient().getAge();
                    if(age>=21 && age<=25 && (sysBP>120.5 || diaBP>78.5 || sysBP<115.5 || diaBP<68.5)){
                        abnormalList.add(en);
                    }else if(age>=26 && age<=30 && (sysBP>119.5 || diaBP>76.5 || sysBP<105.5 || diaBP<63.5)){
                        abnormalList.add(en);
                    }else if(age>=31 && age<=35 && (sysBP>114.5 || diaBP>75.5 || sysBP<100.5 || diaBP<60.5)){
                        abnormalList.add(en);
                    }
                }
            }
        }
        return abnormalList;
    }
    
}
