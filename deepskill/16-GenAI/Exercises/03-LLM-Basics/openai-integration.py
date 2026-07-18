# OpenAI API Integration Example
# pip install openai

import os
from openai import OpenAI

client = OpenAI()

# Chat with GPT
def chat_with_gpt(system_prompt, user_message):
    try:
        response = client.chat.completions.create(
            model="gpt-3.5-turbo",
            messages=[
                {"role": "system", "content": system_prompt},
                {"role": "user", "content": user_message}
            ]
        )
        return response.choices[0].message.content
    except Exception as e:
        return f"Error: {e}"

# Generate code using AI
def generate_code(prompt):
    system = "You are a Java expert. Write clean code."
    return chat_with_gpt(system, prompt)

# Ask AI to explain code
def explain_code(code_snippet):
    system = "You are a programming tutor. Explain code in simple terms."
    return chat_with_gpt(system, "Explain this code:\n" + code_snippet)

print("=== Code Generation ===")
code = generate_code("Write a Java method to read a CSV file and calculate average")
print(code)

print("\n=== Code Explanation ===")
sample = """
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
"""
explanation = explain_code(sample)
print(explanation)
