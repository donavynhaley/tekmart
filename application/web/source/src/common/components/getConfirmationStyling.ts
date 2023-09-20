const getConfirmationStyling = (confirmationMessage: string): string => {
  const CONFIRMATION_SUCCESS = "Your purchase has been confirmed 🤑"
  return confirmationMessage === CONFIRMATION_SUCCESS
    ? "status-ok" : "status-bad";
}

export default getConfirmationStyling;