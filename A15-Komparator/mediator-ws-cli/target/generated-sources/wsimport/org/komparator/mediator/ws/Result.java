
package org.komparator.mediator.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for result.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="result">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPLETE"/>
 *     &lt;enumeration value="PARTIAL"/>
 *     &lt;enumeration value="EMPTY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "result")
@XmlEnum
public enum Result {

    COMPLETE,
    PARTIAL,
    EMPTY;

    public String value() {
        return name();
    }

    public static Result fromValue(String v) {
        return valueOf(v);
    }

}
