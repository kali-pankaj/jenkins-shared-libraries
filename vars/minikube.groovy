def call() {
    sh """
        echo "Checking Minikube status..."

        minikube status 

        echo "minikube start "
        minikube start --cpus=2 --memory=4096

        // kubectl apply -f kubernetes/my-webapp/

        // kubectl get pods -o wide
        minikube status 
        echo "minikube starte successful..."
    """
}
