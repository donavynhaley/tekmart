import {NextPage} from "next";
import {Container, Image} from "react-bootstrap";

const Error: NextPage = () => {
  return (
    <Container>
      <div id="generic-error-view" className="my-5 d-flex justify-content-center">
        <h2 id="error-message">
          Looks like the internet ate our page. Please navigate back to the
          homepage.
        </h2>
      </div>
      <Image className="d-block mx-auto"
             src="https://secure.cdn3.wdpromedia.com/media/pep/live/media/site/img/content/error/2311e7-stitch.jpg"
             alt="error image"/>
    </Container>
  );
};

export default Error;
