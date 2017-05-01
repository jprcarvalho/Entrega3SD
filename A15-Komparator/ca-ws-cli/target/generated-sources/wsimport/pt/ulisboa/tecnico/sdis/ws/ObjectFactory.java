
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

    private final static QName _GetCertificate_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "getCertificate");
    private final static QName _GetCertificateResponse_QNAME = new QName("http://ws.sdis.tecnico.ulisboa.pt/", "getCertificateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pt.ulisboa.tecnico.sdis.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCertificate }
     * 
     */
    public GetCertificate createGetCertificate() {
        return new GetCertificate();
    }

    /**
     * Create an instance of {@link GetCertificateResponse }
     * 
     */
    public GetCertificateResponse createGetCertificateResponse() {
        return new GetCertificateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCertificate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "getCertificate")
    public JAXBElement<GetCertificate> createGetCertificate(GetCertificate value) {
        return new JAXBElement<GetCertificate>(_GetCertificate_QNAME, GetCertificate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCertificateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sdis.tecnico.ulisboa.pt/", name = "getCertificateResponse")
    public JAXBElement<GetCertificateResponse> createGetCertificateResponse(GetCertificateResponse value) {
        return new JAXBElement<GetCertificateResponse>(_GetCertificateResponse_QNAME, GetCertificateResponse.class, null, value);
    }

}
