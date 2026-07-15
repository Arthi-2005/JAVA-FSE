# Exercise 01 — Jenkins Setup

## Objectives

- Install and start Jenkins
- Access the Jenkins dashboard
- Create a simple freestyle job

## Step-by-Step

### 1. Install Jenkins (using Docker — easiest way)

```bash
docker pull jenkins/jenkins:lts
docker run -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts
```

If you don't have Docker, download Jenkins from https://www.jenkins.io/download/ and run the installer.

### 2. Unlock Jenkins

- Open http://localhost:8080 in your browser.
- Get the initial admin password:
  ```bash
  docker exec <container-id> cat /var/jenkins_home/secrets/initialAdminPassword
  ```
  (On Windows install: check `C:\ProgramData\Jenkins\.jenkins\secrets\initialAdminPassword`)

### 3. Install Suggested Plugins

- Click "Install suggested plugins" when prompted.
- Create your first admin user.

### 4. Create a Freestyle Job

- Click "New Item" → Enter name "My-First-Job" → Select "Freestyle project" → OK.
- Under "Build", click "Add build step" → "Execute shell" (Linux) or "Execute Windows batch command" (Windows).
- Enter: `echo "Hello from Jenkins!"`
- Click "Save".

### 5. Run the Job

- Click "Build Now".
- Under "Build History", click the build number.
- Click "Console Output" to see the result.

## Commands Summary

| Step | Description |
|------|-------------|
| `docker run -p 8080:8080 jenkins/jenkins:lts` | Start Jenkins in Docker |
| http://localhost:8080 | Jenkins web UI |
| New Item → Freestyle | Create a job |
| Build Now | Trigger a build |
| Console Output | View build logs |

## Practice Tasks

1. Create a job that runs `echo %DATE% %TIME%` (Windows) or `echo $(date)` (Linux).
2. Schedule the job to run every minute using "Build periodically" with `* * * * *`.
3. Create a second job that displays system information.
