package com.datalake.datalake_subscriber_java.processors;

public interface TopicProcessor {
    void process(String message);
}
