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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author mrubrice
 */
@Entity
public class Expression1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String form;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String language;
    private String distinctCharacteristic;
    private String context;
    private String criticalResponse;
    
    @ManyToOne
    private Work1 work;
    @ManyToMany
    private List<Manifestation1>manifs;
    /*@OneToMany
    private List<Person1> pers;*/
    
    public Expression1(){
        
    }
    
    public Expression1(String ttl,String frm,Date dt,String lang,String dist,String ctxt,String critic){
        this.context=ctxt;
        this.criticalResponse=critic;
        this.date=dt;
        this.form=frm;
        this.distinctCharacteristic=dist;
        this.language=lang;
        this.title=ttl;
        //this.pers=new ArrayList<>();
        this.manifs=new ArrayList<>();
        this.work=new Work1();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDistinctCharacteristic() {
        return distinctCharacteristic;
    }

    public void setDistinctCharacteristic(String distinctCharacteristic) {
        this.distinctCharacteristic = distinctCharacteristic;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCriticalResponse() {
        return criticalResponse;
    }

    public void setCriticalResponse(String criticalResponse) {
        this.criticalResponse = criticalResponse;
    }

    public Work1 getWork() {
        return work;
    }

    public void setWork(Work1 work) {
        this.work = work;
    }

    public List<Manifestation1> getManifs() {
        return manifs;
    }

    public void setManifs(List<Manifestation1> manifs) {
        this.manifs = manifs;
    }
/*
    public List<Person1> getPers() {
        return pers;
    }

    public void setPers(List<Person1> pers) {
        this.pers = pers;
    }
    */
}
