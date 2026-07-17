# Azure VM Deployment Script
# Prerequisites: Azure CLI installed (https://docs.microsoft.com/cli/azure/install-azure-cli)
# Run: az login first to authenticate

param(
    [string]$ResourceGroupName = "my-first-rg",
    [string]$Location = "eastus",
    [string]$VmName = "my-first-vm",
    [string]$AdminUsername = "azureuser",
    [string]$VmSize = "Standard_B1s"
)

# Login to Azure
Write-Host "Logging in to Azure..." -ForegroundColor Green
az login --only-show-errors

# Create resource group
Write-Host "Creating resource group: $ResourceGroupName in $Location..." -ForegroundColor Green
az group create --name $ResourceGroupName --location $Location --output table

# Create virtual machine
Write-Host "Deploying VM: $VmName..." -ForegroundColor Green
az vm create `
    --resource-group $ResourceGroupName `
    --name $VmName `
    --image Ubuntu2204 `
    --admin-username $AdminUsername `
    --generate-ssh-keys `
    --size $VmSize `
    --output table

# Open port 80 for web traffic
Write-Host "Opening port 80 for HTTP traffic..." -ForegroundColor Green
az vm open-port --port 80 --resource-group $ResourceGroupName --name $VmName

# Get VM information
Write-Host "VM Details:" -ForegroundColor Yellow
az vm show --resource-group $ResourceGroupName --name $VmName --query "{Name:name, ResourceGroup:resourceGroup, Location:location, VmSize:hardwareProfile.vmSize}" --output table

# Get public IP
$publicIp = az vm show --resource-group $ResourceGroupName --name $VmName --show-details --query "publicIps" --output tsv
Write-Host "Connect using: ssh $AdminUsername@$publicIp" -ForegroundColor Cyan

# List all resources in the resource group
Write-Host "All resources in $ResourceGroupName:" -ForegroundColor Green
az resource list --resource-group $ResourceGroupName --output table
