import {Product} from "@/common/types/cart";
import {NextPage} from "next";
import {Button, Card} from "react-bootstrap";

const stockMessage = "Out of Stock";
const ProductItem: NextPage<{ product: Product }> = ({product}) => {
  return (
    <Card className="product">
      <Card.Body>
      <Card.Title className="product-title">{product.title}</Card.Title>
        <Card.Text className="product-description">{product.description}</Card.Text>
        <Card.Text>
          $ <span className="product-price">{product.price}</span>
        </Card.Text>
        <Button className="add-to-cart" name={product.title}>Add to cart</Button>
        <Card.Text className="out-of-stock text-warning">
          {product.stock <= 0 ? stockMessage : ""}
        </Card.Text>
      </Card.Body>
    </Card>
  )
    ;
};
export default ProductItem;
