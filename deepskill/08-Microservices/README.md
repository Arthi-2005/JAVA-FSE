# Module 8: Microservices (Spring Cloud)

**Status:** ✅ Successful

## Structure
```
08-Microservices/
├── pom.xml                 # Parent POM
├── service-registry/       # Eureka Server (port 8761)
├── user-service/           # User API (port 8081)
├── order-service/          # Order API (port 8082)
└── api-gateway/            # Spring Cloud Gateway (port 8080)
```

## Services
| Service | Port | Role |
|---------|------|------|
| **Service Registry** | 8761 | Eureka — all services register here |
| **User Service** | 8081 | CRUD for users |
| **Order Service** | 8082 | CRUD for orders |
| **API Gateway** | 8080 | Entry point, routes to services |

## Flow
```
Client → API Gateway (8080) → User Service (8081) or Order Service (8082)
                              ↓
                        Service Registry (8761)
```

## Run
```bash
cd "08-Microservices"
mvn spring-boot:run -pl service-registry
mvn spring-boot:run -pl user-service
mvn spring-boot:run -pl order-service
mvn spring-boot:run -pl api-gateway
```
