package com.skyl.kafka.spring;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

//@Configuration
public class KafkaConf {

    //@Autowired
    private KafkaProperties kafkaProperties;

    //@Bean
    //利用spring容器特性创建一个单例模式的producer
    /*
            1、Kafka Producer是线程安全的，建议多线程复用，如果每个线程都创建，出现大量的上下文切换或争抢的情况，影响Kafka效率
            2、Kafka Producer的key是一个很重要的内容：
                2.1 我们可以根据Key完成Partition的负载均衡
                2.2 合理的Key设计，可以让Flink、Spark Streaming之类的实时分析工具做更快速处理

            3、ack - all， kafka层面上就已经有了只有一次的消息投递保障，但是如果想真的完全不丢数据，最好自行处理异常
         */
    public Producer kafkaProducer(){
        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        properties.put(ProducerConfig.ACKS_CONFIG, kafkaProperties.getAcksConfig());
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.imooc.skyl.kafka.producer.SamplePartition");

        // Producer的主对象
        Producer<String,String> producer = new KafkaProducer<>(properties);

        return producer;
    }

}
