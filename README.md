# prit-kafka-consumer
Steps to follow : 

Download Kafka
http://kafka.apache.org/downloads.html

When you click it will take you to the below link :
https://www.apache.org/dyn/closer.cgi?path=/kafka/2.1.0/kafka_2.12-2.1.0.tgz

http://mirrors.estointernet.in/apache/kafka/2.1.0/kafka_2.12-2.1.0.tgz

Installation steps

Extract downloaded to 	
	C:\kafka\kafka_2.12-2.1.0
Open Git Bash	
Setup JAVA_HOME	
	export JAVA_HOME="C:\Program Files (x86)\Java\jdk1.8.0_151"


How to Run application : 

STEP 1 : 

cd kafka_2.12-2.1.0
export JAVA_HOME="C:\Program Files (x86)\Java\jdk1.8.0_151"

	START Zookeeper
		bin/windows/zookeeper-server-start.bat config/zookeeper.properties
	STOP   Zookeeper
		bin/windows/zookeeper-server-stop.bat config/zookeeper.properties
STEP 2 : 
	START kafka-server
		bin/windows/kafka-server-start.bat config/server.properties
	STOP   kafka-server
		bin/windows/kafka-server-stop.bat config/server.properties
STEP 3 : Requires only one time at the start
	Command to Create Kafka TOPIC
		bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic KafkaExampleTopic
		bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic KafkaExampleTopicJson
STEP 4 : 
	Start consumer from bash CLI
		bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic KafkaExampleTopic --from-beginning
		bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic KafkaExampleTopicJson --from-beginning
STEP 5 :
	Test by publishing string message 
	Start the spring-boot application and publish the below :
	http://localhost:8080/kafka/publish/Hello