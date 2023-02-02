# Home assignment

Imagine a client has asked you to build a small tool for browsing their EU population data. There is data for countries and some of the cities in those countries. You have two options for the approach:

A) Backend

- Use the [sample database](./sample-database). There is a README file with usage info.
  - Alternatively, you can set up your own database with the csv data ([`countries.csv`](./sample-database/countries.csv) and [`cities.csv`](./sample-database/cities.csv)). If you do, make sure that your submission includes instructions on how to run the database with this data.
- Create a backend that serves the country and city data from the database to users via an API.
  - There should be at least an endpoint for filtering countries based on city size, i.e. it should answer: Which countries have one or more cities that have a population greater than a given value? Which cities are they?
    - For example with 3 000 000 the response should contain data for Spain and Germany with Madrid and Berlin, respectively.
- Include a test case for the main functionality.
- Provide a [Docker](https://www.docker.com/) container setup for you server so we can easily run it regardless of your tech choices.

B) Frontend

- Use the [sample backend](./sample-backend). There is a README file with usage info.
- Create an interactive frontend to display and browse the country and city data provided by the backend's endpoints.
  - Some data should be fetched only after the user interacts with an element.
  - The user should be able to filter countries by population size.
- Include a test case that checks that the main elements are visible on the page.

The assignment will give us material to discuss during your technical interview. We will consider your approach to problem solving, coding style, and knowledge. We are looking for **clear, consistent and clean** code.

As long as your solution fulfils the requirements, you can choose the languages, frameworks, etc. Choose technologies that you know well: we really want to see your core strengths demonstrated.

## How to submit

Please return the assignment with instructions on how to run it either as a Git repository or a zip file. To help us do a fair review, include a short description (for example in the README file) of what you focused on the most in the implementation and if there are any known issues.
