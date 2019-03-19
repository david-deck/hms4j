
package org.hms4j.example.jaxws.devis.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hms4j.example.jaxws.devis.WebServiceResponse;


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
 *         &lt;element name="traiterDevisReturn" type="{http://devis.jaxws.example.hms4j.org}WebServiceResponse"/>
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
    "traiterDevisReturn"
})
@XmlRootElement(name = "traiterDevisResponse")
public class TraiterDevisResponse {

    @XmlElement(required = true)
    protected WebServiceResponse traiterDevisReturn;

    /**
     * Gets the value of the traiterDevisReturn property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceResponse }
     *     
     */
    public WebServiceResponse getTraiterDevisReturn() {
        return traiterDevisReturn;
    }

    /**
     * Sets the value of the traiterDevisReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceResponse }
     *     
     */
    public void setTraiterDevisReturn(WebServiceResponse value) {
        this.traiterDevisReturn = value;
    }

}
