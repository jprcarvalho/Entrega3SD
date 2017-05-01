
package org.komparator.mediator.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buyCartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buyCartResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shopResult" type="{http://ws.mediator.komparator.org/}shoppingResultView" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buyCartResponse", propOrder = {
    "shopResult"
})
public class BuyCartResponse {

    protected ShoppingResultView shopResult;

    /**
     * Gets the value of the shopResult property.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingResultView }
     *     
     */
    public ShoppingResultView getShopResult() {
        return shopResult;
    }

    /**
     * Sets the value of the shopResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingResultView }
     *     
     */
    public void setShopResult(ShoppingResultView value) {
        this.shopResult = value;
    }

}
