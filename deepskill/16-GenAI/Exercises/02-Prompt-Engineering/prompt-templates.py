# Prompt Engineering Templates

# Code review prompt
def code_review_prompt(code):
    return f"""You are a senior Java developer doing a code review.

Review this code for bugs, security issues, performance, and style:

```java
{code}
"""

# Test generation prompt
def test_generation_prompt(code):
    return f"""Write JUnit tests for this Java code.
Include happy path, edge cases, and error scenarios:

```java
{code}
"""

# Simple explanation prompt
def explain_prompt(topic):
    return f"""Explain "{topic}" like I'm 10 years old.
Use simple words and an analogy. Keep it short.
"""

# Debug help prompt
def debug_help_prompt(error, code):
    return f"""I get this error: {error}
In this code: {code}
Explain the cause and show the fix.
"""

java_code = """
public int divide(int a, int b) {
    return a / b;
}
"""

print("=== Code Review Prompt ===")
print(code_review_prompt(java_code))
