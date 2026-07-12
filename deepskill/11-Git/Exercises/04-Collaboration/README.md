# Exercise 04 — Collaboration with Remote Repositories

## Objectives

- Link a local repository to GitHub
- Push commits to a remote
- Pull changes from a remote
- Create a .gitignore file

## Step-by-Step

### 1. Create a GitHub Repository

- Go to https://github.com and sign in.
- Click the "+" icon → "New repository".
- Name: `my-collab-project`
- Do NOT initialize with README (we have a local repo).
- Click "Create repository".

### 2. Connect Local to Remote

```bash
mkdir collab-demo
cd collab-demo
git init
echo "# My Collaboration Project" > README.md
git add . && git commit -m "Initial commit"
```

```bash
git remote add origin https://github.com/YOUR_USERNAME/my-collab-project.git
git branch -M main
git push -u origin main
```

### 3. Create a .gitignore

Create `.gitignore`:

```
# Compiled files
*.class
*.jar

# IDE files
.idea/
*.iml
.vscode/

# OS files
.DS_Store
Thumbs.db

# Build output
target/
build/
dist/

# Logs
*.log
```

```bash
git add .gitignore
git commit -m "Add .gitignore"
git push
```

### 4. Pull Changes from Remote

If a teammate pushed changes, pull them:

```bash
git pull origin main
```

### 5. Create a Pull Request (GitHub Flow)

1. Create a feature branch: `git checkout -b feature/new-feature`
2. Make changes and push: `git push -u origin feature/new-feature`
3. On GitHub, click "Compare & pull request".
4. Add a description and click "Create pull request".
5. Merge the PR on GitHub.
6. Pull the merged changes locally: `git pull origin main`

## Collaboration Workflow

```
1. git checkout -b feature/xyz
2. Make changes, commit
3. git push -u origin feature/xyz
4. Create PR on GitHub
5. Team reviews and merges PR
6. git checkout main && git pull origin main
```

## Commands Summary

| Command | Description |
|---------|-------------|
| `git remote add origin <url>` | Add a remote repository |
| `git push -u origin main` | Push and set upstream |
| `git pull origin main` | Pull latest changes |
| `git clone <url>` | Clone a remote repository |
| `git fetch origin` | Fetch changes without merging |

## Practice Tasks

1. Clone an existing open-source repository and explore its commit history.
2. Create a repository on GitHub with a README and clone it locally.
3. Fork a repository, make changes, and create a pull request.
