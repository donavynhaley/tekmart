// import getSubtotal from "@/common/components/getSubtotal";
import getSubtotal from "../src/common/components/getSubtotal";

import expect from "expect";
import { Item } from "../src/common/types/cart";

describe("the subtotal functionality tests", () => {
  const fiftyCents = 50;
  const threeHundredAndTenCents = 310;
  const scenarios: [Item[], number][] = [
    [[{
      quantity: 1,
      product: {
        price: 50,
        title: "<h1>Test</h1>",
        description: "html script tag",
        stock: 10,
      },
    }], fiftyCents],
    [[{
      quantity: 5,
      product: {
        price: 50,
        title: "<h1>Test</h1>",
        description: "html script tag",
        stock: 10,
      },
    },
    {
      quantity: 2,
      product: {
        price: 30,
        title: "<h1>Test</h1>",
        description: "html script tag",
        stock: 10,
      },
    }], threeHundredAndTenCents]
  ]

  test.each(scenarios)("Should return calculated subtotal", (items, expected) => {
    const actual = getSubtotal(items);
    expect(actual).toBe(expected);
  })
});