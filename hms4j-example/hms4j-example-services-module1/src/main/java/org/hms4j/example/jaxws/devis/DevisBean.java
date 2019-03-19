
package org.hms4j.example.jaxws.devis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DevisBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevisBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeClientFinal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeContrat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeGenerique" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commentaireDevis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="immatriculation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numChassis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroTea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prestations" type="{http://devis.jaxws.example.hms4j.org}Prestations"/>
 *         &lt;element name="referenceDevis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevisBean", propOrder = {
    "codeClientFinal",
    "codeContrat",
    "codeGenerique",
    "commentaireDevis",
    "immatriculation",
    "numChassis",
    "numeroTea",
    "prestations",
    "referenceDevis"
})
public class DevisBean {

    @XmlElement(required = true, nillable = true)
    protected String codeClientFinal;
    @XmlElement(required = true, nillable = true)
    protected String codeContrat;
    @XmlElement(required = true, nillable = true)
    protected String codeGenerique;
    @XmlElement(required = true, nillable = true)
    protected String commentaireDevis;
    @XmlElement(required = true, nillable = true)
    protected String immatriculation;
    @XmlElement(required = true, nillable = true)
    protected String numChassis;
    @XmlElement(required = true, nillable = true)
    protected String numeroTea;
    @XmlElement(required = true, nillable = true)
    protected Prestations prestations;
    @XmlElement(required = true, nillable = true)
    protected String referenceDevis;

    /**
     * Gets the value of the codeClientFinal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeClientFinal() {
        return codeClientFinal;
    }

    /**
     * Sets the value of the codeClientFinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeClientFinal(String value) {
        this.codeClientFinal = value;
    }

    /**
     * Gets the value of the codeContrat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeContrat() {
        return codeContrat;
    }

    /**
     * Sets the value of the codeContrat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeContrat(String value) {
        this.codeContrat = value;
    }

    /**
     * Gets the value of the codeGenerique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeGenerique() {
        return codeGenerique;
    }

    /**
     * Sets the value of the codeGenerique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeGenerique(String value) {
        this.codeGenerique = value;
    }

    /**
     * Gets the value of the commentaireDevis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaireDevis() {
        return commentaireDevis;
    }

    /**
     * Sets the value of the commentaireDevis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaireDevis(String value) {
        this.commentaireDevis = value;
    }

    /**
     * Gets the value of the immatriculation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Sets the value of the immatriculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImmatriculation(String value) {
        this.immatriculation = value;
    }

    /**
     * Gets the value of the numChassis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumChassis() {
        return numChassis;
    }

    /**
     * Sets the value of the numChassis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumChassis(String value) {
        this.numChassis = value;
    }

    /**
     * Gets the value of the numeroTea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTea() {
        return numeroTea;
    }

    /**
     * Sets the value of the numeroTea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTea(String value) {
        this.numeroTea = value;
    }

    /**
     * Gets the value of the prestations property.
     * 
     * @return
     *     possible object is
     *     {@link Prestations }
     *     
     */
    public Prestations getPrestations() {
        return prestations;
    }

    /**
     * Sets the value of the prestations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prestations }
     *     
     */
    public void setPrestations(Prestations value) {
        this.prestations = value;
    }

    /**
     * Gets the value of the referenceDevis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceDevis() {
        return referenceDevis;
    }

    /**
     * Sets the value of the referenceDevis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceDevis(String value) {
        this.referenceDevis = value;
    }

}
