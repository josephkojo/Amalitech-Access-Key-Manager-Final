# Access Key Manager
## Deployed link is https://accesskey.onrender.com/
## Project Description

Access Key Manager is a web application designed for Micro-Focus Inc. to manage and monetize access to their school management platform. The application allows school IT personnel to purchase and manage access keys to activate their school accounts. It also provides administrative functionalities for Micro-Focus admins to manage and monitor all access keys generated on the platform. This repository contains the backend(spring boot) and frontend(React) implementation codes.
## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)

- 

## Features
### School IT Personnel
- Signup and login with email verification
- Reset password feature
- View all access keys (active, expired, revoked)
- View key details: status, date of procurement, expiry date
- Restriction to one active key at a time

### Micro-Focus Admin 
To login in as an admin  then enter the following credentials 
## Admin email is mosesmensah081@gmail.com
## Admin password is kojo@23
- Login with email and password
- Manually revoke access keys
- View all keys on the platform with details
- Endpoint to check active key details by school email

## Technologies Used
 

### Spring Boot(Backend)
Spring Boot is a powerful, easy-to-use framework for building Java-based web applications. It simplifies the setup and development of new Spring applications, providing a wide range of out-of-the-box functionalities to help developers build production-ready applications quickly and efficiently.

### PostgreSQL
PostgreSQL is a robust, open-source relational database management system. Known for its reliability, feature robustness, and performance, PostgreSQL is an ideal choice for handling complex queries and large datasets.

### Docker
Docker is a platform for developing, shipping, and running applications inside containers. By using Docker, we can ensure that our application runs consistently across different environments. Docker simplifies the deployment process and allows for easier management of dependencies and configurations.

### Key Components:
- **Spring Boot Application**: The core of our backend is built using Spring Boot, providing RESTful APIs to handle user authentication, access key management, and administrative tasks.
- **Spring Data JPA**: This abstraction layer simplifies the database interactions and ORM (Object Relational Mapping) capabilities, enabling seamless integration with PostgreSQL.
- **PostgreSQL Database**: All application data is stored in a PostgreSQL database, which is containerized using Docker for easy setup and management.
- **Docker Compose**: Utilized for defining and running multi-container Docker applications. The backend services and PostgreSQL database are orchestrated using Docker Compose, ensuring they run smoothly together.
- **Spring Security**: Provides robust security features, including authentication and authorization, ensuring that only authenticated users can access the application’s functionalities.
- **JWT (JSON Web Token)**: Used for secure authentication and session management, providing a stateless way to handle user sessions.

### Setup and Deployment:
- **Dockerfile**: A Dockerfile is used to containerize the Spring Boot application, defining the environment and dependencies required to run the application.
- **docker-compose.yml**: This file is used to define and manage the multi-container setup, including both the Spring Boot application and the PostgreSQL database. Docker Compose ensures that all services start in the correct order and can communicate with each other seamlessly.

  ### The  github repository for the backened (spring boot) is:
  - #### Github repository for only the backend (spring boot) is https://github.com/josephkojo/backend.git


### Frontend
- **React**: A JavaScript library for building user interfaces, providing a component-based architecture and a reactive data flow.
- Github repository for only the frontend(react) is https://github.com/josephkojo/frontend.git


## API Endpoints

### School IT Personnel
- **POST https://access-key.onrender.com/auth/register** - Signup a new user
- **POST https://access-key.onrender.com/auth/login** - Login a user
- **POST https://access-key.onrender.com/forgotPassword/email** - verify email to  Request password reset
-  **POST https://access-key.onrender.com/forgotPassword/verify** - verify otp for password reset
-  **POST https://access-key.onrender.com/forgotPassword/changePassword** - change password  for password reset
- **GET https://access-key.onrender.com/user/accessKeys/{Id}** - Get all access keys for the logged-in user
- **POST https://access-key.onrender.com/user/generateKey/{Id}** - Generate access keys by particular user

### Micro-Focus Admin
- **POST https://access-key.onrender.com/auth/login** - Login an admin with email mosesmensah081@gmail.com  and password  kojo@23
- **PUT https://access-key.onrender.com/admin/revokeKey/{Id}** - Revoke an access key
- **GET https://access-key.onrender.com/admin/getAllKeys** - Get all keys on the platform
- **GET https://access-key.onrender.com/admin/getActiveKey/{email}** - Check active key status by school email



## Entity Relationship Diagram (ER Diagram)


  



## Entity Relationship Diagram (ER)

    



