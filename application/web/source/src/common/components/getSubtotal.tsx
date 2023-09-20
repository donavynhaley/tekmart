import { Item } from "../types/cart";

export default function getSubtotal(cartItems: Item[]){
    return cartItems.reduce((total, currentItem) => total + (currentItem.quantity * currentItem.product.price), 0);
  }