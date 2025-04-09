# 🍔 Online Food Ordering System - Microservices Architecture

## 📌 Overview

This project implements an **Online Food Ordering System** using the **Spring Boot Microservices architecture**, designed with resilience, scalability, and message-driven interaction in mind.

---

## 🧱 Architecture

### Microservices Involved

| Service            | Description                                                |
|--------------------|------------------------------------------------------------|
| `eureka-server`     | Service Registry using Spring Cloud Eureka                |
| `api-gateway`       | Central entry point using Spring Cloud Gateway            |
| `order-service`     | Manages order placement, validation, RabbitMQ publishing  |
| `restaurant-service`| Manages restaurants, menus, and RabbitMQ order listening  |

---

## 🔁 Service Communication

- **Order Service → Restaurant Service** (via OpenFeign) for item validation
- **Order Service → RabbitMQ** (produces order messages)
- **Restaurant Service → RabbitMQ** (consumes order messages)
- All services registered with **Eureka Server**
- Gateway routes requests using **Spring Cloud Gateway**

---

## 📌 Features Implemented

| Feature                          | Implementation Details                                      |
|----------------------------------|--------------------------------------------------------------|
| ✅ Multiple Microservices         | Order & Restaurant Services                                 |
| ✅ Exception Handling             | Global error handling with `@ControllerAdvice`              |
| ✅ Validation                     | DTO validation using `@Valid`, `javax.validation.constraints` |
| ✅ Eureka Server                  | Service discovery using Netflix Eureka                      |
| ✅ API Gateway                    | Routes `/orders/**`, `/restaurants/**`                      |
| ✅ OpenFeign                     | Inter-service REST calls with fallback via CircuitBreaker   |
| ✅ RabbitMQ                      | Message broker for order events                             |
| ✅ CircuitBreaker                | Resilience4j integrated with Feign clients                  |
| ✅ H2/MySQL Support              | Profile-based DB selection                                  |
| ✅ Dockerized Services            | Each service has its own Dockerfile                         |
| ✅ Docker Compose Integration     | One-click deployment for all services and RabbitMQ          |

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Cloud (Eureka, Gateway, OpenFeign)
- RabbitMQ + Spring AMQP
- Resilience4j
- H2 / MySQL
- Docker & Docker Compose

---

## 📂 Folder Structure

```bash
food-ordering-system/
│
├── eureka-server/
├── api-gateway/
├── order-service/
├── restaurant-service/
├── docker-compose.yml
└── README.md
