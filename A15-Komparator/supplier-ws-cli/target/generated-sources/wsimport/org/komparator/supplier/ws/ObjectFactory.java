
package org.komparator.supplier.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.komparator.supplier.ws package. 
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

    private final static QName _CreateProduct_QNAME = new QName("http://ws.supplier.komparator.org/", "createProduct");
    private final static QName _ListProducts_QNAME = new QName("http://ws.supplier.komparator.org/", "listProducts");
    private final static QName _ListProductsResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "listProductsResponse");
    private final static QName _Ping_QNAME = new QName("http://ws.supplier.komparator.org/", "ping");
    private final static QName _ListPurchases_QNAME = new QName("http://ws.supplier.komparator.org/", "listPurchases");
    private final static QName _ListPurchasesResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "listPurchasesResponse");
    private final static QName _GetProduct_QNAME = new QName("http://ws.supplier.komparator.org/", "getProduct");
    private final static QName _GetProductResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "getProductResponse");
    private final static QName _BadProductId_QNAME = new QName("http://ws.supplier.komparator.org/", "BadProductId");
    private final static QName _InsufficientQuantity_QNAME = new QName("http://ws.supplier.komparator.org/", "InsufficientQuantity");
    private final static QName _Clear_QNAME = new QName("http://ws.supplier.komparator.org/", "clear");
    private final static QName _SearchProductsResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "searchProductsResponse");
    private final static QName _BadProduct_QNAME = new QName("http://ws.supplier.komparator.org/", "BadProduct");
    private final static QName _CreateProductResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "createProductResponse");
    private final static QName _BuyProduct_QNAME = new QName("http://ws.supplier.komparator.org/", "buyProduct");
    private final static QName _PingResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "pingResponse");
    private final static QName _BuyProductResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "buyProductResponse");
    private final static QName _BadQuantity_QNAME = new QName("http://ws.supplier.komparator.org/", "BadQuantity");
    private final static QName _BadText_QNAME = new QName("http://ws.supplier.komparator.org/", "BadText");
    private final static QName _ClearResponse_QNAME = new QName("http://ws.supplier.komparator.org/", "clearResponse");
    private final static QName _SearchProducts_QNAME = new QName("http://ws.supplier.komparator.org/", "searchProducts");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.komparator.supplier.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BadProductId }
     * 
     */
    public BadProductId createBadProductId() {
        return new BadProductId();
    }

    /**
     * Create an instance of {@link GetProduct }
     * 
     */
    public GetProduct createGetProduct() {
        return new GetProduct();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     * 
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link ListPurchasesResponse }
     * 
     */
    public ListPurchasesResponse createListPurchasesResponse() {
        return new ListPurchasesResponse();
    }

    /**
     * Create an instance of {@link ListPurchases }
     * 
     */
    public ListPurchases createListPurchases() {
        return new ListPurchases();
    }

    /**
     * Create an instance of {@link ListProductsResponse }
     * 
     */
    public ListProductsResponse createListProductsResponse() {
        return new ListProductsResponse();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link CreateProduct }
     * 
     */
    public CreateProduct createCreateProduct() {
        return new CreateProduct();
    }

    /**
     * Create an instance of {@link ListProducts }
     * 
     */
    public ListProducts createListProducts() {
        return new ListProducts();
    }

    /**
     * Create an instance of {@link Clear }
     * 
     */
    public Clear createClear() {
        return new Clear();
    }

    /**
     * Create an instance of {@link SearchProductsResponse }
     * 
     */
    public SearchProductsResponse createSearchProductsResponse() {
        return new SearchProductsResponse();
    }

    /**
     * Create an instance of {@link InsufficientQuantity }
     * 
     */
    public InsufficientQuantity createInsufficientQuantity() {
        return new InsufficientQuantity();
    }

    /**
     * Create an instance of {@link BuyProduct }
     * 
     */
    public BuyProduct createBuyProduct() {
        return new BuyProduct();
    }

    /**
     * Create an instance of {@link CreateProductResponse }
     * 
     */
    public CreateProductResponse createCreateProductResponse() {
        return new CreateProductResponse();
    }

    /**
     * Create an instance of {@link BadProduct }
     * 
     */
    public BadProduct createBadProduct() {
        return new BadProduct();
    }

    /**
     * Create an instance of {@link BadQuantity }
     * 
     */
    public BadQuantity createBadQuantity() {
        return new BadQuantity();
    }

    /**
     * Create an instance of {@link BadText }
     * 
     */
    public BadText createBadText() {
        return new BadText();
    }

    /**
     * Create an instance of {@link ClearResponse }
     * 
     */
    public ClearResponse createClearResponse() {
        return new ClearResponse();
    }

    /**
     * Create an instance of {@link SearchProducts }
     * 
     */
    public SearchProducts createSearchProducts() {
        return new SearchProducts();
    }

    /**
     * Create an instance of {@link BuyProductResponse }
     * 
     */
    public BuyProductResponse createBuyProductResponse() {
        return new BuyProductResponse();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link ProductView }
     * 
     */
    public ProductView createProductView() {
        return new ProductView();
    }

    /**
     * Create an instance of {@link PurchaseView }
     * 
     */
    public PurchaseView createPurchaseView() {
        return new PurchaseView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "createProduct")
    public JAXBElement<CreateProduct> createCreateProduct(CreateProduct value) {
        return new JAXBElement<CreateProduct>(_CreateProduct_QNAME, CreateProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "listProducts")
    public JAXBElement<ListProducts> createListProducts(ListProducts value) {
        return new JAXBElement<ListProducts>(_ListProducts_QNAME, ListProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "listProductsResponse")
    public JAXBElement<ListProductsResponse> createListProductsResponse(ListProductsResponse value) {
        return new JAXBElement<ListProductsResponse>(_ListProductsResponse_QNAME, ListProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPurchases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "listPurchases")
    public JAXBElement<ListPurchases> createListPurchases(ListPurchases value) {
        return new JAXBElement<ListPurchases>(_ListPurchases_QNAME, ListPurchases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPurchasesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "listPurchasesResponse")
    public JAXBElement<ListPurchasesResponse> createListPurchasesResponse(ListPurchasesResponse value) {
        return new JAXBElement<ListPurchasesResponse>(_ListPurchasesResponse_QNAME, ListPurchasesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "getProduct")
    public JAXBElement<GetProduct> createGetProduct(GetProduct value) {
        return new JAXBElement<GetProduct>(_GetProduct_QNAME, GetProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "getProductResponse")
    public JAXBElement<GetProductResponse> createGetProductResponse(GetProductResponse value) {
        return new JAXBElement<GetProductResponse>(_GetProductResponse_QNAME, GetProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadProductId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "BadProductId")
    public JAXBElement<BadProductId> createBadProductId(BadProductId value) {
        return new JAXBElement<BadProductId>(_BadProductId_QNAME, BadProductId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsufficientQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "InsufficientQuantity")
    public JAXBElement<InsufficientQuantity> createInsufficientQuantity(InsufficientQuantity value) {
        return new JAXBElement<InsufficientQuantity>(_InsufficientQuantity_QNAME, InsufficientQuantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "clear")
    public JAXBElement<Clear> createClear(Clear value) {
        return new JAXBElement<Clear>(_Clear_QNAME, Clear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "searchProductsResponse")
    public JAXBElement<SearchProductsResponse> createSearchProductsResponse(SearchProductsResponse value) {
        return new JAXBElement<SearchProductsResponse>(_SearchProductsResponse_QNAME, SearchProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "BadProduct")
    public JAXBElement<BadProduct> createBadProduct(BadProduct value) {
        return new JAXBElement<BadProduct>(_BadProduct_QNAME, BadProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "createProductResponse")
    public JAXBElement<CreateProductResponse> createCreateProductResponse(CreateProductResponse value) {
        return new JAXBElement<CreateProductResponse>(_CreateProductResponse_QNAME, CreateProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "buyProduct")
    public JAXBElement<BuyProduct> createBuyProduct(BuyProduct value) {
        return new JAXBElement<BuyProduct>(_BuyProduct_QNAME, BuyProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "buyProductResponse")
    public JAXBElement<BuyProductResponse> createBuyProductResponse(BuyProductResponse value) {
        return new JAXBElement<BuyProductResponse>(_BuyProductResponse_QNAME, BuyProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "BadQuantity")
    public JAXBElement<BadQuantity> createBadQuantity(BadQuantity value) {
        return new JAXBElement<BadQuantity>(_BadQuantity_QNAME, BadQuantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadText }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "BadText")
    public JAXBElement<BadText> createBadText(BadText value) {
        return new JAXBElement<BadText>(_BadText_QNAME, BadText.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "clearResponse")
    public JAXBElement<ClearResponse> createClearResponse(ClearResponse value) {
        return new JAXBElement<ClearResponse>(_ClearResponse_QNAME, ClearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.supplier.komparator.org/", name = "searchProducts")
    public JAXBElement<SearchProducts> createSearchProducts(SearchProducts value) {
        return new JAXBElement<SearchProducts>(_SearchProducts_QNAME, SearchProducts.class, null, value);
    }

}
