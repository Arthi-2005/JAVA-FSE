# Exercise 03 — LLMs in Practice

## Objectives

- Use an LLM to generate and explain code
- Understand token limits and API usage
- Interact with OpenAI API (optional)

## Step-by-Step

### 1. Using ChatGPT for Code Help

Go to https://chat.openai.com and try these prompts:

```
Write a Java program that reads a CSV file and prints 
the average of the numbers in the second column.
```

```
Explain this code line by line:

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### 2. Understanding Tokens

Tokens are how LLMs measure text. In English:
- 1 token ≈ 0.75 words
- "Hello, world!" = 3 tokens: ["Hello", ",", " world!"]

**Context window limits:**
- GPT-3.5: 4,096 tokens (~3,000 words)
- GPT-4: 8,192 tokens (~6,000 words)
- GPT-4 Turbo: 128,000 tokens (~96,000 words)

### 3. Using OpenAI API (Optional)

If you have an OpenAI API key:

```python
import openai

openai.api_key = "your-api-key"

response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=[
        {"role": "system", "content": "You are a helpful Java tutor."},
        {"role": "user", "content": "Explain what a Spring Bean is."}
    ]
)

print(response.choices[0].message.content)
```

### 4. Code Generation Best Practices

- **Always review AI-generated code** — it may contain bugs or security issues.
- **Provide context** — tell the AI about your tech stack.
- **Iterate** — refine the prompt if the output isn't what you expected.
- **Test the code** — don't assume it works without testing.

## Practice Tasks

1. Ask ChatGPT to write a Java REST controller with a GET endpoint.
2. Ask it to explain the difference between `@Component` and `@Service` in Spring.
3. Try to exceed the token limit by pasting a very long document and asking questions about it.
