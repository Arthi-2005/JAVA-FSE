# Exercise 02 — IaaS vs PaaS vs SaaS

## Objectives

- Understand the three main cloud service models
- Know what each model provides
- Identify real-world examples of each

## Cloud Service Models

### IaaS — Infrastructure as a Service
Provides virtualized computing resources over the internet.

- **You manage:** Applications, data, runtime, middleware, OS
- **Provider manages:** Virtualization, servers, storage, networking
- **Examples:** Azure VMs, AWS EC2, Google Compute Engine
- **Use case:** Moving a legacy application to the cloud without rewriting

### PaaS — Platform as a Service
Provides a platform to develop, run, and manage applications.

- **You manage:** Applications and data
- **Provider manages:** Runtime, middleware, OS, virtualization, servers, storage, networking
- **Examples:** Azure App Services, Google App Engine, Heroku
- **Use case:** Developing a web app without managing the underlying infrastructure

### SaaS — Software as a Service
Provides ready-to-use software over the internet.

- **You manage:** Nothing — just use the application
- **Provider manages:** Everything
- **Examples:** Gmail, Microsoft 365, Salesforce, Slack
- **Use case:** Email, collaboration tools, CRM

## Comparison

```
┌────────────────────────────────────────────┐
│            Traditional (On-Prem)           │
│  Apps │ Data │ Runtime │ Middleware │ OS   │
│  Virtualization │ Servers │ Storage │ Net  │
├────────────────────────────────────────────┤
│                   IaaS                     │
│  Apps │ Data │ Runtime │ Middleware │ OS   │
│  ─── Provider manages below this line ─── │
├────────────────────────────────────────────┤
│                   PaaS                     │
│  Apps │ Data │                             │
│  ─── Provider manages below this line ─── │
├────────────────────────────────────────────┤
│                   SaaS                     │
│  ─── Provider manages everything ──── │
└────────────────────────────────────────────┘
```

## Practice Tasks

1. Categorize these services as IaaS, PaaS, or SaaS: Microsoft 365, Azure SQL Database, Netflix, AWS Lambda, Google Drive.
2. If you're building a new web app as a startup, which model would you choose and why?
3. Explain the "NoOps" concept — does SaaS eliminate the need for IT operations?
