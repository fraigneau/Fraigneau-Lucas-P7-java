# Poseidon Capital Solutions Trading Platform

## 🚀 Project Description

Poseidon Capital Solutions Trading Platform is a robust web application for trading management, offering a comprehensive solution for managing transactions, curve points, ratings, and users.

## Documentation

All project documentation is available in the `docs` directory of the GitHub repository and is deployed online:

- [**JaCoCo Reports**](https://fraigneau.github.io/Fraigneau-Lucas-P7-java/jacoco/)
- [**Surfire Reports**](https://fraigneau.github.io/Fraigneau-Lucas-P7-java/surefire/)
- [**JavaDoc**](https://fraigneau.github.io/Fraigneau-Lucas-P7-java/javadoc/)

## 🛠 Technologies Used

- **Backend**:
  - Java 21
  - Spring Boot 3.4.3
  - Spring Security
  - Spring Data JPA
  - MapStruct
  - Lombok

- **Frontend**:
  - Thymeleaf
  - Bootstrap 4
  - HTML5

- **Database**:
  - MySQL

- **Testing Tools**:
  - JUnit 5
  - Mockito
  - Spring Test

- **API Documentation**:
  - SpringDoc OpenAPI (Swagger)

## 🏗️ Architecture Overview

The application follows a monolithic architecture organized in layers according to the MVC (Model-View-Controller) pattern:

### Architectural Layers

1. **Presentation Layer**: 
   - Controllers handle HTTP requests
   - Thymeleaf templates render the UI
   - DTOs (Data Transfer Objects) for data exchange with client

2. **Service Layer**:
   - Business logic implementation
   - Transaction management
   - Data validation and processing

3. **Data Access Layer**:
   - Spring Data JPA repositories
   - Entity models representing database tables
   - Data persistence operations

4. **Cross-Cutting Concerns**:
   - Security
   - Exception handling
   - Logging
   - Configuration

### Design Patterns Used

- **DTO Pattern**: Separate data transfer objects from domain models
- **Repository Pattern**: Abstract data access operations
- **Dependency Injection**: Spring's IoC container manages component dependencies
- **MVC Pattern**: Separation of concerns between Models, Views, and Controllers

## 🔐 Security Architecture

The application implements a comprehensive security model using Spring Security:

### Authentication

- Form-based authentication with username and password
- BCrypt password encoding for secure storage
- Custom UserDetailsService implementation that loads user data from the database

### Authorization

- Role-based access control with distinct ADMIN and USER roles
- Method-level security using `@PreAuthorize` annotations
- URL-based security patterns in SecurityFilterChain configuration

### Security Rules

1. **ADMIN Role**:
   - Full access to all features and operations (CRUD)
   - Can manage all users and system settings

2. **USER Role**:
   - Read-only access to most resources (view-only)
   - Limited modification capabilities
   - Can edit their own profile with conditional authorization:
     ```java
     @PreAuthorize("hasAuthority('ADMIN') or #id == authentication.principal.id")
     ```

3. **UI Security Integration**:
   - Thymeleaf Security integration with `sec:authorize` attributes
   - Dynamic UI that only displays available actions based on user permissions:
     ```html
     <div sec:authorize="hasAuthority('ADMIN')">
       <!-- Admin-only content -->
     </div>
     ```

4. **Security Configuration**:
   - Custom security filter chain
   - Protected endpoints except login and error pages
   - CSRF protection enabled
   - Session management

## ✨ Key Features

1. **User Management**
   - Authentication and authorization
   - User creation, modification, and deletion
   - Different roles (ADMIN, USER)

2. **Bid List Management**
   - Bid creation and tracking
   - Complete CRUD operations

3. **Curve Points**
   - Financial curve point management
   - Data tracking and analysis

4. **Ratings**
   - Management of Moody's, S&P, and Fitch ratings
   - Financial ranking tracking

5. **Transactions**
   - Transaction recording and tracking
   - Comprehensive transaction details

6. **Custom Rules**
   - Business rule creation and management
   - Flexibility for specific configurations

## 📦 Project Structure

```
src
├── main
│   ├── java
│   │   └── com/poseidoncapitalsolutions/trading
│   │       ├── config           # Spring Configuration
│   │       │   ├── SecurityConfig.java  # Security settings
│   │       │   ├── SwaggerConfig.java   # API documentation
│   │       │   ├── UserDetailsServiceImpl.java  # Authentication service
│   │       │   └── UserDetailsImpl.java # User details implementation
│   │       ├── controller       # Spring MVC Controllers
│   │       ├── dto              # Data Transfer Objects
│   │       ├── exception        # Custom Exception Handling
│   │       ├── mapper           # MapStruct Mappers
│   │       ├── model            # JPA Entities
│   │       ├── repository       # Spring Data Repositories
│   │       └── service          # Business Services
│   └── resources
│       ├── static               # Static Resources
│       ├── templates            # Thymeleaf Templates
│       └── application.properties
└── test                         # Unit and Integration Tests
```

## 🚀 Installation and Configuration

### Prerequisites
- Java 21
- Maven
- MySQL

### Installation Steps

1. Clone the repository
```bash
git clone https://github.com/fraigneau/Fraigneau_Lucas_P7_Java.git
cd Fraigneau_Lucas_P7_Java
```

2. Configure the Database
- Create a MySQL database
- Update `application.properties` with your credentials

3. Compile and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

## 🧪 Testing

- Unit testing with JUnit and Mockito
- Test coverage managed by JaCoCo
- Run tests:
```bash
mvn test
```

## 📊 API Documentation

- Swagger UI accessible at: `/swagger`
- OpenAPI documentation at: `/api-docs`

## 🔒 Default Credentials

- **Admin**:
  - Username: admin
  - Password: 123123

- **Standard User**:
  - Username: user
  - Password: 123123

## 🌟 Best Practices

- **Clean Code**: Following SOLID principles and clean code practices
- **Security**: Implementing defense in depth with multiple security layers
- **Testing**: Comprehensive unit and integration tests
- **Documentation**: Well-documented code with JavaDoc
- **DTO Pattern**: Separation of entity models from data transfer objects
- **Validation**: Input validation at multiple levels