
package org.hms4j.example.jaxws.devis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrestationBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrestationBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commentairePrestation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libellePrestation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quantitePrestation" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrestationBean", propOrder = {
    "commentairePrestation",
    "libellePrestation",
    "quantitePrestation"
})
public class PrestationBean {

    @XmlElement(required = true, nillable = true)
    protected String commentairePrestation;
    @XmlElement(required = true, nillable = true)
    protected String libellePrestation;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long quantitePrestation;

    /**
     * Gets the value of the commentairePrestation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentairePrestation() {
        return commentairePrestation;
    }

    /**
     * Sets the value of the commentairePrestation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentairePrestation(String value) {
        this.commentairePrestation = value;
    }

    /**
     * Gets the value of the libellePrestation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibellePrestation() {
        return libellePrestation;
    }

    /**
     * Sets the value of the libellePrestation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibellePrestation(String value) {
        this.libellePrestation = value;
    }

    /**
     * Gets the value of the quantitePrestation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQuantitePrestation() {
        return quantitePrestation;
    }

    /**
     * Sets the value of the quantitePrestation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQuantitePrestation(Long value) {
        this.quantitePrestation = value;
    }

}
