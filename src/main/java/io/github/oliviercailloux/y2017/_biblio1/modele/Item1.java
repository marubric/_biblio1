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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author mrubrice
 */
@Entity
public class Item1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String identifier;
    private String provenance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date exhibitionDate;
    
    @OneToMany(mappedBy="itm")
    private List<Manifestation1>manifs;
    
    
    public Item1(){
        
    }
    
    public Item1(String ident,String prov,Date dt){
        this.exhibitionDate=dt;
        this.identifier=ident;
        this.provenance=prov;
        //pers=new ArrayList<>();
        manifs=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public Date getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(Date exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public List<Manifestation1> getManifs() {
        return manifs;
    }

    public void setManifs(List<Manifestation1> manifs) {
        this.manifs = manifs;
    }

    /*public List<Person1> getPers() {
        return pers;
    }

    public void setPers(List<Person1> pers) {
        this.pers = pers;
    }*/
    
}
