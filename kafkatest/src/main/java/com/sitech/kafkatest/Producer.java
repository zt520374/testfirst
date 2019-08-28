package com.sitech.kafkatest;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 *
 */
public class Producer {

//    static Logger log = Logger.getLogger(Producer.class);


    private static final String TOPIC = "milo2";
    private static final String BROKER_LIST = "172.18.231.9:32129";
    private static KafkaProducer<String,String> producer = null;


    /*
    初始化生产者
     */
    static {
        Properties configs = initConfig();
        producer = new KafkaProducer<String, String>(configs);
    }

    /*
初始化配置
 */
    private static Properties initConfig(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BROKER_LIST);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        return properties;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(initConfig());
        //消息实体
        ProducerRecord<String , String> record = null;
        for (int i = 0; i < 100; i++) {
            record = new ProducerRecord<String, String>(TOPIC, "value"+(int)(10*(Math.random())));
            //发送消息
//            producer.send(record, new Callback() {
//                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
//                    if (null != e){
//                        log.info("send error" + e.getMessage());
//                    }else {
//                        System.out.println(String.format("offset:%s,partition:%s",recordMetadata.offset(),recordMetadata.partition()));
//                    }
//                }
//            });
            System.out.println("seng+" + i );
            producer.send(record);
        }
        producer.close();
    }





}
