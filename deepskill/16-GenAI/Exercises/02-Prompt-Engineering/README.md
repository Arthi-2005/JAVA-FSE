# Exercise 02 — Prompt Engineering

## Objectives

- Learn how to write effective prompts
- Understand prompt structure and techniques
- Practice with real examples

## What is Prompt Engineering?

Prompt engineering is the practice of crafting inputs to get desired outputs from AI models. A well-written prompt can dramatically improve the quality and relevance of AI responses.

## Prompt Structure

A good prompt often includes:

1. **Role:** Tell the AI who it is (e.g., "You are a Java expert").
2. **Task:** Clearly state what you want.
3. **Context:** Provide relevant background information.
4. **Format:** Specify the output format (e.g., "List as bullet points").
5. **Constraints:** Set limits (e.g., "Explain in 3 sentences").

## Examples

### Bad Prompt
```
Tell me about Java.
```

### Good Prompt
```
You are a Java programming teacher. Explain the difference between 
HashMap and TreeMap to a beginner student. Use simple language and 
provide a code example for each. Keep your answer under 10 sentences.
```

## Prompt Techniques

| Technique | Description | Example |
|-----------|-------------|---------|
| **Be specific** | Provide clear details | "Write a Java method that reverses a string" instead of "Write some Java code" |
| **Few-shot** | Give examples in the prompt | "Positive: I love this! Sentiment: positive. Negative: This is terrible. Sentiment: negative. Neutral: It's okay. Sentiment:" |
| **Chain-of-thought** | Ask for step-by-step reasoning | "Solve this step by step: If a train travels at 60 mph for 2 hours, how far does it go?" |
| **Role prompting** | Assign a persona | "You are a senior software architect reviewing code..." |

## Practice Tasks

1. Write a prompt that asks an AI to explain recursion to a 10-year-old.
2. Write a prompt that asks an AI to write a Java unit test for a Calculator class. Use few-shot prompting by providing one example test.
3. Compare the output of a vague prompt vs a detailed prompt for the same topic.
