# Running microservices
1. Download dependencies and build the Springboot applications by executing `mvn clean install` in root folder or the microservice folder
2. Execute `mvn spring-boot:run` to run the service

# Running the website 
1. Navigate to /applications/website and run `composer install` to install dependencies
2. Create the database tables by executing `php artisan migrate`
3. Run the application via `php arisan serve` and open localhost:8000 in your browser