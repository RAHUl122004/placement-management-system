# Placement Management System

## Overview

A Spring Boot backend application for managing campus placements. The system allows students to apply for jobs, companies to post job opportunities, and administrators to manage the platform. It includes secure JWT-based authentication and role-based authorization.

## Features

* JWT Authentication and Authorization
* Role-Based Access Control (STUDENT, COMPANY, ADMIN)
* Student Registration and Management
* Company Registration and Management
* Job Posting and Management
* Job Application System
* Duplicate Application Prevention
* Pagination and Sorting
* Custom Query Methods
* Global Exception Handling
* Input Validation using Jakarta Validation
* Password Encryption using BCrypt

## Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Database Entities

### User

* id
* username
* password
* role

### Student

* id
* name
* email
* skills
* cgpa

### Company

* id
* name
* email
* industry
* location

### Job

* id
* title
* description
* salary
* location
* requiredSkills

### Application

* id
* status
* appliedAt

## Security Features

* JWT Token Authentication
* BCrypt Password Encryption
* Protected REST APIs
* Role-Based Access Control
* Unauthorized Access Prevention

## API Endpoints

### Authentication

* POST /auth/register
* POST /auth/login

### Jobs

* POST /jobs
* GET /jobs
* GET /jobs/page
* GET /jobs/salary
* GET /jobs/location

### Applications

* POST /applications
* GET /applications

## Screenshots

Screenshots are available in the screenshots folder.

## How to Run

1. Clone the repository
2. Configure MySQL database
3. Update application.properties
4. Run:

mvn spring-boot:run

5. Test APIs using Postman

## Future Improvements

* Swagger/OpenAPI Documentation
* Resume Upload Feature
* Email Notifications
* Advanced Job Search
* Admin Dashboard

## Author

Rahul Choudhary
