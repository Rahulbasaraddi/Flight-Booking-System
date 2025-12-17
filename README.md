# Flight Booking System

A robust backend system for managing flight bookings, built with Spring Boot and PostgreSQL. This application provides REST APIs for managing flights, passengers, bookings, and payments.

## 🚀 Technologies Used
- **Java 21**
- **Spring Boot** (Web, Data JPA)
- **PostgreSQL** (Database)
- **Lombok** (Boilerplate reduction)
- **Maven** (Build tool)

## 📂 Project Structure
The project follows a standard layered architecture:
- `controller`: REST API endpoints
- `service`: Business logic
- `dao`: Data Access Object layer
- `repository`: JPA Repositories
- `entity`: JPA Entities (Flight, Booking, Passenger, Payment)
- `exception`: Custom exception handling

## ⚙️ Setup & Installation

### Prerequisites
1. **Java 21** SDK installed.
2. **PostgreSQL** installed and running.
3. **Maven** (optional, wrapper included).

### Database Configuration
1. Create a PostgreSQL database named `Flight`.
2. Update database credentials in `src/main/resources/application.properties` if they differ from the defaults:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/Flight
   spring.datasource.username=postgres
   spring.datasource.password=root
   ```

### Running the Application
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Rahulbasaraddi/Flight-Booking-System.git
   cd Flight-Booking-System/Flight-Booking-System
   ```

2. **Build and Run**:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on port `8080` (default).

## 🔌 API Endpoints
(Based on standard CRUD patterns)

- **Flights**: `/flights` (Add, Update, Search flights)
- **Bookings**: `/bookings` (Book tickets, View history)
- **Passengers**: `/passengers` (Manage passenger details)

## 🤝 Contributing
1. Fork the repository.
2. Create feature branch (`git checkout -b feature/NewFeature`).
3. Commit changes (`git commit -m 'Add NewFeature'`).
4. Push to branch (`git push origin feature/NewFeature`).
5. Open a Pull Request.