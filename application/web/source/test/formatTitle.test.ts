import formatTitle from "../src/common/components/formatTitle";
import { Item } from "../src/common/types/cart";
import expect from "expect";

describe("the title format tests", () => {
  const product1 =
    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv";
  const product2 =
  "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv..."
  const product3 = "abcdefghijklmnopqrstuvwxyzabcdefgh";
  const scenarios: [Item, string][] = [
    [
      {
        quantity: 1,
        product: {
          price: 50,
          title:
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv",
          description: "html script tag",
          stock: 10,
        },
      },
      product1,
    ],
    [
      {
        quantity: 5,
        product: {
          price: 50,
          title:
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijlkmnopqr",
          description: "html script tag",
          stock: 10,
        },
      },
      product2,
    ],

    [
      {
        quantity: 2,
        product: {
          price: 30,
          title:
            "abcdefghijklmnopqrstuvwxyzabcdefgh",
          description: "html script tag",
          stock: 10,
        },
      },
      product3,
    ],
  ];
  test.each(scenarios)(
    "should return formatted titles based off title character total",
    (item, expected: string) => {
      const actual = formatTitle(item);
      expect(actual).toEqual(expected);
    }
  );
});
