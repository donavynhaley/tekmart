export type Item = {
  quantity: number;
  product: {
    price: number;
    title: String;
    description: String;
    stock: number;
  };
};
export type Cart = {
  cartID: String;
  items: Item[];
  subtotal: number;
};
export type Product={
  price: number;
  title: string;
  description: String;
  stock: number;
}