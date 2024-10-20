QuizApp

This is a Quiz Application that allows users to participate in quizzes on various topics. The application provides features to create, manage, and participate in quizzes. It includes components for handling quizzes, managing scores, and providing real-time feedback to users. The project is structured with clear separation between the front-end and back-end functionality.

Features

Quiz Management: Create, retrieve, update, and delete quizzes.
Real-Time Feedback: Provides feedback to users on their answers during the quiz.
Score Tracking: Calculates and displays the user’s score after quiz completion.
User-Friendly Interface: Interactive and easy-to-navigate user interface.
Responsive Design: Optimized for desktop and mobile platforms.

Project Structure
src/
├── main/
│   ├── java/com/dilip/quizapp/
│   │   ├── QuizAppApplication.java         # Main application class
│   │   ├── controller/QuizController.java  # REST controller for quiz operations
│   │   ├── dto/QuizDto.java                # Data Transfer Object for quizzes
│   │   ├── entity/Quiz.java                # Quiz entity representing database table
│   │   ├── repository/QuizRepository.java  # Repository interface for quiz persistence
│   │   ├── service/                        # Business service logic
│   │   │   ├── QuizService.java
│   │   │   └── impl/QuizServiceImpl.java   # Implementation of QuizService
│   ├── resources/
│   │   ├── application.properties          # Application configuration
│   └── test/java/com/dilip/quizapp/
│       └── QuizAppApplicationTests.java    # Unit tests for the application


Technologies Used

Java 21: Core programming language
Spring Boot 3.24: Framework for building the application
Maven: Build automation tool
MySQL: Database for storing quiz data
Spring Data JPA: For repository and database interactions
Lombok: Reduces boilerplate code for entity classes
JUnit: Used for unit testing the application


Getting Started

Prerequisites
Java 21 installed
Maven 3.x or higher
MySQL (or any other relational database)
Git for version control

Installation
1.Clone the repository:
git clone https://github.com/pdilip2895/QuizApp.git

2.Navigate into the project directory:
cd QuizApp

3.Install dependencies:
mvn install

4.Configure the database connection in application.properties.

5.Run the application:
mvn spring-boot:run

Example Endpoints

GET /api/v1/quizzes – Get all quizzes
POST /api/v1/quizzes – Create a new quiz
GET /api/v1/quizzes/{id} – Get quiz details by ID
PUT /api/v1/quizzes/{id} – Update quiz details
DELETE /api/v1/quizzes/{id} – Delete a quiz

Contributing

1.Fork the repository.
2.Create a new branch:
git checkout -b feature/your-feature-name

3.Commit your changes:
git commit -m "Add a new feature"

4.Push to the branch:
Push to the branch:
git push origin feature/your-feature-name

5.Open a pull request
