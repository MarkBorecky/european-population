## Authors comment

I used SpringBoot 3 and Java 19 for develop backend solution.
I've changed a little bit docker file. I used multi-stage build to keep the image clean without unnecessary files.
Furthermore, I created dev profile with h2 DB and some SQL scripts to make easier and faster develop the application.
The application doesn't have much functionality, so I provided just a few tests.
I've extracted preparing test data to script, by @Sql annotation and I avoided multiplication tests by @ParameterizedTest

I saw a lot of production solutions for "browser" problem. I mean endpoint which serve data and consume a range of optional criteria.

All solutions in my opinion ware unpleasant for eyes (real jungle of if's and loops or raw concatenations of strings).
I've decided to use a little bit of functional approach with specifications. It could be a little bit less readable for some developers, but this is more a question of taste. And team should make a common agreement for code standards and style.

Both controllers have just only one endpoint. There could be something to update data, for example population.

An architecture would seem a little bit too complicated, but entity objects don't go out from transaction. And DTO objects has more useful structure for user. And this approach allow avoiding a lot of problems in prospective development.

I use swagger with proper annotation to document application.

During development tests, I find out one fail in data provided by SQL script in sample-database:
Antwerp is not a capital of Belgium, but Brussels:)

Application only read data from DB, so validation wouldn't work.
A possible solution for additional validating data would be filtering data if they meet constraints, like city has to have country, or country has to have a flag.
So this would be solution for not serve data like country "Fiction" to user.

To find cities with greater population than 3 000 000 (from description of this assignment) you have to send request like bellow

    curl -X 'POST' \
      'http://localhost:8080/api/v1/cities' \
      -H 'accept: application/json' \
      -H 'Content-Type: application/json' \
      -d '{
      "populationGreaterThan": 3000000
    }'

!(cities_greater_than_3000000.png)

## How to run application

You can run application with h2 db using local profile by below command from spring-backend folder level

    mvn clean package spring-boot:run -Plocal

Or you can run whole docker compose by

    docker-compose up --build

## How to test

Once you run an application, you can check API with swagger

    http://localhost:8080/swagger-ui/index.html
    
For presentation purpose I also exposed port 8080 so you can use any client like Postman

You can run test using bellow command from spring-backend folder level

    mvn test

