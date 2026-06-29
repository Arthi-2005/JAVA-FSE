# Module 6b: SonarQube Code Quality

**Status:** ✅ Successful

## Setup
```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube
```
Access: `http://localhost:9000` (admin/admin)

## Run Analysis
```bash
mvn sonar:sonar -Dsonar.projectKey=myproject
```

## What it checks
- **Code Smells** — maintainability issues
- **Bugs** — runtime errors
- **Vulnerabilities** — security risks
- **Coverage** — test code coverage
- **Duplications** — repeated code blocks
- **Quality Gate** — pass/fail status

## Screenshots
`sonar-output.png` — shows expected analysis results
