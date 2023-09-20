import React, {useEffect, useState} from "react";
import {NextPage} from "next";
import getUrlParams from "@/common/components/urlParams";
import logEasterEgg from "@/common/components/logEasterEgg";
import submitPurchase from "@/common/components/submitPurchase";
import getConfirmationStyling from "@/common/components/getConfirmationStyling";
import {Button, Container} from "react-bootstrap";
import AddSourceOption from "@/common/view/purchase-submission/addSourceOption";
import Amount from "@/common/view/purchase-submission/Amount";

const Purchase: NextPage = () => {
  const [amount, setAmount] = useState<number>(0);
  const [confirmationMessage, setConfirmationMessage] = useState("");
  const [source, setSource] = useState<string>("select_source");
  const QUERY = "amount";


  useEffect(() => {
    logEasterEgg();
    const amountFromURLParam = getUrlParams(QUERY);
    if (amountFromURLParam) setAmount(parseInt(amountFromURLParam));
  }, []);

  const handleSubmit = async () => {
    const response = await submitPurchase(amount, source);
    setConfirmationMessage(response.message);
  };

  return (
    <Container>
      <div id="purchase-submission-view">
        <h2 id="checkout-page-title">Checkout</h2>
        <Amount amount={amount}/>
        <AddSourceOption sourceOption={source} setSource={setSource}/>
        <Button
          className="my-3"
          variant="success"
          id="submit-button"
          disabled={source === "select_source"}
          onClick={() => handleSubmit()}
        >
          Submit
        </Button>
        <p
          id="status-message"
          className={getConfirmationStyling(confirmationMessage)}
        >
          {confirmationMessage}
        </p>
      </div>
    </Container>
  );
};

export default Purchase;
