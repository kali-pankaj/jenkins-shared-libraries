def call() {
    sh """
    echo "========== MINIKUBE SETUP =========="

    echo "Checking existing cluster..."
    minikube status || true

    echo "Deleting old cluster (if any)..."
    minikube delete || true

    echo "Starting Minikube..."
    minikube start --driver=${driver} --cpus=${cpus} --memory=${memory}

    echo "Checking cluster status..."
    kubectl get nodes

    echo "Minikube setup completed ✅"
    """
}
