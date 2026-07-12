# Exercise 03 — Conflict Resolution

## Objectives

- Create a merge conflict intentionally
- Resolve the conflict manually
- Complete the merge after resolution

## Step-by-Step

### 1. Set Up the Scenario

```bash
mkdir conflict-demo
cd conflict-demo
git init
```

Create `team.txt`:

```
Team Members:
- Alice
```

Commit:

```bash
git add team.txt && git commit -m "Initial team list"
```

### 2. Create Two Branches That Modify the Same Lines

```bash
git checkout -b branch-alice
```

Edit `team.txt`:

```
Team Members:
- Alice
- Charlie (added by Alice)
```

```bash
git add . && git commit -m "Alice adds Charlie"
```

Switch back to main and create another branch:

```bash
git checkout main
git checkout -b branch-bob
```

Edit `team.txt` (same location, different content):

```
Team Members:
- Alice
- Charlie (added by Bob)
```

```bash
git add . && git commit -m "Bob adds Charlie"
```

### 3. Attempt to Merge

```bash
git checkout main
git merge branch-alice   # This works (fast-forward)
git merge branch-bob     # CONFLICT!
```

### 4. Resolve the Conflict

Open `team.txt` — you'll see:

```
Team Members:
- Alice
<<<<<<< HEAD
- Charlie (added by Alice)
=======
- Charlie (added by Bob)
>>>>>>> branch-bob
```

Edit the file to resolve:

```
Team Members:
- Alice
- Charlie
```

### 5. Complete the Merge

```bash
git add team.txt
git commit -m "Resolve merge conflict in team.txt"
```

## Conflict Markers

| Marker | Meaning |
|--------|---------|
| `<<<<<<< HEAD` | Start of your current branch's changes |
| `=======` | Separator between conflicting changes |
| `>>>>>>> branch-name` | End of the incoming branch's changes |

## Merge Tools

For complex conflicts, use a merge tool:

```bash
git mergetool
```

Popular tools: VS Code, IntelliJ, Beyond Compare, KDiff3.

## Practice Tasks

1. Create a conflict in a Java file where two branches add different methods to the same class.
2. Resolve by keeping both methods.
3. Create a conflict where the same variable has different values and resolve by choosing one.
