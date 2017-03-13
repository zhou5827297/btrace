package com.zhoukai.kafka;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class LogProducer {

    private Producer<String, String> inner;

    public LogProducer() throws Exception {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("producer.properties"));
        ProducerConfig config = new ProducerConfig(properties);
        inner = new Producer<String, String>(config);
    }


    public void send(String topicName, String message) {
        if (topicName == null || message == null) {
            return;
        }
        KeyedMessage<String, String> km = new KeyedMessage<String, String>(topicName, message);
        inner.send(km);
    }

    public void send(String topicName, Collection<String> messages) {
        if (topicName == null || messages == null) {
            return;
        }
        if (messages.isEmpty()) {
            return;
        }
        List<KeyedMessage<String, String>> kms = new ArrayList<KeyedMessage<String, String>>();
        for (String entry : messages) {
            KeyedMessage<String, String> km = new KeyedMessage<String, String>(topicName, entry);
            kms.add(km);
        }
        inner.send(kms);
    }

    public void close() {
        inner.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LogProducer producer = null;
        try {
            producer = new LogProducer();
            int i = 0;
            while (true) {
                String msg = "this is a sample" + i;
                producer.send("test-topic", msg);
                System.out.println("send msg :" + msg);
                i++;
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (producer != null) {
                producer.close();
            }
        }

    }

}