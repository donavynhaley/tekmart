import expect from "expect"
import getConfirmationStyling from "../src/common/components/getConfirmationStyling";

describe("getConfirmationStyling tests", () => {
  const CONFIRMATION_SUCCESS = "Your purchase has been confirmed 🤑"
  const validConfirmationMessage = CONFIRMATION_SUCCESS;
  const invalidConfirmationMessage = "bogus"
  const scenarios= [
    [validConfirmationMessage, "status-ok"],
    [invalidConfirmationMessage, "status-bad"],
  ];
  test.each(scenarios)("should return correct styling classname given confirmation message", (confirmationMessage, expected) => {
    const actual = getConfirmationStyling(confirmationMessage);
    expect(actual).toEqual(expected);
  });
});