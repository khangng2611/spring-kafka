# Reactive Project Demo Using Spring Boot  & Kafka
This is a sample Spring Boot project that demonstrates the integration of Kafka with a Spring Reactive application. To showcase the functionality of the application, I have developed two distinct projects:

**Producer**:
- Using the Spring Boot Reactive framework to extract a data stream from [Wikimedia Recent Changes](https://stream.wikimedia.org/v2/stream/recentchange).
- Transmitting the messages to a Kafka broker.

**Consumer**:
- Retrieving messages from the Kafka topic.