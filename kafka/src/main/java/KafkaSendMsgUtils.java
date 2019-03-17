import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

public class KafkaSendMsgUtils {
    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring.xml");

    public static <K,T>void sendMessage(String topic, Integer partition, Long timestamp,  K key, T data) {
        KafkaTemplate<K, T> kafkaTemplate = (KafkaTemplate<K, T>) CONTEXT.getBean("kafkaTemplate");
        ListenableFuture<SendResult<K, T>> listenableFuture = null;
        if (kafkaTemplate.getDefaultTopic().equals(topic)) {
            listenableFuture =  kafkaTemplate.sendDefault(partition,timestamp,key,data);
        }else {
            listenableFuture = kafkaTemplate.send(topic, partition, timestamp, key, data);
        }
        //发送成功回调
        SuccessCallback<SendResult<K, T>> successCallback = new SuccessCallback<SendResult<K, T>>() {
            public void onSuccess(SendResult<K, T> result) {
                //成功业务逻辑
                System.out.println("成功");
            }
        };
        //发送失败回调
        FailureCallback failureCallback = new FailureCallback() {
            public void onFailure(Throwable ex) {
                //失败业务逻辑
                throw new RuntimeException(ex);
            }
        };
        listenableFuture.addCallback(successCallback, failureCallback);
    }

    public static void main(String[] args) {
        SysUser sysUser=new SysUser();
        sysUser.setUserName("kafka01");
        sysUser.setNickName("kafka用户");
        KafkaSendMsgUtils.sendMessage("user_sync",0,null,"addUser", JSON.toJSONString(sysUser));
        KafkaSendMsgUtils.sendMessage("user_sync",0,null,"addUser", JSON.toJSONString(sysUser));


//        SysUser sysUser=new SysUser();
//        sysUser.setUserName("lisi");
//        sysUser.setPassword("123456");
//        KafkaSendMsgUtils.sendMessage("user_sync",0,null,"userLogin", JSON.toJSONString(sysUser));
    }
}
