
package org.hms4j.example.jaxws.devis.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hms4j.example.jaxws.devis.DevisBean;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="devisBean" type="{http://devis.jaxws.example.hms4j.org}DevisBean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "devisBean"
})
@XmlRootElement(name = "traiterDevis")
public class TraiterDevis {

    @XmlElement(required = true)
    protected DevisBean devisBean;

    /**
     * Gets the value of the devisBean property.
     * 
     * @return
     *     possible object is
     *     {@link DevisBean }
     *     
     */
    public DevisBean getDevisBean() {
        return devisBean;
    }

    /**
     * Sets the value of the devisBean property.
     * 
     * @param value
     *     allowed object is
     *     {@link DevisBean }
     *     
     */
    public void setDevisBean(DevisBean value) {
        this.devisBean = value;
    }

}
