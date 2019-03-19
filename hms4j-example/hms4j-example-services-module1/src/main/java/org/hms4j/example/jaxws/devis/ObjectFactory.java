
package org.hms4j.example.jaxws.devis;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.hms4j.example.jaxws.devis package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.hms4j.example.jaxws.devis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WebServiceResponse }
     * 
     */
    public WebServiceResponse createWebServiceResponse() {
        return new WebServiceResponse();
    }

    /**
     * Create an instance of {@link PrestationBean }
     * 
     */
    public PrestationBean createPrestationBean() {
        return new PrestationBean();
    }

    /**
     * Create an instance of {@link Prestations }
     * 
     */
    public Prestations createPrestations() {
        return new Prestations();
    }

    /**
     * Create an instance of {@link DevisBean }
     * 
     */
    public DevisBean createDevisBean() {
        return new DevisBean();
    }

}
