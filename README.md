# java-kubernetes

A concise Spring Boot CRUD API to manage restaurants

This application provides endpoints to create, read, update, and delete restaurant information. It's designed to be containerized with Docker and deployed to Kubernetes.

### Table of Contents
1. [Requirements](#requirements)
2. [Getting Started](#getting-started)
3. [Dockerization](#dockerization)
4. [Kubernetes Deployment](#kubernetes-deployment)
5. [Contributing](#contributing)
6. [License](#license)

### Requirements

1. Java 11+
2. Maven 3.6+
3. Spring Boot 2.4+
4. Docker 19+
5. Kubernetes 1.18+
6. (Optional) kubectl CLI for Kubernetes interaction

### Getting Started

#### Setting up the Project:

1. Clone the repository:
```bash
$ git clone https://github.com/doziestar/java-kubernetes.git
$ cd java-kubernetes

```

2. Build the project with Maven:
```bash
$ mvn clean install
```

3. Run the application:
```bash
$ mvn spring-boot:run
```

You can now access: 
- H2 console at http://localhost:8080/h2-console and the 
- API at http://localhost:8080/api/restaurants

## Endpoints

| Method | Endpoint               | Description            |
|----|------------------------|------------------------|
| POST | `/api/restaurants`     | Create a new restaurant. |
| GET | `/api/restaurants/{id}` | Retrieve a restaurant by its ID. |
| UPDATE |   `/api/resturants/{id}` | Update a returant      |
| DELETE | `/api/resturants/{id}` | Delete a restaurant     |



## Dockerization

### Building a Docker Image:
1. Make sure you have Docker installed and running.
2. Build the Docker image from the project root:
```bash
$ docker build -t java-kubernetes .
```

### Running the Docker Image:
Run the Docker image:
```bash
$ docker run -p 8080:8080 java-kubernetes
```

## Kubernetes Deployment

### Deploying to Kubernetes:
1. Ensure you have a running Kubernetes cluster and kubectl installed.
2. Deploy the application:
```bash
$ kubectl apply -f kubernetes/deployment.yaml
```
3. Expose the application:
```bash
$ kubectl apply -f kubernetes/service.yaml
```

### Accessing the Application:
1. Get the URL of the application:
```bash
$ minikube service java-kubernetes --url
```
2. Access the application at the URL.
3. Access the H2 console at http://localhost:8080/h2-console.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the LICENSE file for details.