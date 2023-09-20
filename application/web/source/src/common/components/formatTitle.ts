import { Item } from "../types/cart";

const formatTitle = (item: Item): String => {
  if (item.product.title.length > 100) {
    return item.product.title.substring(0, 100) + "...";
  }
  return item.product.title;
};

export default formatTitle;
