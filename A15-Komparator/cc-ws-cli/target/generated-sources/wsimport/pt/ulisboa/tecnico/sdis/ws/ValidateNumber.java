
package pt.ulisboa.tecnico.sdis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberAsString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateNumber", propOrder = {
    "numberAsString"
})
public class ValidateNumber {

    protected String numberAsString;

    /**
     * Gets the value of the numberAsString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberAsString() {
        return numberAsString;
    }

    /**
     * Sets the value of the numberAsString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberAsString(String value) {
        this.numberAsString = value;
    }

}
