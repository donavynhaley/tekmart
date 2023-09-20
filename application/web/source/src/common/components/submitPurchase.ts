import axios from "axios";
type Data = {
  message: string;
};

type Payload = {
  amount: number,
  currency: string,
  source: string
}

const submitPurchase = async (
  amount: number,
  source: string
): Promise<Data> => {
  const payload: Payload = {
    amount: amount,
    currency: "usd",
    source: source,
  };
  const URL = "http://localhost:8080";
  try {
    const response = await axios.post(URL + "/purchase", payload);
    return response.data;
  } catch (error: any) {
    return error.response.data;
  }
};

export default submitPurchase;
