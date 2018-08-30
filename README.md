# Description
This project is an implementation of a microservices architecture. It demonstarates how spring boot applications can be deployed on top of kubernetes.
The application uses a two Java 8/Spring Boot microservices, the first returns a list of cars that a user can rent and the second contains the contracts submitted by the user.
The [frontend](https://github.com/ziedYazidi/Dynamic-Form-Generator) uses an Angular app that lists the cars and submits a contract once a car is chosen. 
The backend uses a MySQL database to store the cars and the contracts.


# Prerequisite

* Install [Minikube](https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl)

* Create a Kubernetes cluster with [Minikube](https://kubernetes.io/docs/getting-started-guides/minikube) for local testing.

* Install the command-line tool [Kubectl](https://console.bluemix.net/openwhisk/learn/cli/)to manage and deploy applications on kubernetes.

#Flow

# Steps
1. [Clone the repo](#1-clone-the-repo)
2. [Create the Database service](#2-create-the-database-service)
3. [Create the Spring Boot Microservices](#3-create-the-spring-boot-microservices)
4. [Deploy the Microservices](#5-deploy-the-microservices)
5. [Access Your Application](#6-access-your-application)

### 1. Clone the repo

Clone this repository. In a terminal, run:

```
$ git clone https://github.com/ziedYazidi/microservices-rent-car-example.git
```

### 2. Create the Database service

The backend consists of a MySQL database and the Spring Boot app. Each
microservice has a Deployment and a Service. The deployment manages
the pods started for each microservice. The Service creates a stable
DNS entry for each microservice so they can reference their
dependencies by name.

* To use MySQL in container

```bash
$ kubectl create -f account-database.yaml
service "rent-car-database" created
deployment "rent-car-database" created
```
Default credentials are already encoded in base64 in secrets.yaml.

```
$ kubectl apply -f secrets.yaml
secret "rent-car-credentials" created
```

### 3. Create the Spring Boot Microservices
You will need to have [Maven installed in your environment](https://maven.apache.org/index.html).
If you want to modify the Spring Boot apps, you will need to do it before building the Java project and the docker image.

The Spring Boot Microservices are the **Catalog** and the **Booking**.

**Catalog** is a Spring Boot app configured to use a MySQL database. The configuration is located in `Catalog/src/main/resources/application.properties` in `spring.datasource.*`

The `application.properties` is configured to use MYSQL_DB_* environment variables. These are defined in the `catalog-service.yaml` file. It is already configured to get the values from the Kubernetes Secrets that was created earlier.

Same thing for the **Booking** Microservice, the configuration is located in `Catalog/src/main/resources/application.properties` in `spring.datasource.*` and MYSQL_DB_* environment variables are defined in the `booking-service.yaml` file.

* Build your projects using Maven

After Maven has successfully built the Java project, you will need to build the Docker image using the provided `Dockerfile` in their respective folders.

```bash
Go to containers/Catalog
$ mvn package

Go to containers/Booking
$ mvn package

```

* Build your Docker images for Spring Boot services

*The images [are pushed in Docker hub](https://docs.docker.com/datacenter/dtr/2.2/guides/user/manage-images/pull-and-push-images).*

You can check my dockerhub namespace [here](https://hub.docker.com/u/ziedyazidi/)

```bash
$ docker build -t <YOUR_NAMESPACE>/catalog-service .
$ docker build -t <YOUR_NAMESPACE>/booking-service .
$ docker push <YOUR_NAMESPACE>/catalog-service
$ docker push <YOUR_NAMESPACE>/booking-serivce
```

* Modify *catalog-service.yaml* and *booking-service.yaml* to use your image

Once you have successfully pushed your images, you will need to modify the yaml files to use your images.
```yaml
# catalog-service.yaml
  spec:
    containers:
      - image: <namespace>/catalog-service # replace with your image name
```

```yaml
# booking-service.yaml
  spec:
    containers:
      - image: <namespace>/booking-service # replace with your image name
```



`



### 4. Deploy the Microservices

* Deploy Spring Boot Microservices

```bash
$ kubectl apply -f compute-interest-api.yaml
service "compute-interest-api" created
deployment "compute-interest-api" created
```

```bash
$ kubectl apply -f send-notification.yaml
service "send-notification" created
deployment "send-notification" created
```

* Deploy the Frontend service

The UI is a Node.js app serving static files (HTML, CSS, JavaScript) that shows the total account balance.

```bash
$ kubectl apply -f account-summary.yaml
service "account-summary" created
deployment "account-summary" created
```

* Deploy the Transaction Generator service
The transaction generator is a Python app that generates random transactions with accumulated interest.

Create the transaction generator **Python** app:
```bash
$ kubectl apply -f transaction-generator.yaml
service "transaction-generator" created
deployment "transaction-generator" created
```

<!-- ### 5. Access Your Application
You can access your app publicly through your Cluster IP and the NodePort. The NodePort should be **30080**.

* To find your IP:
```bash
$ ibmcloud cs workers <cluster-name>
ID                                                 Public IP        Private IP      Machine Type   State    Status   
kube-dal10-paac005a5fa6c44786b5dfb3ed8728548f-w1   169.47.241.213   10.177.155.13   free           normal   Ready  
```

* To find the NodePort of the account-summary service:
```bash
$ kubectl get svc
NAME                    CLUSTER-IP     EXTERNAL-IP   PORT(S)                                                                      AGE
...
account-summary         10.10.10.74    <nodes>       80:30080/TCP                                                                 2d
...
```
* On your browser, go to `http://<your-cluster-IP>:30080`
![Account-balance](images/balance.png) -->


## References
* [IBM](https://github.com/IBM/spring-boot-microservices-on-kubernetes).