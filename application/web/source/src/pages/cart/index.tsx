import {NextPage} from "next";
import React, {useEffect, useState} from "react";
import {Container} from "react-bootstrap";
import getUrlParams from "@/common/components/urlParams";
import cartsData from "../../../carts.json";
import ItemList from "@/common/view/cart/item/ItemList";
import {Cart} from "@/common/types/cart";
import EmptyCartMessage from "@/common/view/cart/EmptyCartMessage";
import getSubtotal from "@/common/components/getSubtotal";
import {formatAmountInUsd} from "@/common/components/formatAmountInUsd";

const Cart: NextPage = () => {
  const [cart, setCart] = useState<Cart>();

  useEffect(() => {
    const cartId = getUrlParams("cartId");
    if (cartId) {
      const newCart = cartsData.find((curCart) => curCart.cartID == cartId);
      setCart(newCart);
    }
  }, []);

  function renderCartItems() {
    return !cart ? <EmptyCartMessage/> : <ItemList cart={cart}/>;
  }

  function renderSubTotal() {
    if (!cart) return;
    const subtotal = formatAmountInUsd(getSubtotal(cart.items));
    return (
      <p>
        Subtotal: <span className="subtotal">{subtotal}  </span>
      </p>
    );
  }

  return (
    <Container className="text-center " id="cart-view">
      <h1 className="mt-5">Cart Page</h1>
      <div className="d-flex align-items-center justify-content-center">
        {renderCartItems()}
      </div>
      {renderSubTotal()}
    </Container>
  );
};

export default Cart;
