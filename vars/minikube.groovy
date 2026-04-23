#!/bin/bash
set -e 
echo "minikube stop and delete"
minikube delete

echo "minikube start"
minikube start --cpus=2 --memory=4096
