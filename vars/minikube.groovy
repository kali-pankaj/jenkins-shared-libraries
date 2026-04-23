def call(Map config = [:]) {

    def cpus   = config.get('cpus', 2)
    def memory = config.get('memory', 4096)
    def driver = config.get('driver', 'docker')

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
