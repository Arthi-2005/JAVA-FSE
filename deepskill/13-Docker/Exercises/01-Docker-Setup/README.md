# Exercise 01 — Docker Setup

## Objectives

- Install Docker Desktop
- Run your first container
- Learn basic Docker commands

## Step-by-Step

### 1. Install Docker Desktop

- Download from https://www.docker.com/products/docker-desktop/
- Run the installer and follow the instructions.
- After installation, Docker runs in the system tray.

### 2. Verify Installation

Open a terminal (Command Prompt or PowerShell) and run:

```bash
docker --version
```

You should see output like: `Docker version 24.0.7, build afdd53b`

### 3. Run Hello World

```bash
docker run hello-world
```

This command:
- Pulls the `hello-world` image from Docker Hub (if not already downloaded).
- Creates a container from that image.
- Displays a welcome message.

Expected output:

```
Hello from Docker!
This message shows that your installation appears to be working correctly.
...
```

### 4. List Docker Images

```bash
docker images
```

Shows all downloaded images, including `hello-world`.

### 5. List Running Containers

```bash
docker ps
```

Note: The hello-world container already exited, so add `-a` to see all containers:

```bash
docker ps -a
```

## Commands Summary

| Command | Description |
|---------|-------------|
| `docker --version` | Check Docker version |
| `docker run hello-world` | Run your first container |
| `docker images` | List downloaded images |
| `docker ps` | List running containers |
| `docker ps -a` | List all containers |
| `docker info` | Display system-wide info |

## Practice Tasks

1. Run `docker run nginx` and access http://localhost to see if it works (hint: use `-p 8080:80`).
2. Use `docker ps` to see the running nginx container.
3. Stop the container with `docker stop <container-id>`.
