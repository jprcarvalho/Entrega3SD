
package org.komparator.mediator.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.komparator.mediator.ws package. 
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

    private final static QName _InvalidItemId_QNAME = new QName("http://ws.mediator.komparator.org/", "InvalidItemId");
    private final static QName _ClearResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "clearResponse");
    private final static QName _AddToCart_QNAME = new QName("http://ws.mediator.komparator.org/", "addToCart");
    private final static QName _InvalidText_QNAME = new QName("http://ws.mediator.komparator.org/", "InvalidText");
    private final static QName _PingResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "pingResponse");
    private final static QName _SearchItems_QNAME = new QName("http://ws.mediator.komparator.org/", "searchItems");
    private final static QName _BuyCartResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "buyCartResponse");
    private final static QName _GetItems_QNAME = new QName("http://ws.mediator.komparator.org/", "getItems");
    private final static QName _SearchItemsResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "searchItemsResponse");
    private final static QName _BuyCart_QNAME = new QName("http://ws.mediator.komparator.org/", "buyCart");
    private final static QName _InvalidCartId_QNAME = new QName("http://ws.mediator.komparator.org/", "InvalidCartId");
    private final static QName _Clear_QNAME = new QName("http://ws.mediator.komparator.org/", "clear");
    private final static QName _InvalidQuantity_QNAME = new QName("http://ws.mediator.komparator.org/", "InvalidQuantity");
    private final static QName _ShopHistoryResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "shopHistoryResponse");
    private final static QName _EmptyCart_QNAME = new QName("http://ws.mediator.komparator.org/", "EmptyCart");
    private final static QName _InvalidCreditCard_QNAME = new QName("http://ws.mediator.komparator.org/", "InvalidCreditCard");
    private final static QName _AddToCartResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "addToCartResponse");
    private final static QName _GetItemsResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "getItemsResponse");
    private final static QName _ListCartsResponse_QNAME = new QName("http://ws.mediator.komparator.org/", "listCartsResponse");
    private final static QName _NotEnoughItems_QNAME = new QName("http://ws.mediator.komparator.org/", "NotEnoughItems");
    private final static QName _ListCarts_QNAME = new QName("http://ws.mediator.komparator.org/", "listCarts");
    private final static QName _ShopHistory_QNAME = new QName("http://ws.mediator.komparator.org/", "shopHistory");
    private final static QName _Ping_QNAME = new QName("http://ws.mediator.komparator.org/", "ping");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.komparator.mediator.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetItemsResponse }
     * 
     */
    public GetItemsResponse createGetItemsResponse() {
        return new GetItemsResponse();
    }

    /**
     * Create an instance of {@link ListCartsResponse }
     * 
     */
    public ListCartsResponse createListCartsResponse() {
        return new ListCartsResponse();
    }

    /**
     * Create an instance of {@link NotEnoughItems }
     * 
     */
    public NotEnoughItems createNotEnoughItems() {
        return new NotEnoughItems();
    }

    /**
     * Create an instance of {@link ListCarts }
     * 
     */
    public ListCarts createListCarts() {
        return new ListCarts();
    }

    /**
     * Create an instance of {@link ShopHistory }
     * 
     */
    public ShopHistory createShopHistory() {
        return new ShopHistory();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link InvalidCartId }
     * 
     */
    public InvalidCartId createInvalidCartId() {
        return new InvalidCartId();
    }

    /**
     * Create an instance of {@link Clear }
     * 
     */
    public Clear createClear() {
        return new Clear();
    }

    /**
     * Create an instance of {@link InvalidQuantity }
     * 
     */
    public InvalidQuantity createInvalidQuantity() {
        return new InvalidQuantity();
    }

    /**
     * Create an instance of {@link ShopHistoryResponse }
     * 
     */
    public ShopHistoryResponse createShopHistoryResponse() {
        return new ShopHistoryResponse();
    }

    /**
     * Create an instance of {@link EmptyCart }
     * 
     */
    public EmptyCart createEmptyCart() {
        return new EmptyCart();
    }

    /**
     * Create an instance of {@link InvalidCreditCard }
     * 
     */
    public InvalidCreditCard createInvalidCreditCard() {
        return new InvalidCreditCard();
    }

    /**
     * Create an instance of {@link AddToCartResponse }
     * 
     */
    public AddToCartResponse createAddToCartResponse() {
        return new AddToCartResponse();
    }

    /**
     * Create an instance of {@link GetItems }
     * 
     */
    public GetItems createGetItems() {
        return new GetItems();
    }

    /**
     * Create an instance of {@link SearchItemsResponse }
     * 
     */
    public SearchItemsResponse createSearchItemsResponse() {
        return new SearchItemsResponse();
    }

    /**
     * Create an instance of {@link BuyCart }
     * 
     */
    public BuyCart createBuyCart() {
        return new BuyCart();
    }

    /**
     * Create an instance of {@link InvalidItemId }
     * 
     */
    public InvalidItemId createInvalidItemId() {
        return new InvalidItemId();
    }

    /**
     * Create an instance of {@link ClearResponse }
     * 
     */
    public ClearResponse createClearResponse() {
        return new ClearResponse();
    }

    /**
     * Create an instance of {@link AddToCart }
     * 
     */
    public AddToCart createAddToCart() {
        return new AddToCart();
    }

    /**
     * Create an instance of {@link InvalidText }
     * 
     */
    public InvalidText createInvalidText() {
        return new InvalidText();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link SearchItems }
     * 
     */
    public SearchItems createSearchItems() {
        return new SearchItems();
    }

    /**
     * Create an instance of {@link BuyCartResponse }
     * 
     */
    public BuyCartResponse createBuyCartResponse() {
        return new BuyCartResponse();
    }

    /**
     * Create an instance of {@link CartView }
     * 
     */
    public CartView createCartView() {
        return new CartView();
    }

    /**
     * Create an instance of {@link CartItemView }
     * 
     */
    public CartItemView createCartItemView() {
        return new CartItemView();
    }

    /**
     * Create an instance of {@link ShoppingResultView }
     * 
     */
    public ShoppingResultView createShoppingResultView() {
        return new ShoppingResultView();
    }

    /**
     * Create an instance of {@link ItemView }
     * 
     */
    public ItemView createItemView() {
        return new ItemView();
    }

    /**
     * Create an instance of {@link ItemIdView }
     * 
     */
    public ItemIdView createItemIdView() {
        return new ItemIdView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidItemId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "InvalidItemId")
    public JAXBElement<InvalidItemId> createInvalidItemId(InvalidItemId value) {
        return new JAXBElement<InvalidItemId>(_InvalidItemId_QNAME, InvalidItemId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "clearResponse")
    public JAXBElement<ClearResponse> createClearResponse(ClearResponse value) {
        return new JAXBElement<ClearResponse>(_ClearResponse_QNAME, ClearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "addToCart")
    public JAXBElement<AddToCart> createAddToCart(AddToCart value) {
        return new JAXBElement<AddToCart>(_AddToCart_QNAME, AddToCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidText }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "InvalidText")
    public JAXBElement<InvalidText> createInvalidText(InvalidText value) {
        return new JAXBElement<InvalidText>(_InvalidText_QNAME, InvalidText.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "searchItems")
    public JAXBElement<SearchItems> createSearchItems(SearchItems value) {
        return new JAXBElement<SearchItems>(_SearchItems_QNAME, SearchItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "buyCartResponse")
    public JAXBElement<BuyCartResponse> createBuyCartResponse(BuyCartResponse value) {
        return new JAXBElement<BuyCartResponse>(_BuyCartResponse_QNAME, BuyCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "getItems")
    public JAXBElement<GetItems> createGetItems(GetItems value) {
        return new JAXBElement<GetItems>(_GetItems_QNAME, GetItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "searchItemsResponse")
    public JAXBElement<SearchItemsResponse> createSearchItemsResponse(SearchItemsResponse value) {
        return new JAXBElement<SearchItemsResponse>(_SearchItemsResponse_QNAME, SearchItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "buyCart")
    public JAXBElement<BuyCart> createBuyCart(BuyCart value) {
        return new JAXBElement<BuyCart>(_BuyCart_QNAME, BuyCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCartId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "InvalidCartId")
    public JAXBElement<InvalidCartId> createInvalidCartId(InvalidCartId value) {
        return new JAXBElement<InvalidCartId>(_InvalidCartId_QNAME, InvalidCartId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "clear")
    public JAXBElement<Clear> createClear(Clear value) {
        return new JAXBElement<Clear>(_Clear_QNAME, Clear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "InvalidQuantity")
    public JAXBElement<InvalidQuantity> createInvalidQuantity(InvalidQuantity value) {
        return new JAXBElement<InvalidQuantity>(_InvalidQuantity_QNAME, InvalidQuantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "shopHistoryResponse")
    public JAXBElement<ShopHistoryResponse> createShopHistoryResponse(ShopHistoryResponse value) {
        return new JAXBElement<ShopHistoryResponse>(_ShopHistoryResponse_QNAME, ShopHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "EmptyCart")
    public JAXBElement<EmptyCart> createEmptyCart(EmptyCart value) {
        return new JAXBElement<EmptyCart>(_EmptyCart_QNAME, EmptyCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "InvalidCreditCard")
    public JAXBElement<InvalidCreditCard> createInvalidCreditCard(InvalidCreditCard value) {
        return new JAXBElement<InvalidCreditCard>(_InvalidCreditCard_QNAME, InvalidCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "addToCartResponse")
    public JAXBElement<AddToCartResponse> createAddToCartResponse(AddToCartResponse value) {
        return new JAXBElement<AddToCartResponse>(_AddToCartResponse_QNAME, AddToCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "getItemsResponse")
    public JAXBElement<GetItemsResponse> createGetItemsResponse(GetItemsResponse value) {
        return new JAXBElement<GetItemsResponse>(_GetItemsResponse_QNAME, GetItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCartsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "listCartsResponse")
    public JAXBElement<ListCartsResponse> createListCartsResponse(ListCartsResponse value) {
        return new JAXBElement<ListCartsResponse>(_ListCartsResponse_QNAME, ListCartsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotEnoughItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "NotEnoughItems")
    public JAXBElement<NotEnoughItems> createNotEnoughItems(NotEnoughItems value) {
        return new JAXBElement<NotEnoughItems>(_NotEnoughItems_QNAME, NotEnoughItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCarts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "listCarts")
    public JAXBElement<ListCarts> createListCarts(ListCarts value) {
        return new JAXBElement<ListCarts>(_ListCarts_QNAME, ListCarts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "shopHistory")
    public JAXBElement<ShopHistory> createShopHistory(ShopHistory value) {
        return new JAXBElement<ShopHistory>(_ShopHistory_QNAME, ShopHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.mediator.komparator.org/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

}
