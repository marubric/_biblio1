/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oliviercailloux.y2017._biblio1.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author mrubrice
 */
@Entity
public class Person1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String designation;
    private Date dateBirth;
    private Date dateDeath;
    
    @ManyToMany(mappedBy="pers")
    private List<Work1> works;
    
    
    public Person1(){
        
    }
    
    public Person1(String first, String last, String design, Date dtB,Date  dtD){
        this.dateBirth=dtB;
        this.dateDeath=dtD;
        this.designation=design;
        this.firstName=first;
        this.lastName=last;
        this.works=new ArrayList<>();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(Date dateDeath) {
        this.dateDeath = dateDeath;
    }

    public List<Work1> getWorks() {
        return works;
    }

    public void setWorks(List<Work1> works) {
        this.works = works;
    }
/*
    @Override
    public String toString() {
        return "Person1{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", designation=" + designation + ", dateBirth=" + dateBirth + ", dateDeath=" + dateDeath + ", works=" + works + '}';
    }
    */
}
