
import com.autumn.pojo.GPSPojo;
import com.autumn.pojo.UserPosition;
import com.autumn.serviceinf.GetHttpInfoServiceInf;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by Autumn on 2018/7/16.
 */
public class Text {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext-*.xml"});
        context.start();
        GetHttpInfoServiceInf demoService = (GetHttpInfoServiceInf)context.getBean("getHttpInfoServicefromdubbo"); // 获取远程服务代理
        List<UserPosition> userPostions = demoService.getGPSForWeb("qyid1");// 执行远程方法
        System.out.println( userPostions ); // 显示调用结果
    }
}
