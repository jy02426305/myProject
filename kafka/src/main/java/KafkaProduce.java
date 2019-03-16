import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaProduce {
    /**
     * 日志
     */

    private static final String SEND_MESSAGE_FAILED_NUM = "12000002";
    private static final String SEND_MESSAGE_FAILED_MESSAGE = " send message to kafka error :";

    /**
     * 发送消息
     *
     * @param topic
     * @param key
     * @param value
     */
    public static void sendMsg(String topic, String key, String value) {

        Properties properties = ReadKafkaPropertiesUtil.getProperties();
        // 实例化produce
        KafkaProducer<String, String> kp = new KafkaProducer<String, String>(properties);

        // 消息封装
        ProducerRecord<String, String> pr = new ProducerRecord<String, String>(topic, key, value);

        // 发送数据
        kp.send(pr, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (null != e) {
                        e.printStackTrace();
                    }else {
                        System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
                    }
            }
        });
        // 关闭produce
        kp.close();
    }
}
