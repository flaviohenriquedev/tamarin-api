param (
    [string]$moduleName
)

if (-not $moduleName) {
    Write-Host "----> Module name is required! <----"
    exit
}

$moduleCapitalized = $moduleName.Substring(0,1).ToUpper() + $moduleName.Substring(1)
$currentDir = Get-Location
$targetPath = Join-Path -Path $currentDir -ChildPath $moduleName

# Gera o package com base no caminho relativo a src/main/java
$srcPath = "src\main\java\"
$escapedPath = [regex]::Escape($srcPath)
$regex = ".*" + $escapedPath
$relativePath = $currentDir.Path -replace $regex, ""
$basePackage = $relativePath -replace "\\", "."  # transforma em notação de pacote

$folders = @("controller", "service", "repository", "model")

foreach ($folder in $folders) {
    $folderPath = "$targetPath\$folder"
    New-Item -ItemType Directory -Path $folderPath -Force | Out-Null

    $fileName = ""
    $fileContent = @()
    $fullPackage = "package $basePackage.$moduleName.$folder;"

    switch ($folder) {
        "controller" {
            $fileName = "$folderPath\${moduleCapitalized}Controller.java"
            $fileContent = @(
                $fullPackage,
                "",
                "public class ${moduleCapitalized}Controller {",
                "",
                "}"
            )
        }
        "service" {
            $fileName = "$folderPath\${moduleCapitalized}Service.java"
            $fileContent = @(
                $fullPackage,
                "",
                "public class ${moduleCapitalized}Service {",
                "",
                "}"
            )
        }
        "repository" {
            $fileName = "$folderPath\${moduleCapitalized}Repository.java"
            $fileContent = @(
                $fullPackage,
                "",
                "public interface ${moduleCapitalized}Repository {",
                "",
                "}"
            )
        }
        "model" {
            $fileName = "$folderPath\${moduleCapitalized}.java"
            $fileContent = @(
                $fullPackage,
                "",
                "public class ${moduleCapitalized} {",
                "",
                "}"
            )
        }
    }

    $fileContent | Set-Content -Path $fileName -Encoding UTF8
}

Write-Host "-----> Module: '$moduleName' has been created."
