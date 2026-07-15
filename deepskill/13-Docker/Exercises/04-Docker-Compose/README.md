# Exercise 04 — Docker Compose

## Objectives

- Define multi-container applications using docker-compose.yml
- Start all services with a single command
- Understand service dependencies

## Step-by-Step

### 1. Create a Project Directory

```
mkdir my-web-app
cd my-web-app
```

### 2. Create a docker-compose.yml

```yaml
version: '3'
services:
  web:
    image: nginx:latest
    ports:
      - "8080:80"
    depends_on:
      - api
  
  api:
    image: alpine:latest
    command: sh -c "echo 'API service started!' && sleep infinity"
    ports:
      - "3000:3000"
  
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: rootpass
      MYSQL_DATABASE: myapp
      MYSQL_USER: user
      MYSQL_PASSWORD: userpass
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

### 3. Start All Services

```bash
docker-compose up -d
```

This pulls all images and starts all containers defined in the file.

### 4. Check Running Services

```bash
docker-compose ps
```

### 5. View Logs

```bash
docker-compose logs -f
```

Press Ctrl+C to stop following logs.

### 6. Stop All Services

```bash
docker-compose down
```

Add `-v` to also remove volumes: `docker-compose down -v`

## docker-compose.yml Structure

| Key | Description |
|-----|-------------|
| `services` | List of containers to run |
| `image` | Which image to use |
| `ports` | Port mapping (HOST:CONTAINER) |
| `environment` | Environment variables |
| `volumes` | Persistent data storage |
| `depends_on` | Startup order |

## Practice Tasks

1. Add a Redis service to the compose file.
2. Create a custom Dockerfile for the `api` service instead of using alpine.
3. Use `docker-compose scale web=3` (v1) or deploy with `replicas: 3` (v3) to run multiple instances.
