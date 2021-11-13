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
public class Patient extends Person {
    
    private String id;
    
    public Patient(Person person, String id){
        super(person.getFirstName(), person.getLastName(), person.getHouse(), person.getAge(), person.getGender());
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
