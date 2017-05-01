
package org.komparator.supplier.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listPurchasesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listPurchasesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchases" type="{http://ws.supplier.komparator.org/}purchaseView" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listPurchasesResponse", propOrder = {
    "purchases"
})
public class ListPurchasesResponse {

    protected List<PurchaseView> purchases;

    /**
     * Gets the value of the purchases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the purchases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPurchases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PurchaseView }
     * 
     * 
     */
    public List<PurchaseView> getPurchases() {
        if (purchases == null) {
            purchases = new ArrayList<PurchaseView>();
        }
        return this.purchases;
    }

}
