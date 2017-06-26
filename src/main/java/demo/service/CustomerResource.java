package demo.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 * Desc:
 * 1. @Path: 定义服务路径，接口中定义的整个服务的顶级路径为"/customers "，方法对应的服务路径为接口路径加方法定义的Path值，
 *      如果未定义，则用接口路径，例如getCustomer()的服务路径为：" /customers/{id} "。所以此REST对外服务路径都是 服务的上下文路径/customers/ 子级目录，
 * 2. @POST，@GET，@PUT：标注方法所支持HTTP请求的类型 （参考上面的说明）
 * 3. @Produces，@Consumes：标注方法支持或返回的请求MIME类型。
 *
 * User: TangBingbing
 * NT: tangbb/70288
 * Date：2017/6/26
 * Version: 1.0
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File and Code Templates.
 */
@Path("/customers")
public interface CustomerResource {

    /**
     * createConsumer()： 请求HTTP方法为POST；请求MIME类型为application/xml；请求路径为： 上下文路径/customers
     * @param is
     * @return
     */
    @POST
    @Consumes("application/xml")
    Response createCustomer(InputStream is);

    /**
     * getCustomer()： 请求的HTTP方法为GET；请求的MIME类型为application/xml；请求的路径为： 上下文路径/customers/{id}
     注： {id}为某个存在（或不存在）customer的编号
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces("application/xml")
    StreamingOutput getCustomer(@PathParam("id") int id);

    /**
     * updateCustomer()： 请求的HTTP方法为PUT；请求的MIME类型为application/xml；请求的路径： 上下文路径/customers/{id}
     * 注： {id}为某个存在（或不存在）customer的编号
     * @param id
     * @param is
     */
    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    void updateCustomer(@PathParam("id") int id, InputStream is) ;
}
