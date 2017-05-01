
package org.komparator.mediator.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buyCart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buyCart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cartId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buyCart", propOrder = {
    "cartId",
    "creditCardNr"
})
public class BuyCart {

    protected String cartId;
    protected String creditCardNr;

    /**
     * Gets the value of the cartId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Sets the value of the cartId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartId(String value) {
        this.cartId = value;
    }

    /**
     * Gets the value of the creditCardNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardNr() {
        return creditCardNr;
    }

    /**
     * Sets the value of the creditCardNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardNr(String value) {
        this.creditCardNr = value;
    }

}
