# REST API Documentation

## Overview
This document provides details about the REST API endpoints available in the application.

### Base URL
- `http://localhost:8080`

---

## Endpoints

### User Controller

#### Retrieve All Users
- **URL:** `/api/users`
- **Method:** `GET`
- **Operation ID:** `retrieveAllUsers`
- **Description:** Retrieve a list of all users.
- **Responses:**
  - **200 OK:** Returns an array of users.
    ```json
    [
      {
        "id": 1,
        "username": "string",
        "dateOfBirth": "YYYY-MM-DD"
      }
    ]
    ```

#### Create a User
- **URL:** `/api/users`
- **Method:** `POST`
- **Operation ID:** `createUser`
- **Description:** Create a new user.
- **Request Body:**
  ```json
  {
    "username": "string",
    "dateOfBirth": "YYYY-MM-DD"
  }
  ```
- **Responses:**
  - **200 OK:** Returns the created user object.

#### Retrieve a User by ID
- **URL:** `/api/users/{id}`
- **Method:** `GET`
- **Operation ID:** `retrieveUser`
- **Description:** Retrieve a user by their unique ID.
- **Path Parameters:**
  - `id` (integer): User ID.
- **Responses:**
  - **200 OK:** Returns the user object.
    ```json
    {
      "id": 1,
      "username": "string",
      "dateOfBirth": "YYYY-MM-DD"
    }
    ```

#### Delete a User by ID
- **URL:** `/api/users/{id}`
- **Method:** `DELETE`
- **Operation ID:** `deleteUser`
- **Description:** Delete a user by their unique ID.
- **Path Parameters:**
  - `id` (integer): User ID.
- **Responses:**
  - **200 OK:** User successfully deleted.

---

### Hello World Controller

#### Hello World
- **URL:** `/hello-world`
- **Method:** `GET`
- **Operation ID:** `helloWorld`
- **Description:** Returns a simple "Hello World" message.
- **Responses:**
  - **200 OK:** Returns a string message.
    ```json
    "Hello World!"
    ```

#### Hello World Bean
- **URL:** `/hello-world-bean`
- **Method:** `GET`
- **Operation ID:** `helloWorldBean`
- **Description:** Returns a "Hello World" message wrapped in an object.
- **Responses:**
  - **200 OK:** Returns an object with a message property.
    ```json
    {
      "message": "Hello World!"
    }
    ```

#### Hello World with Path Variable
- **URL:** `/hello-world/path-var/{name}`
- **Method:** `GET`
- **Operation ID:** `helloWorldBeanPathVar`
- **Description:** Returns a "Hello World" message customized with the provided name.
- **Path Parameters:**
  - `name` (string): The name to include in the message.
- **Responses:**
  - **200 OK:** Returns an object with a personalized message.
    ```json
    {
      "message": "Hello, {name}!"
    }
    ```

---

## Schemas

### User
- **Type:** Object
- **Required Properties:**
  - `username` (string)
  - `dateOfBirth` (string, format: date)
- **Optional Properties:**
  - `id` (integer, format: int32)

### HelloWorldBean
- **Type:** Object
- **Properties:**
  - `message` (string)
