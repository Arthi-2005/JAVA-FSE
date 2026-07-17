# Exercise 03 — Cloud Deployment Models

## Objectives

- Understand public, private, hybrid, and multi-cloud deployment models
- Know when to use each model
- Learn about cloud migration strategies

## Deployment Models

### Public Cloud
Resources are owned and operated by a third-party provider and shared over the internet.

- **Pros:** Low cost, no maintenance, highly scalable
- **Cons:** Less control, shared infrastructure
- **Example:** Running a web app on Azure App Services

### Private Cloud
Resources are used exclusively by one organization, either on-premise or hosted by a third party.

- **Pros:** Full control, high security, compliance-friendly
- **Cons:** Higher cost, requires maintenance
- **Example:** A bank running its core systems on a private cloud

### Hybrid Cloud
Combines public and private clouds, allowing data and applications to be shared between them.

- **Pros:** Flexibility, security for sensitive data, cost optimization
- **Cons:** Complexity, integration challenges
- **Example:** An e-commerce site using private cloud for customer data and public cloud for traffic spikes

### Multi-Cloud
Using multiple public cloud providers (e.g., Azure + AWS) simultaneously.

- **Pros:** Avoid vendor lock-in, best-of-breed services
- **Cons:** Management complexity, data transfer costs
- **Example:** Using Azure for AI services and AWS for storage

## Cloud Migration Strategies (The 6 R's)

| Strategy | Description |
|----------|-------------|
| Rehost | Lift and shift — move as-is to the cloud |
| Replatform | Make minor optimizations during migration |
| Refactor | Re-architect the application for cloud-native |
| Repurchase | Switch to a SaaS alternative |
| Retire | Decommission unused applications |
| Retain | Keep on-premise (do nothing) |

## Practice Tasks

1. A hospital wants to store patient records. Which deployment model would you recommend and why?
2. Explain the difference between "hybrid cloud" and "multi-cloud" in your own words.
3. A company has a legacy on-premise app. Which migration strategy is fastest? Which gives the most long-term benefits?
