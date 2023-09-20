const getUrlParams = (query: string): string => {
  const urlParams = new URLSearchParams(window.location.search);
  const result = urlParams.get(query);
  return typeof result === "string" ? result : "";
}
export default getUrlParams