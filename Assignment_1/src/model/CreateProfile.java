/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author siddharthasavant
 */
public class CreateProfile {
    
    private BankAccountDetails bankAccountDetails;
    private BasicDetails basicDetails;
    private GeographicDetails geographicDetails;
    private MedicalDetails medicalDetails;
    private VehicleDetails vehicleDetails;
    private OnlineIdentityDetails onlineIdentityDetails;

    public BankAccountDetails getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(BankAccountDetails bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    public GeographicDetails getGeographicDetails() {
        return geographicDetails;
    }

    public void setGeographicDetails(GeographicDetails geographicDetails) {
        this.geographicDetails = geographicDetails;
    }

    public MedicalDetails getMedicalDetails() {
        return medicalDetails;
    }

    public void setMedicalDetails(MedicalDetails medicalDetails) {
        this.medicalDetails = medicalDetails;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public OnlineIdentityDetails getOnlineIdentityDetails() {
        return onlineIdentityDetails;
    }

    public void setOnlineIdentityDetails(OnlineIdentityDetails onlineIdentityDetails) {
        this.onlineIdentityDetails = onlineIdentityDetails;
    }
    
}


