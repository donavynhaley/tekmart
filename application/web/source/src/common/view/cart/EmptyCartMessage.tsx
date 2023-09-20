import {NextPage} from "next";
import {Image} from "react-bootstrap";
import React from "react";

const EmptyCartMessage: NextPage = () => {
  const CART_IS_EMPTY_MESSAGE = "Your cart is empty";

  return (
    <>
      <Image
        src="https://cdni.iconscout.com/illustration/premium/thumb/empty-cart-5521508-4610092.png"
        alt="empty"
      />
      <h3 className="text-danger" id="empty-message">
        {CART_IS_EMPTY_MESSAGE}
      </h3>
    </>
  );
};

export default EmptyCartMessage;