Product Price API 
=================	

## Key Highlights
1. This project exposes end points to perform CRUD operations on product price info.
2. This project can be easily deployed on cloud foundry and scaled independently.
3. Uses mongodb as database storage.
4. API endpoint documentation can be accessed and tried at :  https://target-product-pricing.cfapps.io/swagger-ui.html#/product45price45controller
5. Instance of this project is deployed and publicly available at https://target-product-pricing.cfapps.io/product-price/

### Build and Deploy
1. Create cloud foundry mongo db(mlab) service instance using command `cf create-service mlab sandbox "mongodb"`
2. Update manifest.yml with the mongodb service name.
3. Build using gradle `./gradlew clean assemble`
4. Deploy to cloud foundry using command `cf p product-price -p build/libs/product-price-0.0.1.jar`

