package deploy;

/**
 * Desc:
 * User: TangBingbing
 * NT: tangbb/70288
 * Date：2017/6/26
 * Version: 1.0
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File and Code Templates.
 */

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

public class ServiceDeployer {

    /**
     * Logger 该规则是 logback 的核心。级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
     * 定义一个全局的记录器，通过LoggerFactory获取
     */
    protected static final Logger logger = LoggerFactory.getLogger(ServiceDeployer.class);
    public static void main(String[] args) throws IOException {
        URI ServerURI = UriBuilder.fromUri("http://localhost/").port(9876).build();
        startServer(ServerURI);
        logger.info("服务已启动，请访问：" + ServerURI);
    }

    protected static SelectorThread startServer(URI serverURI) throws IOException {
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.property.packages", "demo/service");//这一行的第二个参数表明服务实现类所在的包名，系统会自动搜索做了注解的类并将其发布成服务。
        logger.info("Grizzly 启动中...");
        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(serverURI, initParams);
        return threadSelector;
    }
}
