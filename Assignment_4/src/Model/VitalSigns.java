/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author siddharthasavant
 */
public class VitalSigns {
    private int bodyTemperature;
    private int pulseRate;
    private int respiratoryRate;
    private float[] bloodPressure;

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public float[] getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float[] bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    
}

