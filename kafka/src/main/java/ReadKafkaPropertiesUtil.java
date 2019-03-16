import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadKafkaPropertiesUtil {
    /**
     * 属性
     */
    private static Properties properties;

    /**
     * 读取kafka.properties
     */
    static {
        properties = new Properties();
        String path = ReadKafkaPropertiesUtil.class.getResource("/").getFile().toString() + "kafka.properties";
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            properties.load(fis);
        } catch (Exception e) {

        }
    }

    /**
     * 获取kafka的配置信息
     *
     * @return
     */
    public static Properties getProperties() {
        return properties;
    }

    /**
     * 获取kafka的topic
     *
     *
     * @return
     */
    public static String getTopic() {
        return properties.getProperty("kafka.consumer.topic");
    }

    /**
     * 获取kafka的kafka.consumer.key.989847
     *
     * @return
     */
    public static String getKey989847() {
        return properties.getProperty("kafka.consumer.key.989847");
    }

    /**
     * 获取kafka的kafka.consumer.key.989848
     *
     * @return
     */
    public static String getKey989848() {
        return properties.getProperty("kafka.consumer.key.989848");
    }

    /**
     * 获取kafka的kafka.consumer.key.989849
     *
     * @return
     */
    public static String getKey989849() {
        return properties.getProperty("kafka.consumer.key.989849");
    }

    /**
     * 获取kafka的kafka.consumer.key.989850
     *
     * @return
     */
    public static String getKey989850() {
        return properties.getProperty("kafka.consumer.key.989850");
    }

    /**
     * 私有构造函数
     */
    private ReadKafkaPropertiesUtil() {
    }
}
