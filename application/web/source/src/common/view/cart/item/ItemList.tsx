import { NextPage } from "next";
import { ListGroup } from "react-bootstrap";
import Item from "./Item";
import { Cart } from "@/common/types/cart";

const ItemList: NextPage<{ cart: Cart }> = ({ cart }) => {
  return (
    <ListGroup className="" id="item-list">
      {cart.items.map((item, index) => (
        <Item item={item} key={index} />
      ))}
    </ListGroup>
  );
};

export default ItemList;
