# Home assignment

Imagine a client has asked you to build a small tool for browsing their EU population data. There is data for countries and some of the cities in those countries. You have two options for the approach (both require [Docker](https://www.docker.com/) with Compose V2):

A) Backend

- Use the sample PostgreSQL [database](./database). There is a README file with usage info.
  - Alternatively, you can set up your own database with the csv data ([`countries.csv`](./database/countries.csv) and [`cities.csv`](./database/cities.csv)). If you do, make sure that your submission includes instructions on how to run the database with this data.
- Create a backend that serves the country and city data from the database to users via an API. There should be at least an endpoint that answers:
  - Which countries have one or more cities that have a population greater than a given value? Which cities are they?
    - For example with 3 000 000 the answer is Spain (Madrid, 3305408) and Germany (Berlin, 3677472).
- Include a test case for the main functionality.
- Use Docker so we can easily run your server regardless of other tech choices.

B) Frontend

- Use the sample [backend](./backend). There is a README file with usage info.
- Create an interactive frontend to display and browse the country and city data provided by the backend’s endpoints.
  - Some data should be fetched only after the user interacts with an element.
  - The user should be able to find countries by population size.
- Include a test case that checks that the main elements are visible on the page.
- Provide a Docker setup or a built bundle along with the source code so we can easily run your solution regardless of other tech choices.

The assignment will give us material to discuss during your technical interview. We will consider your approach to problem solving, coding style, and knowledge. We are looking for clear, consistent and clean code.

As long as your solution fulfills the requirements, you can choose the languages, frameworks, etc. Choose technologies that you know well: we really want to see your core strengths demonstrated.

## How to submit

Please return the assignment with instructions on how to run it either in a Git repository or a zip file. To help us do a fair review, include a short description (for example in the README file) of what you focused on the most in the implementation and if there are any known issues.
