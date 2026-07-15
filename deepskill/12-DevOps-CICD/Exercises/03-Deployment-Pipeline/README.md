# Exercise 03 — Deployment Pipeline

## Objectives

- Create a multi-step Jenkins pipeline
- Deploy a built artifact to a staging server
- Understand build promotion

## Step-by-Step

### 1. Create a Pipeline Job

- New Item → "Deployment-Pipeline" → "Pipeline" → OK.
- Scroll to "Pipeline" section.

### 2. Write a Pipeline Script

In the Pipeline section, select "Pipeline script" and enter:

```groovy
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                // In real project: git clone <repo-url>
            }
        }
        stage('Build') {
            steps {
                echo 'Building the application...'
                // In real project: bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // In real project: bat 'mvn test'
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging server...'
                // In real project: copy artifact to server
            }
        }
        stage('Smoke Test') {
            steps {
                echo 'Running smoke tests...'
                // In real project: curl http://staging-server/health
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
```

### 3. Run the Pipeline

- Click "Build Now".
- Watch each stage execute in the "Stage View".
- Click on individual stages to see their logs.

## Pipeline Stages Explained

| Stage | Purpose |
|-------|---------|
| Checkout | Get the latest code from version control |
| Build | Compile code and package artifacts |
| Test | Run unit and integration tests |
| Deploy | Copy artifacts to the target environment |
| Smoke Test | Quick verification that deployment works |

## Practice Tasks

1. Add a "Notification" stage that sends an email.
2. Add an `input` step to require manual approval before deployment.
3. Create a pipeline with parallel stages using `parallel {}`.
