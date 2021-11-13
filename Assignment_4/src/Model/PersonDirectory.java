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
public class PersonDirectory {
    private List<Person> personDirectory;
    private List<Person> temporaryPersonDirectory;

    public PersonDirectory() {
        this.personDirectory = new ArrayList<>();
        this.temporaryPersonDirectory = new ArrayList<>();
    }

    public List<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(List<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }

    public List<Person> getTemporaryPersonDirectory() {
        return temporaryPersonDirectory;
    }

    public void setTemporaryPersonDirectory(List<Person> temporaryPersonDirectory) {
        this.temporaryPersonDirectory = temporaryPersonDirectory;
    }
    
    public void addPerson(Person person){
        this.personDirectory.add(person);
    }
    
    public void searchFirstName(String name){
        for(Person person: personDirectory){
            if(person.getFirstName().equalsIgnoreCase(name)){
                this.temporaryPersonDirectory.add(person);
            }
        } 
    }
    
    public void searchLastName(String name){
        for(Person person: personDirectory){
            if(person.getLastName().equalsIgnoreCase(name)){
                this.temporaryPersonDirectory.add(person);
            }
        } 
    }
    
    public void copyToTemporary(){
        for(Person person: personDirectory){
            this.temporaryPersonDirectory.add(person);
        } 
    }
    
     public Person personFromOriginal(Person temp){
        for(Person person: personDirectory){
            if(person.getFirstName().equalsIgnoreCase(temp.getFirstName()) && person.getLastName().equalsIgnoreCase(temp.getLastName())){
                return person;
            }
        }
        return null;
    }
     
     public void clearTable(){
        temporaryPersonDirectory.clear();
    }
     
     public void addIdToPerson(){
         int num = 1;
        for(Person person: this.personDirectory){
            person.setId(String.format("%03d", num));
            num++;
        }
     }
    
}
