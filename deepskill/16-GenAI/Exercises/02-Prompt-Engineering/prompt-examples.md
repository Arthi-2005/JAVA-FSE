# Prompt Engineering — Examples

## Bad vs Good Prompts

### ❌ Bad Prompt
```
Tell me about Java.
```

### ✅ Good Prompt
```
You are a Java programming teacher. Explain the difference between 
HashMap and TreeMap to a beginner student. Use simple language and 
provide a code example for each. Keep your answer under 10 sentences.
```

---

## Prompt Techniques

### 1. Role Prompting
```
You are a senior software architect reviewing a pull request. 
Review the following code for security issues, performance problems, 
and code style violations. Be specific and suggest fixes.
```

### 2. Few-Shot Prompting
```
Classify the sentiment of each review:

Review: "This product is amazing!" -> Positive
Review: "The delivery was late and the item was damaged." -> Negative
Review: "It works as expected, nothing special." -> Neutral
Review: "I love the design but the battery life is poor." ->
```

### 3. Chain-of-Thought
```
Solve this step by step:
A train leaves Station A at 60 mph. Another train leaves Station B 
(at the opposite end, 200 miles away) at 40 mph heading toward 
Station A. When will they meet?
```

### 4. Constrained Output
```
You are a helpful assistant. List 3 ways to optimize a Java Spring 
Boot application. Format each as a bullet point with:
- Title (bold)
- 1 sentence description
- Code snippet (optional)
```

## Practice Exercise

Given a vague prompt, rewrite it to be specific:

**Original:** "Write code for a login page"

**Improved:** ___________________________________
