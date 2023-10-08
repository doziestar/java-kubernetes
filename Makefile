.PHONY: help deploy undeploy build push

help: ## Display this help
	$ grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

deploy: ## Deploy the application to Kubernetes
	$ kubectl apply -f k8s/deployment.yaml

service: ## Deploy the application service to Kubernetes
	$ kubectl apply -f k8s/service.yaml

undeploy: ## Undeploy the application from Kubernetes
	$ kubectl delete -f k8s/deployment.yaml

build: ## Build the application Docker image e.g. make build IMAGE_NAME=app
	$ docker build -t $(IMAGE_NAME) .

run: ## Run the application Docker image e.g. make run IMAGE_NAME=app PORT=8080
	$ docker run -p 8080:8080 $(IMAGE_NAME)

push: ## Push the application Docker image to Docker Hub e.g. make push IMAGE_NAME=app
	$ docker push $(IMAGE_NAME)

url: ## Get the application URL
	$ minikube service app --url