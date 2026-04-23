def call() {
    echo "hello pankaj how are you i am testing mimkkube how to run "

    minikube delete
    minikube start --cpus=2 --memory=4096
    echo "minekube start successful..."
    
}
