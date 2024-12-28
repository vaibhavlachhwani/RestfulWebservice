# REST API Documentation

This README provides a detailed description of the REST API and its endpoints.

---

## **Overview**

The REST API allows users to manage data and interact with a Hello World service. The API is hosted at:

**Base URL:** `http://localhost:8080`

---

## **Table of Contents**

- [Endpoints](#endpoints)
  - [User Management](#1-user-management)
  - [Hello World Service](#2-hello-world-service)
- [Schemas](#schemas)
  - [User](#user)
  - [HelloWorldBean](#helloworldbean)
- [Usage Examples](#usage-examples)

---

## **Endpoints**

### **1. User Management**

#### **GET /api/users**

Retrieve all users.

- **Tags:** `user-controller`
- **Operation ID:** `retrieveAllUsers`
- **Responses:**
  - **200 OK:** Returns an array of user objects.

#### **POST /api/users**

Create a new user.

- **Tags:** `user-controller`
- **Operation ID:** `createUser`
- **Request Body:**
  - Content-Type: `application/json`
  - Schema:
    ```json
    {
      "username": "string",
      "dateOfBirth": "date"
    }
    ```
- **Responses:**
  - **200 OK:** Returns the created user object.

#### **GET /api/users/{id}**

Retrieve a specific user by ID.

- **Tags:** `user-controller`
- **Operation ID:** `retrieveUser`
- **Parameters:**
  - `id` (path) - _integer_: The unique ID of the user.
- **Responses:**
  - **200 OK:** Returns the user object.

#### **DELETE /api/users/{id}**

Delete a specific user by ID.

- **Tags:** `user-controller`
- **Operation ID:** `deleteUser`
- **Parameters:**
  - `id` (path) - _integer_: The unique ID of the user.
- **Responses:**
  - **200 OK:** Indicates the user was successfully deleted.

---

### **2. Hello World Service**

#### **GET /hello-world**

Returns a "Hello, World!" message.

- **Tags:** `hello-world-controller`
- **Operation ID:** `helloWorld`
- **Responses:**
  - **200 OK:** Returns a simple string message.

#### **GET /hello-world/path-var/{name}**

Returns a Hello World message with a path variable.

- **Tags:** `hello-world-controller`
- **Operation ID:** `helloWorldBeanPathVar`
- **Parameters:**
  - `name` (path) - _string_: The name to include in the message.
- **Responses:**
  - **200 OK:** Returns a HelloWorldBean object.

#### **GET /hello-world-bean**

Returns a Hello World message as a bean object.

- **Tags:** `hello-world-controller`
- **Operation ID:** `helloWorldBean`
- **Responses:**
  - **200 OK:** Returns a HelloWorldBean object.

---

## **Schemas**

### **User**

Represents a user in the system.

- **Required Properties:**

  - `username` - _string_: The username of the user.
  - `dateOfBirth` - _string (date)_: The date of birth of the user.

- **Properties:**
  - `id` - _integer_: The unique ID of the user.
  - `username` - _string_: The username of the user.
  - `dateOfBirth` - _string (date)_: The date of birth of the user.

### **HelloWorldBean**

Represents a Hello World message object.

- **Properties:**
  - `message` - _string_: The Hello World message.

---

## **Usage Examples**

### **Retrieve All Users**

```bash
curl -X GET http://localhost:8080/api/users
```
