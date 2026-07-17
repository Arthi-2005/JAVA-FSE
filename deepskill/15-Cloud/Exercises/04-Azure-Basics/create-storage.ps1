# Azure Storage Account Setup Script

param(
    [string]$ResourceGroupName = "my-first-rg",
    [string]$Location = "eastus",
    [string]$StorageAccountName = "mydemostorage$((Get-Random -Minimum 1000 -Maximum 9999))",
    [string]$ContainerName = "myfiles"
)

Write-Host "Creating storage account: $StorageAccountName..." -ForegroundColor Green
az storage account create `
    --name $StorageAccountName `
    --resource-group $ResourceGroupName `
    --location $Location `
    --sku Standard_LRS `
    --kind StorageV2 `
    --output table

$connString = az storage account show-connection-string `
    --name $StorageAccountName `
    --resource-group $ResourceGroupName `
    --output tsv

Write-Host "Creating blob container: $ContainerName..." -ForegroundColor Green
az storage container create `
    --name $ContainerName `
    --connection-string $connString `
    --output table

# Create a sample file and upload it
"Hello from Azure Blob Storage! Uploaded at $(Get-Date)" | Out-File -FilePath "sample.txt" -Encoding utf8

Write-Host "Uploading sample.txt to blob container..." -ForegroundColor Green
az storage blob upload `
    --container-name $ContainerName `
    --file "sample.txt" `
    --name "sample.txt" `
    --connection-string $connString `
    --output table

Write-Host "Listing blobs in container:" -ForegroundColor Yellow
az storage blob list `
    --container-name $ContainerName `
    --connection-string $connString `
    --output table

Write-Host "Storage account: $StorageAccountName" -ForegroundColor Cyan
Write-Host "Container: $ContainerName" -ForegroundColor Cyan
