# Project Title: Spring Boot Interview Test

## Project Description

This project is a Spring Boot application designed to test a developer's knowledge and skills in Java and Spring Boot. The application is structured around a simple book review system, where books can be retrieved and reviews can be added.

## Scope

The scope of this project is to assess the developer's ability to understand and implement missing functionalities in the existing codebase. The developer is expected to implement methods and classes that are currently empty or missing, ensuring that all the tests pass successfully.

## What Needs to be Implemented

1. **ReviewService**: This service class is responsible for handling review-related operations. The developer needs to implement the following methods:

    - `addReview`: This method should add a new review to a book. It should take a `ReviewRequestDTO` and a book id as parameters, and return the id of the newly created review.

    - `getReviews`: This method should retrieve all reviews of a book. It should take a book id as a parameter, and return a list of `ReviewResponseDTO`.

2. **BookController**: This controller class is responsible for handling HTTP requests related to books. The developer needs to implement the following methods:

    - `addReview`: This method should handle a POST request to add a new review to a book. It should take a `ReviewRequestDTO` and a book id as parameters, and return the id of the newly created review.

    - `getReviews`: This method should handle a GET request to retrieve all reviews of a book. It should take a book id as a parameter, and return a list of `ReviewResponseDTO`.

## Note

Some classes or methods may be missing and need to be implemented by the developer. The developer is expected to understand the existing codebase and implement the missing parts in a way that aligns with the existing code structure and style.

## Getting Started

To get started, clone the repository and import the project into your preferred IDE. Make sure you have Java and Maven installed on your machine. Run the tests to understand what parts of the application are currently failing, and start implementing the missing parts. Good luck!