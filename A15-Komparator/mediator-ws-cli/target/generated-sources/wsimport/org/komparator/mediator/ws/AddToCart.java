
package org.komparator.mediator.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addToCart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addToCart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cartId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemId" type="{http://ws.mediator.komparator.org/}itemIdView" minOccurs="0"/>
 *         &lt;element name="itemQty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addToCart", propOrder = {
    "cartId",
    "itemId",
    "itemQty"
})
public class AddToCart {

    protected String cartId;
    protected ItemIdView itemId;
    protected int itemQty;

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
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdView }
     *     
     */
    public ItemIdView getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdView }
     *     
     */
    public void setItemId(ItemIdView value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the itemQty property.
     * 
     */
    public int getItemQty() {
        return itemQty;
    }

    /**
     * Sets the value of the itemQty property.
     * 
     */
    public void setItemQty(int value) {
        this.itemQty = value;
    }

}
