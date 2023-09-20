import {NextPage} from "next";
import {Dispatch, SetStateAction} from "react";

type Props = {
  setSource: Dispatch<SetStateAction<string>>
  sourceOption: string
}

const sourceOption: NextPage<Props> = ({setSource, sourceOption,}) => {
  return (
    <div>
      <label className="me-4">Choose Source:</label>
      <select
        onChange={(e) => setSource(e.target.value)}
        value={sourceOption}
        name="sourceList"
        id="source-dropdown"
      >
        <option className="source-option" value="select_source">
          --Select Source--
        </option>
        <option className="source-option" value="tok_visa">
          visa
        </option>
        <option className="source-option" value="tok_visa_debit">
          visa_debit
        </option>
        <option className="source-option" value="tok_amex">
          amex
        </option>
      </select>
    </div>
  );
};

export default sourceOption;
