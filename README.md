# Kafka for Asynchronous Communication

## Problem Statement

Implement the Kafka for Asynchronous Communication between the User Service and Notification Service. The User Service will publish a message to the Kafka topic `NotifyUser` whenever a user logs in. The Notification Service will listen to the Kafka topic `NotifyUser` and sends an email notification to the user.

## Requirements
#### User Service - Publisher
1. Add the `org.springframework.kafka` dependency in the pom.xml file inorder to send the messages to the Kafka topic.
2. Implement a logIn API that will create a sample User and returns a login successful message.
3. This API should also publish a message(UserDto object) to the Kafka topic `NotifyUser` in the JSON string format to notify the user about the login using Kafka Queue.

#### Notification Service - Subscriber
1. Add the `org.springframework.kafka` dependency in the pom.xml file inorder to receive the messages from the Kafka topic.
2. Create a KafkaListener method that will listen to the Kafka topic `NotifyUser` and sends an email notification to the user using the details from the UserDto object passed in the message.
3. Refer the below link to send an email : [Send Email in Java SMTP with TLS Authentication](https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp#send-email-in-java-smtp-with-tls-authentication)
4. Since using Gmail SMTP server to send an email, you need to use App Password to authenticate the email. To generate App Password : [Generate App Passwords](https://myaccount.google.com/apppasswords) (You need to enable 2-Step Verification to generate App Passwords in Gmail)

#### Kafka
1. Refer the documentation to download Kafka in your local system : [How to install Kafka with Zookeeper on Mac](https://www.conduktor.io/kafka/how-to-install-apache-kafka-on-mac/)
2. Start the Zookeeper server by running the command in the terminal : `~/Downloads/kafka_2.12-3.7.0/bin/zookeeper-server-start.sh ~/Downloads/kafka_2.12-3.7.0/config/zookeeper.properties`
3. Start the Kafka server by running the command in the terminal : `~/Downloads/kafka_2.12-3.7.0/bin/kafka-server-start.sh ~/Downloads/kafka_2.12-3.7.0/config/server.properties`
