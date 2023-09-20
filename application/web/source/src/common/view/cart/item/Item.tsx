import { NextPage } from "next";
import React from "react";
import { Item } from "@/common/types/cart";
import { ListGroupItem } from "react-bootstrap";
import { formatAmountInUsd } from "@/common/components/formatAmountInUsd";
import formatTitle from "@/common/components/formatTitle";

const Item: NextPage<{ item: Item }> = ({ item }) => {
  return (
    <ListGroupItem className="item ">
      <h6 className="item-title">{formatTitle(item)}</h6>
      <p>
        Price:{" "}
        <span className="item-price">
          {formatAmountInUsd(item.product.price)}
        </span>
      </p>
      <p>
        Quantity: <span className="item-quantity">{item.quantity}</span>
      </p>
    </ListGroupItem>
  );
};

export default Item;
