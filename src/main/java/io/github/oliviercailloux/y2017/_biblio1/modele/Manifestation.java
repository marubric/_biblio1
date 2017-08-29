package io.github.oliviercailloux.y2017._biblio1.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author mrubrice
 */
@Entity
public class Manifestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String edition;
    private String statementResponsibility;
    private String publicationPlace;
    private String publisher;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String manifestationID;
    private String sourceAcquisition;
    private String typeFace;

    @ManyToOne
    private Item itm;
    @ManyToOne
    private Expression expr;
    /*@ManyToMany
    private List<Person1>pers;*/

    public Manifestation(){
        
    }
    
    public Manifestation(String ttl,String edit,String state,String publication,String publisher,Date dt,String manID,String srcA,String typeF){
        this.manifestationID = manID;
        this.date = dt;
        this.edition = edit;
        this.itm = new Item();
        this.publicationPlace = publication;
        this.publisher = publisher ;
        this.sourceAcquisition = srcA;
        this.statementResponsibility = state;
        this.title = ttl;
        this.typeFace = typeF;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getStatementResponsibility() {
        return statementResponsibility;
    }

    public void setStatementResponsibility(String statementResponsibility) {
        this.statementResponsibility = statementResponsibility;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getManifestationID() {
        return manifestationID;
    }

    public void setManifestationID(String ManifestationID) {
        this.manifestationID = ManifestationID;
    }

    public String getSourceAcquisition() {
        return sourceAcquisition;
    }

    public void setSourceAcquisition(String sourceAcquisition) {
        this.sourceAcquisition = sourceAcquisition;
    }

    public String getTypeFace() {
        return typeFace;
    }

    public void setTypeFace(String typeFace) {
        this.typeFace = typeFace;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public Item getItm() {
        return itm;
    }

    public void setItm(Item itm) {
        this.itm = itm;
    }

    /*public List<Person1> getPers() {
        return pers;
    }

    public void setPers(List<Person1> pers) {
        this.pers = pers;
    }
    */

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manifestation)) {
            return false;
        }
        Manifestation other = (Manifestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
