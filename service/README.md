### Service

- To start service run the command in 'tekmart-service' directory
> 'mvn clean spring-boot:run'

or 

> '\mvnw clean spring-boot:run'

- To run service integration/functional tests run this line in 'tekmart-service-test' directory
> './gradlew clean [Test Suite]' 
- Please ensure to have a stripe API KEY in 'application.properties' file.
  - EX. stripe.apiKey=Bearer [BEARER TOKEN]

### Stripe

- To run stripe integration/functional tests run './gradlew clean [Test Suite]' in 'stripe' directory
- Please ensure to have a stripe API KEY in 'local.properties' file.
- Please ensure to have a stripe BASE URL in 'local.properties' file.
  - EX stripeKey=[API_STRIPE_KEY_GOES_HERE]
  - EX baseUrl=[API_BASE_URL_GOES_HERE]
