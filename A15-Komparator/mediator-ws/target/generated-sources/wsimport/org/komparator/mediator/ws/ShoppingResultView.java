
package org.komparator.mediator.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shoppingResultView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shoppingResultView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="result" type="{http://ws.mediator.komparator.org/}result" minOccurs="0"/>
 *         &lt;element name="purchasedItems" type="{http://ws.mediator.komparator.org/}cartItemView" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="droppedItems" type="{http://ws.mediator.komparator.org/}cartItemView" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shoppingResultView", propOrder = {
    "id",
    "result",
    "purchasedItems",
    "droppedItems",
    "totalPrice"
})
public class ShoppingResultView {

    protected String id;
    @XmlSchemaType(name = "string")
    protected Result result;
    @XmlElement(nillable = true)
    protected List<CartItemView> purchasedItems;
    @XmlElement(nillable = true)
    protected List<CartItemView> droppedItems;
    protected int totalPrice;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setResult(Result value) {
        this.result = value;
    }

    /**
     * Gets the value of the purchasedItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the purchasedItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPurchasedItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CartItemView }
     * 
     * 
     */
    public List<CartItemView> getPurchasedItems() {
        if (purchasedItems == null) {
            purchasedItems = new ArrayList<CartItemView>();
        }
        return this.purchasedItems;
    }

    /**
     * Gets the value of the droppedItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the droppedItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDroppedItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CartItemView }
     * 
     * 
     */
    public List<CartItemView> getDroppedItems() {
        if (droppedItems == null) {
            droppedItems = new ArrayList<CartItemView>();
        }
        return this.droppedItems;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     */
    public void setTotalPrice(int value) {
        this.totalPrice = value;
    }

}
