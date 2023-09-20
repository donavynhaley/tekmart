import ProductItem from "@/common/view/product/productItem";
import { NextPage } from "next";
import { Container, ListGroup, ListGroupItem } from "react-bootstrap";
import productList from "../../../inventory.json";

const Products: NextPage = () => {
  return (
    <Container className="text-center">
      <div id="products-view">
        <h1 id="products-header" className="mt-5 mb-3">
          Products Page
        </h1>
        <ListGroup id="product-list" className="mx-auto">
          {productList.map((product: any, index: number) => (
            <ProductItem product={product} key={index} />
          ))}
        </ListGroup>
      </div>
    </Container>
  );
};
export default Products;
