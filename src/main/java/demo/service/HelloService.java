package demo.service;

/**
 * API Server示例
 * Desc：
 *   代码中的注解（annotation）决定了程序发布成Web Service后的行为和特性。
 *   其中，HelloService类前面的@PATH，表明该Service的URL路径，
 *   这种类名前面带@PATH注解的类被称为Root Resource Class，因为他们决定了访问Service时URI中的第一级路径；
 *   @GET表示访问该服务使用HTTP GET方法；
 *   @Produces规定该服务返回结果的类型，这里的”text/plain”表名返回纯文本。
 * User: TangBingbing
 * NT: tangbb/70288
 * Date：2017/6/26
 * Version: 1.0
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File and Code Templates.
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

@Path("/hello")
public class HelloService {
    @GET
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello world!";
    }

    /**
     * 说明：@POST表明该方法要用HTTP Post来访问， @Path表明访问该方法的相对路径是echo，@Consumes表明该方法处理HTTP Post请求中何种类型的数据。
     * 该方法参数中的注解@FormParam("msg")说明后面的“String message”参数取自表单提交数据中的msg。
     * @param message
     * @return
     */
    @POST @Path("echo")
    @Consumes("application/x-www-form-urlencoded")
    public String echo(@FormParam("msg") String message){
        return "Are you saying:"+message;
    }
}

