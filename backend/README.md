# Population backend

A small Node.JS backend server running in a [Docker](https://www.docker.com/) container. The implementation is not very clean or elegant on purpose.

The backend serves a JSON REST API with the following endpoints:

- GET `/countries`

  - Returns an array of country data objects
    - Example object:
    ```json
    {
      "name": "Finland",
      "code": "FIN",
      "flag": "\uD83C\uDDEB\uD83C\uDDEE",
      "population": 5530719
    }
    ```

- GET `/cities?country={CODE}`
  - Returns an array of city objects belonging to the given country/countries
    - Example object:
    ```json
    {
      "countrycode": "FIN",
      "name": "Helsinki",
      "capital": true,
      "population": 658864
    }
    ```
  - The `country` parameter is the three character ISO country code
  - Supports multiple values, for example `?country=FIN&country=SWE`

## Running

To create and run the backend container for the first time, run in this folder:

```
docker compose up
```

This will build the image (if it does not exist) and run a container named  `population_backend`.

The API can be then accessed at `http://localhost:3001`.

If you are calling the API from another Docker container, you need to create a network (`docker network create <networkName>`) and attach both containers to it (`docker network connect <networkName> <containerName>`). Then the API can be accessed at `http://population_backend:3001`).
