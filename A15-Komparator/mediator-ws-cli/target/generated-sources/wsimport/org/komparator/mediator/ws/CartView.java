
package org.komparator.mediator.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cartView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cartView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cartId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{http://ws.mediator.komparator.org/}cartItemView" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cartView", propOrder = {
    "cartId",
    "items"
})
public class CartView {

    protected String cartId;
    @XmlElement(nillable = true)
    protected List<CartItemView> items;

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
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CartItemView }
     * 
     * 
     */
    public List<CartItemView> getItems() {
        if (items == null) {
            items = new ArrayList<CartItemView>();
        }
        return this.items;
    }

}
