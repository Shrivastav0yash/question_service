# Question Service

Question Service is a Spring Boot microservice responsible for managing and serving question-related data for a Quiz Application built using a microservices architecture.

It acts as the central source of question data and provides APIs for question management, category-based retrieval, and quiz generation support. This service is designed to work alongside the Quiz Service while maintaining complete database independence.

---

## Project Context

This repository contains the **Question Service** of a Quiz Application built using microservices.

### Current Services

- Question Service ✅
- Quiz Service 🚧 (In Development)

Each service maintains its own database and communicates through APIs, following microservice best practices and ensuring service independence.

---

## Responsibilities

The Question Service is responsible for:

- Managing question data
- Creating and storing questions
- Retrieving questions by category
- Generating question sets for quizzes
- Fetching question details by IDs
- Providing question-related APIs to other services
- Supporting inter-service communication

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA

### Database
- MySQL

### Build Tool
- Maven

### Additional Libraries
- Lombok

---

## Features

- Add new questions
- Retrieve all questions
- Retrieve questions by category
- Generate random questions for quiz creation
- Fetch questions using question IDs
- RESTful API development
- Database persistence with JPA
- Layered architecture implementation

---

## Architecture

```text
                 REST API Communication

┌─────────────────────┐
│     Quiz Service    │
│   (In Development)  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Question Service  │
└─────────────────────┘

      │                        │
      ▼                        ▼

┌──────────────┐      ┌──────────────┐
│   Quiz DB    │      │ Question DB  │
└──────────────┘      └──────────────┘
```

The Quiz Service communicates with the Question Service through REST APIs. Each service owns its database and does not directly access another service's data store.

---

## Database Design

This project follows the **Database-per-Service** pattern.

- Question Service → Question Database
- Quiz Service → Quiz Database

### Benefits

- Loose coupling between services
- Independent schema evolution
- Better scalability
- Service autonomy
- Easier maintenance and deployment
- Improved fault isolation

---

## Project Structure

```text
src
├── controller
├── service
├── repository
├── entities
├── dto
└── config
```

---

## Future Enhancements

As the Quiz Application evolves, the following enhancements may be added:

- Service Discovery (Eureka)
- API Gateway
- OpenFeign Client
- Docker Containerization
- Centralized Configuration
- Monitoring and Logging
- Authentication and Authorization
- Caching for Improved Performance

---

## Learning Objectives

This project was built to gain hands-on experience with:

- Spring Boot
- Microservices Architecture
- REST API Development
- Inter-Service Communication
- Database Design
- Backend Scalability
- Distributed System Concepts

---

## Author

**Yash Shrivastav**

Java Backend Developer focused on building scalable applications using Spring Boot, Microservices, and modern backend technologies.

---

## Note

This repository contains only the **Question Service**. The **Quiz Service** is being developed separately as part of the same Quiz Application ecosystem. Together, these services demonstrate a practical implementation of microservice architecture where each service owns its data and communicates through well-defined APIs.
