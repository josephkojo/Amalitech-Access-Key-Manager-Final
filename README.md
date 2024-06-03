# Access Key Manager
## Project Description
Access Key Manager is a web application designed for Micro-Focus Inc. to manage and monetize access to their school management platform. The application allows school IT personnel to purchase and manage access keys to activate their school accounts. It also provides administrative functionalities for Micro-Focus admins to manage and monitor all access keys generated on the platform. This repository contains the backend(spring boot) and frontend(React) implementation codes.
## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)
- 

## Features
### School IT Personnel
- Signup and login with email verification
- Reset password feature
- View all access keys (active, expired, revoked)
- View key details: status, date of procurement, expiry date
- Restriction to one active key at a time

### Micro-Focus Admin
- Login with email and password
- Manually revoke access keys
- View all keys on the platform with details
- Endpoint to check active key details by school email
