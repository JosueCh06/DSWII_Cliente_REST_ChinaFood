//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.06.30 a las 01:59:49 PM PET 
//


package com.cibertec.spring.soap.api.servicioplatillo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="platillo" type="{http://www.cibertec.com/spring/soap/api/servicioPlatillo}platillo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "platillo"
})
@XmlRootElement(name = "updatePlatilloRequest")
public class UpdatePlatilloRequest {

    @XmlElement(required = true)
    protected Platillo platillo;

    /**
     * Obtiene el valor de la propiedad platillo.
     * 
     * @return
     *     possible object is
     *     {@link Platillo }
     *     
     */
    public Platillo getPlatillo() {
        return platillo;
    }

    /**
     * Define el valor de la propiedad platillo.
     * 
     * @param value
     *     allowed object is
     *     {@link Platillo }
     *     
     */
    public void setPlatillo(Platillo value) {
        this.platillo = value;
    }

}
