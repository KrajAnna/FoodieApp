# FoodieApp

FoodieApp is a web application designed to help users track and manage their restaurant visits. With FoodieApp, users can record each visit, rate restaurants, and calculate various statistics related to their dining experiences. 

## Features

- **User Management**: Support for user login and registration.
- **Record Visits**: Log restaurant visits, including details about the restaurant, date, and time.
- **Rate Places**: Provide ratings for each visit to track your favorite (and not-so-favorite) spots.
- **Adding Places**: Adding restaurants to the database.
- **Statistics Calculation**: Currently includes basic statistics to analyze your dining history and preferences.

## Technology

- **Spring Boot**: For building a production-ready application.
- **Hibernate**: ORM framework for mapping Java objects to database tables.
- **Spring Security**: To secure the application and protect user data.
- **Spring Data JPA**: To simplify data access and manipulation.
- **Thymeleaf**: Replaced JSP views with Thymeleaf templates for a more flexible and modern UI.

## Planned Enhancements

This project is developed with the following enhancements planned for future versions:

1. **External Data Integration**: Implement an option to fetch a database of restaurants from external resources, such as APIs.
2. **User Interface Improvements**: Enhance user experience by introducing additional features for navigation, such as sorting and filtering lists.
3. **Tags and Categorization**: Add tagging functionality and categorize restaurants. This will involve implementation on both the backend and frontend.
4. **Detailed Visit Statistics**: Add more in-depth statistical calculations based on past restaurant visits.
5. **Photo Attachments**: Allow users to upload and attach photos to each visit for a more personalized experience.