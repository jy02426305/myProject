import com.cyx.spring.zhujie.service.Practice18Service;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TranTest {
    @Test
    public void testTran(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        Practice18Service practice18Service=(Practice18Service)context.getBean("practice18Service");
        practice18Service.buyBook();
    }
}
