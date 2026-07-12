# Exercise 01 — Git Setup & Basics

## Objectives

- Install and configure Git
- Initialize a repository
- Stage and commit changes
- View commit history

## Step-by-Step

### 1. Install Git

Download from https://git-scm.com/downloads and run the installer.

### 2. Configure Git Identity

```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

### 3. Initialize a Repository

```bash
mkdir my-first-repo
cd my-first-repo
git init
```

### 4. Create and Track Files

Create a file called `hello.txt`:

```
Hello, Git!
This is my first commit.
```

Stage and commit:

```bash
git add hello.txt
git commit -m "Initial commit: add hello.txt"
```

### 5. Make More Changes

Append to `hello.txt`:

```
Adding a new line.
```

Check status and commit:

```bash
git status
git diff
git add .
git commit -m "Add a new line to hello.txt"
```

### 6. View History

```bash
git log --oneline
```

## Commands Summary

| Command | Description |
|---------|-------------|
| `git init` | Initialize a new repository |
| `git add <file>` | Stage a file |
| `git add .` | Stage all changes |
| `git commit -m "msg"` | Commit staged changes |
| `git status` | Show working tree status |
| `git diff` | Show unstaged changes |
| `git log --oneline` | Show commit history (one line per commit) |

## Practice Tasks

1. Create a new file `README.md` with a project description and commit it.
2. Make three separate commits, each adding a new file.
3. Use `git log` with different options (`--oneline`, `--graph`, `--all`).
