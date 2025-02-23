RealStore is an **e-commerce management system** built with **Spring Boot**, designed to handle categories, products, users, carts, and orders efficiently. This project implements **Spring Security**, custom validations, and database management using **MySQL**. This version is specifically for **Postman-based API testing**.

## Features
- **User Management**: Register, login, and authenticate users.
- **Category Management**: Add, update, and delete product categories.
- **Product Management**: CRUD operations for products.
- **Cart System**: Users can add/remove products from their cart.
- **Order Management**: Users can place and manage orders.
- **Validations & Security**: Custom validation logic and role-based authentication using Spring Security.

## Tech Stack
- **Backend**: Java, Spring Boot, Spring Security
- **Database**: MySQL
- **API Testing**: Postman
- **Build Tool**: Maven

## Installation & Setup
### Prerequisites
- Java 17+
- MySQL Server
- Maven
- Postman

### Steps
1. **Clone the repository**
   ```sh
   git clone https://github.com/shaikirfan2349/RealStore-Postman.git
   cd RealStore-Postman
   ```
2. **Configure Database**
   - Update `application.properties` with your MySQL credentials.
3. **Build & Run the project**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access APIs via Postman**
   - Base URL: `http://localhost:8080/api`

## API Endpoints
### User APIs
- `POST /users/register` – Register a new user
- `POST /users/login` – Authenticate user

### Category APIs
- `GET /categories` – Get all categories
- `POST /categories` – Add a new category

### Product APIs
- `GET /products` – Get all products
- `POST /products` – Add a new product

### Cart & Order APIs
- `POST /cart/add/{productId}` – Add a product to cart
- `POST /orders/place` – Place an order

## Future Enhancements
- Implement a frontend using React or Angular.
- Add payment gateway integration.
- Implement unit and integration tests.
