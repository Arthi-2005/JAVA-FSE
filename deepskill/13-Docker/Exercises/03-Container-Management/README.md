# Exercise 03 — Container Management

## Objectives

- Run containers in detached mode
- Map ports from host to container
- Manage container lifecycle (start, stop, remove)

## Step-by-Step

### 1. Run Nginx in Detached Mode

```bash
docker run -d -p 8080:80 --name my-nginx nginx
```

- `-d` — detached mode (runs in background).
- `-p 8080:80` — map host port 8080 to container port 80.
- `--name` — give the container a name.

Open http://localhost:8080 — you should see the Nginx welcome page.

### 2. View Container Logs

```bash
docker logs my-nginx
```

### 3. Stop the Container

```bash
docker stop my-nginx
```

### 4. Start the Container Again

```bash
docker start my-nginx
```

### 5. Remove the Container

First stop it, then:

```bash
docker rm my-nginx
```

### 6. Run with Auto-Remove

```bash
docker run --rm -p 8080:80 nginx
```

The `--rm` flag automatically removes the container when it stops.

## Container Lifecycle

```
docker create → docker start → docker stop → docker rm
               docker run (create + start)
               docker run --rm (create + start + auto-delete on stop)
```

## Commands Summary

| Command | Description |
|---------|-------------|
| `docker run -d -p HOST:CONTAINER image` | Run container in background with port mapping |
| `docker stop <container>` | Gracefully stop a container |
| `docker start <container>` | Start a stopped container |
| `docker restart <container>` | Restart a container |
| `docker rm <container>` | Remove a stopped container |
| `docker logs <container>` | View container logs |
| `docker exec -it <container> sh` | Open a shell inside a running container |

## Practice Tasks

1. Run two nginx containers on different ports (8081:80, 8082:80).
2. Open a shell inside a running nginx container and look at `/usr/share/nginx/html`.
3. Use `docker exec -it my-nginx sh` and modify the index.html, then refresh the browser.
