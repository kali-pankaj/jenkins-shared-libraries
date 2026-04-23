def call() {
    sh """
        echo "minikube status check"
        minikube status

        echo "minikube delete"
        minikube delete

        echo "minikube start "
        minikube start --cpus=2 --memory=4096

        echo "kubectl node status"
        kubectl get node

        echo "all working fine"

    """
    
}
