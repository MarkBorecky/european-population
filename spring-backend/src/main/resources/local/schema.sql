CREATE TABLE country (
                         code VARCHAR (3) PRIMARY KEY,
                         name VARCHAR (50) NOT NULL,
                         flag VARCHAR (50),
                         population INT
);

CREATE TABLE city (
                      id serial PRIMARY KEY,
                      countrycode VARCHAR (3) NOT NULL,
                      name VARCHAR (50) NOT NULL,
                      capital BOOLEAN,
                      population INT,
                      FOREIGN KEY (countrycode)
                          REFERENCES country (code)
);