package com.skyl.kafka.spring;

import lombok.Data;

public class KafkaProperties {

    private String bootstrapServers;
    private String acksConfig;
    private String partitionerClass;

}
