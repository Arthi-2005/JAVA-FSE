# Exercise 02 — Docker Images

## Objectives

- Pull images from Docker Hub
- Build a custom image using a Dockerfile
- List and remove images

## Step-by-Step

### 1. Pull an Existing Image

```bash
docker pull alpine
```

Alpine is a tiny Linux distribution (~5 MB).

### 2. Run a Command in Alpine

```bash
docker run alpine echo "Hello from Alpine!"
```

### 3. Create a Dockerfile

Create a file named `Dockerfile` (no extension):

```dockerfile
FROM alpine:latest
RUN apk add --no-cache curl
CMD ["sh", "-c", "echo 'Container is ready!' && curl --version"]
```

### 4. Build the Image

In the same directory as the Dockerfile:

```bash
docker build -t my-alpine:1.0 .
```

- `-t` tags the image as `my-alpine:1.0`.
- `.` means use the current directory as build context.

### 5. Run Your Custom Image

```bash
docker run my-alpine:1.0
```

You should see "Container is ready!" followed by the curl version.

### 6. View Your Images

```bash
docker images
```

Find your `my-alpine` image in the list.

## Dockerfile Commands

| Instruction | Description |
|-------------|-------------|
| `FROM` | Base image to start from |
| `RUN` | Execute a command during build |
| `COPY` | Copy files from host to image |
| `CMD` | Default command when container starts |
| `EXPOSE` | Document which port the container listens on |

## Practice Tasks

1. Create a Dockerfile that copies a simple `index.html` into an nginx image.
2. Build and tag it as `my-nginx:1.0`.
3. Remove the `hello-world` image using `docker rmi hello-world`.
