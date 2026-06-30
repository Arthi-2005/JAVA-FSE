# Module 7: Spring REST

**Status:** ✅ Successful

## Structure
```
07-Spring-REST/
├── pom.xml
├── src/main/java/com/deepskilling/rest/
│   ├── RestApplication.java
│   ├── controller/ProductController.java
│   ├── dto/ProductDTO.java
│   └── exception/
│       ├── GlobalExceptionHandler.java
│       └── ResourceNotFoundException.java
└── screenshots/
```

## Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get by ID |
| POST | `/api/products` | Create product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

## Sample Request
```json
POST /api/products
{ "name": "Laptop", "price": 999.99 }
```

## Run
```bash
cd "07-Spring-REST"
mvn spring-boot:run
```
