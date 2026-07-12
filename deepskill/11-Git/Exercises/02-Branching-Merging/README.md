# Exercise 02 — Branching & Merging

## Objectives

- Create and switch between branches
- Merge feature branches into main
- Understand fast-forward vs three-way merges

## Step-by-Step

### 1. Create a Repository (if not already done)

```bash
mkdir branching-demo
cd branching-demo
git init
echo "Main branch content" > main.txt
git add . && git commit -m "Initial commit on main"
```

### 2. Create a Feature Branch

```bash
git checkout -b feature/login
```

### 3. Work on the Feature Branch

Create `login.html`:

```html
<h1>Login Page</h1>
<form>
  <input type="text" placeholder="Username">
  <input type="password" placeholder="Password">
  <button>Login</button>
</form>
```

Stage and commit:

```bash
git add login.html
git commit -m "Add login page"
```

### 4. Switch Back to Main

```bash
git checkout main
```

Notice `login.html` is not here — each branch has independent files.

### 5. Merge the Feature Branch

```bash
git merge feature/login
```

This is a **fast-forward merge** since main hasn't changed.

### 6. Create Conflicting Changes

```bash
git checkout -b feature/about
echo "About page" > about.txt
git add . && git commit -m "Add about page"

git checkout main
echo "Main update" >> main.txt
git add . && git commit -m "Update main.txt on main"
```

### 7. Merge with a Three-Way Merge

```bash
git merge feature/about
```

Since both branches have diverged, Git creates a **merge commit**.

## Branching Strategy

```
main:     A --- B --- C --- D (merge commit)
              \         /
feature:       E --- F
```

## Commands Summary

| Command | Description |
|---------|-------------|
| `git branch` | List branches |
| `git branch <name>` | Create a branch |
| `git checkout -b <name>` | Create and switch to a branch |
| `git checkout <name>` | Switch to a branch |
| `git merge <branch>` | Merge a branch into the current branch |
| `git branch -d <name>` | Delete a merged branch |

## Practice Tasks

1. Create branches for three features: `feature/navbar`, `feature/footer`, `feature/homepage`.
2. Commit changes on each branch without merging.
3. Merge them one by one into main and observe the log with `--graph`.
