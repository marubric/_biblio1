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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author mrubrice
 */
@Entity
public class Work implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String form;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String context;
    private String distinctCharacteristic;
    private String intendedAudience;

    @ManyToMany
    private List<Person> pers;
    @OneToMany(mappedBy="work",cascade=CascadeType.ALL)
    private List<Expression> exprs;
    /*@ManyToOne
    private CorporateBody cbs;
    @ManyToMany(mappedBy="works")
    private List<Place>plcs;
    @ManyToMany(mappedBy="works")
    private List<Event>Evts;
    @ManyToMany(mappedBy="works")
    private List<Object>objs;
    @ManyToMany(mappedBy="works")
    private List<Concept>cpts;
    */
    public Work() {
        
    }
    
    public Work(String title,String form,Date dt,String ctxt,String distCh,String intA){
        this.title=title;
        this.intendedAudience=intA;
        this.date=dt;
        this.form=form;
        this.context=ctxt;
        this.distinctCharacteristic=distCh;
        pers=new ArrayList<>();
        exprs=new ArrayList<>();
        /*
        cbs=new CorporateBody();
        plcs=new ArrayList<>();
        Evts=new ArrayList<>();
        objs=new ArrayList<>();
        cpts=new ArrayList<>();
    */}
    
     /*************** GETTER & SETTER *****************/

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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDistinctCharacteristic() {
        return distinctCharacteristic;
    }

    public void setDistinctCharacteristic(String distinctCharacteristic) {
        this.distinctCharacteristic = distinctCharacteristic;
    }

    public String getIntendedAudience() {
        return intendedAudience;
    }

    public void setIntendedAudience(String intendedAudience) {
        this.intendedAudience = intendedAudience;
    }
    
    public List<Person> getPers() {
        return pers;
    }

    public void setPers(List<Person> pers) {
        this.pers = pers;
    }

    public List<Expression> getExprs() {
        return exprs;
    }

    public void setExprs(List<Expression> exprs) {
        this.exprs = exprs;
    }

}
