
package pt.ulisboa.tecnico.sdis.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pt.ulisboa.tecnico.sdis.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ping_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "ping");
    private final static QName _ValidateNumber_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "validateNumber");
    private final static QName _ValidateNumberResponse_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "validateNumberResponse");
    private final static QName _PingResponse_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "pingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pt.ulisboa.tecnico.sdis.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link ValidateNumber }
     * 
     */
    public ValidateNumber createValidateNumber() {
        return new ValidateNumber();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link ValidateNumberResponse }
     * 
     */
    public ValidateNumberResponse createValidateNumberResponse() {
        return new ValidateNumberResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "validateNumber")
    public JAXBElement<ValidateNumber> createValidateNumber(ValidateNumber value) {
        return new JAXBElement<ValidateNumber>(_ValidateNumber_QNAME, ValidateNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "validateNumberResponse")
    public JAXBElement<ValidateNumberResponse> createValidateNumberResponse(ValidateNumberResponse value) {
        return new JAXBElement<ValidateNumberResponse>(_ValidateNumberResponse_QNAME, ValidateNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

}
