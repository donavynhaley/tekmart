import { NextPage } from "next";
import {formatAmountInUsd} from "../../components/formatAmountInUsd"
type Props = {
  amount: number
}
const Amount: NextPage<Props> = ({amount}) => {
    const DEFAULT_CURRENCY = "USD";
  return (
  <>
  <label htmlFor="amount-input-element" id="amount-label">
    Amount:
    </label>
    <span className="ms-3" id="amount-input-element">{formatAmountInUsd(amount)}</span>
    <span id="currency"> {DEFAULT_CURRENCY}</span>
  </>


  );
};

export default Amount;




