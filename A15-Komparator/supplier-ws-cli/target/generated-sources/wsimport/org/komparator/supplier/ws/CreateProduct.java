
package org.komparator.supplier.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productToCreate" type="{http://ws.supplier.komparator.org/}productView" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createProduct", propOrder = {
    "productToCreate"
})
public class CreateProduct {

    protected ProductView productToCreate;

    /**
     * Gets the value of the productToCreate property.
     * 
     * @return
     *     possible object is
     *     {@link ProductView }
     *     
     */
    public ProductView getProductToCreate() {
        return productToCreate;
    }

    /**
     * Sets the value of the productToCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductView }
     *     
     */
    public void setProductToCreate(ProductView value) {
        this.productToCreate = value;
    }

}
