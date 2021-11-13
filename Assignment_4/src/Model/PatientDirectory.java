/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author siddharthasavant
 */
public class PatientDirectory {
    private List<Patient> patientDirectory;

    public PatientDirectory() {
        this.patientDirectory = new ArrayList<>();
    }

    
    public List<Patient> getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(List<Patient> patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
    public void addPatient(Patient patient){
        this.patientDirectory.add(patient);
    }
    
    public boolean patientExists(Patient patient){
        for(Patient p : patientDirectory){
            if(p.getId().equals(patient.getId())){
                return true;
            }
        }
        return false;
    }
    
}
