# Zimasa API Task — RestAssured Assessment

## Overview

This project is a REST-assured test suite built in Java, covering the **Testimonials** and **Courses** API endpoints. It demonstrates chaining tests, variable reuse across tests, negative assertions, and both types of parameters (query and path). The suite is structured for clarity, scalability, and Allure report generation.

---

## Assessment Requirements

| Requirement | Status |
|---|---|
| Create Testimonial | ✅ |
| Update Testimonial | ✅ |
| Delete Testimonial | ✅ |
| Get Course (Beginner level, Category: automation) | ✅ |
| Negative assertions | ✅ |
| Query & path parameter usage | ✅ |
| Allure report included | ✅ |

---

## Project Structure

```
restassured-assessment/
├── pom.xml
├── README.md
└── src/
    └── test/
        ├── java/
        │   ├── commons/
        │   │   └── Paths.java                    ← Base URLs and endpoint paths
        │   ├── payloadBuilder/
        │   │   ├── TestimonialPayload.java        ← Request body builder for testimonials
        │   │   └── UserPayload.java               ← User-related payload builder
        │   ├── requestBuilder/
        │   │   ├── AdminRequestBuilder.java       ← Admin-authenticated request setup
        │   │   └── UserRequestBuilder.java        ← User-authenticated request setup
        │   └── tests/
        │       ├── TestimonialsTest.java          ← TC01–TC06: Create / Update / Delete + Negatives
        │       └── CoursesTest.java               ← TC07–TC12: Get Courses (query & path params) + Negatives
        └── resources/
            └── testng.xml                         ← Suite ordering & Allure listener
```

---

## Test Cases

### Testimonials (`TestimonialsTest.java`)

| ID | Test Name | Type | Description |
|---|---|---|---|
| TC01 | `createTestimonial_positive` | Positive | Creates a testimonial with valid data; asserts `201` and response body |
| TC02 | `updateTestimonial_positive` | Positive | Updates an existing testimonial using its ID (path param); asserts `200` |
| TC03 | `deleteTestimonial_positive` | Positive | Deletes a testimonial using chained ID from TC01; asserts `200` |

### Courses (`CoursesTest.java`)

| ID | Test Name | Type | Description |
|---|---|---|---|
| TC04 | `getCourses_byLevel&category_positive` | Positive | Fetches courses filtered by `level=Beginner` (query param), `category=automation` (query param); asserts `200` |

---

## Key Design Decisions

### Chained Tests
The `testimonialId` created in **TC01** is stored as a static variable and reused in TC02 and TC03 — demonstrating test chaining within a suite.

### Separation of Concerns
- **`AdminRequestBuilder`** and **`UserRequestBuilder`** extend the base to handle their respective authentication
- **`Paths.java`** centralises all endpoint strings — no hardcoded URLs in test classes

### Faker for Test Data
[JavaFaker](https://github.com/DiUS/java-faker) is used in `@BeforeClass` to generate realistic, randomised test data for each run, keeping tests independent of fixed data.

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java 11+ | Language |
| RestAssured | HTTP client & assertion library |
| TestNG | Test runner & suite management |
| JavaFaker | Random test data generation |
| Allure | Test reporting |
| Maven | Build & dependency management |

---

## Prerequisites

- Java 11 or higher
- Maven 3.6+

---

## Running the Tests

### Run the full suite
```bash
mvn clean test
```

### Run with Allure report generation
```bash
mvn clean test
mvn allure:serve
```

The `allure:serve` command will build and open the report in your default browser.

---

## Allure Report

After running `mvn allure:serve`, the report includes:

- Pass/fail breakdown per test
- Request and response logs per test step
- Suite-level grouping (Testimonials vs Courses)

The Allure listener is registered in `src/test/resources/testng.xml`.

---

## Credentials Used

| Role | Email             | Password |
|---|-------------------|---|
| Admin | `admin@gmail.com` | `@12345678` |


---

## Repository

This project was submitted as part of the Zimasa API assessment task.  
Repository: [github.com/your-username/restassured-assessment](https://github.com/your-username/restassured-assessment)
