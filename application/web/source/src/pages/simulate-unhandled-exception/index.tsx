import {NextPage} from "next";
import {useEffect} from "react";

const SimulateUnhandledException: NextPage = () => {
  useEffect(() => {
    throw new Error("Simulated Error");
  }, []);
  return <div id="simulate-error-view"></div>;
};

export default SimulateUnhandledException;
