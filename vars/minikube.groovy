def call () {
    #!/bin/bash
echo "============================================"
echo "Minikube Run and Coustom Image Deployment"
echo "============================================"

# set script write or not 
set -e

if ! command -v minikube &> /dev/null 
then
    echo "Minikube is Installing..."
    curl -LO https://github.com/kubernetes/minikube/releases/latest/download/minikube-linux-amd64
    sudo install minikube-linux-amd64 /usr/local/bin/minikube 
    rm minikube-linux-amd64
    echo "Minikube Install Successful..."
else
    echo "Minikube already Install"
fi

# Check minikube version 
minikube version

echo "============================================="
echo "Minikube service status "
echo "============================================="

if minikube status | grep -q "Running"; then
    echo "Minikube are running "
else
    minikube start --cpus=2 --memory=4096
    echo "Minkkube Start and Running Know..."
fi

echo "Cluster information Check"
kubectl get nodes

echo "Deploy Application..."
kubectl apply -f deployment.yaml

echo "Waiting for pods to be ready..."
sleep 10

echo "pods are Information check "
kubectl get pods

echo "Click url your application live or not"
minikube service my-webapp --url

echo "all process complete successful..."


}
