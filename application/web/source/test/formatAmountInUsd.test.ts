import expect from "expect";
import "@testing-library/jest-dom";
import {formatAmountInUsd} from "../src/common/components/formatAmountInUsd";

describe("formatAmountInUsd tests", () => {
  const invalidNegativeAmount = -50;
  const outsideLowerBoundary = 49;
  const validLowerBoundary = 50;
  const validHighBoundary = 99999999;
  const outsideHighBoundary = 100000000;
  const scenarios = [
    [0, "$0.00"],
    [invalidNegativeAmount, "-$0.50"],
    [outsideLowerBoundary, "$0.49"],
    [validLowerBoundary, "$0.50"],
    [validHighBoundary, "$999,999.99"],
    [outsideHighBoundary, "$1,000,000.00"],
  ];

  test.each(scenarios)("Amount to format(%d)", (amount, expected ) => {
    const actual = formatAmountInUsd(amount);
    expect(actual).toEqual(expected);
  });
});