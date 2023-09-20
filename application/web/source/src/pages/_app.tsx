import "@/styles/globals.css";
import type {AppProps} from "next/app";
import "bootstrap/dist/css/bootstrap.css";
import {ErrorBoundary} from "react-error-boundary";
import Error from "./error";

export default function App({Component, pageProps}: AppProps) {
  return (
    <ErrorBoundary fallback={<Error/>}>
      <Component {...pageProps} />
    </ErrorBoundary>
  );
}
