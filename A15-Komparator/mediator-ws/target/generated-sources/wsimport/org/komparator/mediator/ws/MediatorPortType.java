
package org.komparator.mediator.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MediatorPortType", targetNamespace = "http://ws.mediator.komparator.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MediatorPortType {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "clear", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.Clear")
    @ResponseWrapper(localName = "clearResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.ClearResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/clearRequest", output = "http://ws.mediator.komparator.org/Mediator/clearResponse")
    public void clear();

    /**
     * 
     * @param productId
     * @return
     *     returns java.util.List<org.komparator.mediator.ws.ItemView>
     * @throws InvalidItemId_Exception
     */
    @WebMethod
    @WebResult(name = "items", targetNamespace = "")
    @RequestWrapper(localName = "getItems", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.GetItems")
    @ResponseWrapper(localName = "getItemsResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.GetItemsResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/getItemsRequest", output = "http://ws.mediator.komparator.org/Mediator/getItemsResponse", fault = {
        @FaultAction(className = InvalidItemId_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/getItems/Fault/InvalidItemId")
    })
    public List<ItemView> getItems(
        @WebParam(name = "productId", targetNamespace = "")
        String productId)
        throws InvalidItemId_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<org.komparator.mediator.ws.CartView>
     */
    @WebMethod
    @WebResult(name = "carts", targetNamespace = "")
    @RequestWrapper(localName = "listCarts", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.ListCarts")
    @ResponseWrapper(localName = "listCartsResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.ListCartsResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/listCartsRequest", output = "http://ws.mediator.komparator.org/Mediator/listCartsResponse")
    public List<CartView> listCarts();

    /**
     * 
     * @param descText
     * @return
     *     returns java.util.List<org.komparator.mediator.ws.ItemView>
     * @throws InvalidText_Exception
     */
    @WebMethod
    @WebResult(name = "items", targetNamespace = "")
    @RequestWrapper(localName = "searchItems", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.SearchItems")
    @ResponseWrapper(localName = "searchItemsResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.SearchItemsResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/searchItemsRequest", output = "http://ws.mediator.komparator.org/Mediator/searchItemsResponse", fault = {
        @FaultAction(className = InvalidText_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/searchItems/Fault/InvalidText")
    })
    public List<ItemView> searchItems(
        @WebParam(name = "descText", targetNamespace = "")
        String descText)
        throws InvalidText_Exception
    ;

    /**
     * 
     * @param creditCardNr
     * @param cartId
     * @return
     *     returns org.komparator.mediator.ws.ShoppingResultView
     * @throws EmptyCart_Exception
     * @throws InvalidCreditCard_Exception
     * @throws InvalidCartId_Exception
     */
    @WebMethod
    @WebResult(name = "shopResult", targetNamespace = "")
    @RequestWrapper(localName = "buyCart", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.BuyCart")
    @ResponseWrapper(localName = "buyCartResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.BuyCartResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/buyCartRequest", output = "http://ws.mediator.komparator.org/Mediator/buyCartResponse", fault = {
        @FaultAction(className = InvalidCartId_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/buyCart/Fault/InvalidCartId"),
        @FaultAction(className = EmptyCart_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/buyCart/Fault/EmptyCart"),
        @FaultAction(className = InvalidCreditCard_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/buyCart/Fault/InvalidCreditCard")
    })
    public ShoppingResultView buyCart(
        @WebParam(name = "cartId", targetNamespace = "")
        String cartId,
        @WebParam(name = "creditCardNr", targetNamespace = "")
        String creditCardNr)
        throws EmptyCart_Exception, InvalidCartId_Exception, InvalidCreditCard_Exception
    ;

    /**
     * 
     * @param itemId
     * @param itemQty
     * @param cartId
     * @throws InvalidItemId_Exception
     * @throws InvalidQuantity_Exception
     * @throws NotEnoughItems_Exception
     * @throws InvalidCartId_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "addToCart", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.AddToCart")
    @ResponseWrapper(localName = "addToCartResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.AddToCartResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/addToCartRequest", output = "http://ws.mediator.komparator.org/Mediator/addToCartResponse", fault = {
        @FaultAction(className = InvalidCartId_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/addToCart/Fault/InvalidCartId"),
        @FaultAction(className = InvalidItemId_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/addToCart/Fault/InvalidItemId"),
        @FaultAction(className = InvalidQuantity_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/addToCart/Fault/InvalidQuantity"),
        @FaultAction(className = NotEnoughItems_Exception.class, value = "http://ws.mediator.komparator.org/Mediator/addToCart/Fault/NotEnoughItems")
    })
    public void addToCart(
        @WebParam(name = "cartId", targetNamespace = "")
        String cartId,
        @WebParam(name = "itemId", targetNamespace = "")
        ItemIdView itemId,
        @WebParam(name = "itemQty", targetNamespace = "")
        int itemQty)
        throws InvalidCartId_Exception, InvalidItemId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ping", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.Ping")
    @ResponseWrapper(localName = "pingResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.PingResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/pingRequest", output = "http://ws.mediator.komparator.org/Mediator/pingResponse")
    public String ping(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.komparator.mediator.ws.ShoppingResultView>
     */
    @WebMethod
    @WebResult(name = "shopResults", targetNamespace = "")
    @RequestWrapper(localName = "shopHistory", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.ShopHistory")
    @ResponseWrapper(localName = "shopHistoryResponse", targetNamespace = "http://ws.mediator.komparator.org/", className = "org.komparator.mediator.ws.ShopHistoryResponse")
    @Action(input = "http://ws.mediator.komparator.org/Mediator/shopHistoryRequest", output = "http://ws.mediator.komparator.org/Mediator/shopHistoryResponse")
    public List<ShoppingResultView> shopHistory();

}