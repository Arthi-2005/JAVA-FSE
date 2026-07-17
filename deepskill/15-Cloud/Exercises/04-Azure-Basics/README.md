# Exercise 04 — Azure Basics

## Objectives

- Navigate the Azure Portal
- Create a resource group
- Deploy a virtual machine

## What is Azure?

Microsoft Azure is a cloud computing platform offering over 200 services including virtual machines, databases, AI, and networking. It has data centers in 60+ regions worldwide.

## Step-by-Step

### 1. Create an Azure Free Account

- Go to https://azure.microsoft.com/free
- Sign up with your Microsoft account.
- You get $200 free credit for 30 days and 12 months of popular services free.

### 2. Explore the Azure Portal

- Go to https://portal.azure.com
- The dashboard shows your resources, recent activity, and shortcuts.
- Use the search bar at the top to find services.

### 3. Create a Resource Group

- Search for "Resource groups" → Click "Create".
- Subscription: Select your subscription.
- Resource group name: `my-first-rg`
- Region: Select the nearest one (e.g., "East US").
- Click "Review + create" → "Create".

### 4. Create a Virtual Machine

- Search for "Virtual machines" → Click "Create" → "Azure virtual machine".
- Resource group: `my-first-rg`
- VM name: `my-first-vm`
- Region: Same as resource group
- Image: `Windows Server 2022 Datacenter` (or `Ubuntu Server 22.04 LTS`)
- Size: `Standard_B1s` (free tier eligible)
- Administrator account: Create username and password.
- Inbound ports: Allow RDP (3389) for Windows or SSH (22) for Linux.
- Click "Review + create" → "Create".

### 5. Connect to Your VM

- After deployment, go to "Virtual machines" → click your VM.
- Copy the "Public IP address".
- **Windows:** Open Remote Desktop Connection → paste IP → login with your credentials.
- **Linux:** Open terminal → `ssh username@<public-ip>`

### 6. Clean Up

- When done, delete the resource group to avoid charges:
  - Search "Resource groups" → click `my-first-rg` → "Delete resource group".

## Azure Portal Tips

| Action | How |
|--------|-----|
| Find services | Use the top search bar |
| Pin to dashboard | Click the pin icon on any resource |
| View costs | Search "Cost Management" |
| Cloud Shell | Click the `>_` icon in the top bar |

## Practice Tasks

1. Create a storage account in your resource group.
2. Upload a file to blob storage.
3. Use Azure Cloud Shell (PowerShell or Bash) to list all your resources: `az resource list`
