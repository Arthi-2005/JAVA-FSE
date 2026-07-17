# Cloud Service Models — IaaS vs PaaS vs SaaS

## Comparison Table

| Aspect | IaaS | PaaS | SaaS |
|--------|------|------|------|
| **You manage** | Apps, data, runtime, middleware, OS | Apps and data | Nothing |
| **Provider manages** | Virtualization, servers, storage, networking | Runtime, middleware, OS, infra | Everything |
| **Control** | High | Medium | Low |
| **Flexibility** | High | Medium | Low |
| **Time to deploy** | Hours-days | Minutes-hours | Immediate |
| **Examples** | Azure VMs, AWS EC2 | Azure App Services, Heroku | Gmail, Office 365 |

## Classification Exercise

| Service | Category | Reason |
|---------|----------|--------|
| Microsoft 365 | SaaS | Ready-to-use software, nothing to manage |
| Azure SQL Database | PaaS | Managed database platform, no server management |
| Netflix | SaaS | Streaming service, pay-per-use |
| AWS Lambda | PaaS/FaaS | Deploy code only, no infrastructure |
| Google Drive | SaaS | Cloud storage, ready-to-use |
| Azure Virtual Machine | IaaS | Full OS control, manage everything above OS |
| GitHub Actions | PaaS | CI/CD platform, no runner management |
| Salesforce | SaaS | CRM software, fully managed |

## Decision Guide

```
Your priority? 
├── Full control over infrastructure → IaaS
├── Focus on code, skip infra management → PaaS
└── Just use the software, no ops → SaaS
```
