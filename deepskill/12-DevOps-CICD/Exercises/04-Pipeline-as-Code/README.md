# Exercise 04 — Pipeline as Code (Jenkinsfile)

## Objectives

- Write a Jenkinsfile in your repository
- Use declarative pipeline syntax
- Integrate with Git

## What is a Jenkinsfile?

A Jenkinsfile is a text file that defines your entire CI/CD pipeline as code. It's stored in your repository alongside your source code, making the pipeline versioned, reviewable, and reusable.

## Step-by-Step

### 1. Create a Jenkinsfile

Create a file named `Jenkinsfile` in your project root:

```groovy
pipeline {
    agent any
    
    tools {
        maven 'MyMaven'
    }
    
    environment {
        APP_VERSION = '1.0.0'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
            post {
                success {
                    echo 'Build successful!'
                }
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
        
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        failure {
            echo 'Pipeline failed! Check logs.'
        }
        success {
            echo 'Pipeline completed!'
        }
    }
}
```

### 2. Create a Simple Java Project

Create `pom.xml` and Java files (same as Exercise 02) alongside the Jenkinsfile.

### 3. Create a Pipeline Job from SCM

- In Jenkins: New Item → "Pipeline-As-Code-Demo" → "Pipeline" → OK.
- Under Pipeline:
  - Definition: "Pipeline script from SCM"
  - SCM: "None" (for now, or point to your local Git repo)
  - Script Path: "Jenkinsfile"

### 4. Run and Verify

- Click "Build Now".
- The pipeline reads the Jenkinsfile from the workspace.
- All stages execute as defined.

## Practice Tasks

1. Add a `when` condition to skip the deploy stage on feature branches.
2. Use `credentials()` to access a secret API key in your pipeline.
3. Create a multi-branch pipeline that scans all branches in a Git repository.
