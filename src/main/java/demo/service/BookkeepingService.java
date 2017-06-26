package demo.service;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import demo.bean.Account;
import demo.bean.Person;

/**
 * Desc:
 *   JAX-RS 中涉及 Resource 方法参数的标注包括：@PathParam、@MatrixParam、@QueryParam、@FormParam、@HeaderParam、@CookieParam、@DefaultValue 和 @Encoded。
 *   这其中最常用的是 @PathParam，它用于将 @Path 中的模板变量映射到方法参数，模板变量支持使用正则表达式，变量名与正则表达式之间用分号分隔。
 *   例如对 清单 1中所示的 BookkeepingService 类，如果使用 Get 方法请求资源”/person/jeffyin”，则 readPersonByName 方法将被调用，方法参数 name 被赋值为”jeffyin”；
 *   而如果使用 Get 方法请求资源”/person/123”，则 readPerson 方法将被调用，方法参数 id 被赋值为 123。要了解如何使用其它的参数标注 , 请参考 JAX-RS API。
 *   JAX-RS 规定 Resource 方法中只允许有一个参数没有打上任何的参数标注，该参数称为实体参数，用于映射请求体。
 *   例如 清单 1 中所示的 BookkeepingService 类的 createPerson 方法和 updatePerson 方法的参数 person。
 * User: TangBingbing
 * NT: tangbb/70288
 * Date：2017/6/26
 * Version: 1.0
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File and Code Templates.
 */
@Path("/")
public class BookkeepingService {

    @Path("/person/")
    @POST
    @Consumes("application/json")
    public Response createPerson(Person person) {
        return null;
    }

    @Path("/person/")
    @PUT
    @Consumes("application/json")
    public Response updatePerson(Person person) {
        // ......
        return null;
    }

    @Path("/person/{id:\\d+}/")
    @DELETE
    public Response deletePerson(@PathParam("id")
                                         int id) {
        // ......
        return null;
    }

    @Path("/person/{id:\\d+}/")
    @GET
    @Produces("application/json")
    public Person readPerson(@PathParam("id")
                                     int id) {
        // ......
        return null;
    }

    @Path("/persons/")
    @GET
    @Produces("application/json")
    public Person[] readAllPersons() {
        //......
        return null;
    }

    @Path("/person/{name}/")
    @GET
    @Produces("application/json")
    public Person readPersonByName(@PathParam("name")
                                           String name) {
        // ......
        return null;
    }

    /**
     * 如果使用 POST 方法请求资源”/account”，则 createAccount 方法将被调用，JSON 格式的请求体被自动映射为实体参数 account。
     * @param account
     * @return
     */
    @Path("/account/")
    @POST
    @Consumes("application/json")
    public Response createAccount(Account account) {
        // ......
        return null;
    }

    /**
     * 如果使用 GET 方法请求资源”/person/123/accounts”，则 readAccountsByPerson 方法将被调用，
     * 方法参数 id 被赋值为 123，Account 数组类型的返回值被自动映射为 JSON 格式的响应体；
     * @param id
     * @return
     */
    @Path("/person/{id}/accounts/")
    @GET
    @Produces("application/json")
    public Account[] readAccountsByPerson(@PathParam("id")
                                                  int id) {
        // ......
        return null;
    }

    /**
     * 而如果使用 GET 方法请求资源”/accounts/2008-01-01,2009-01-01”，则 readAccountsByDateBetween 方法将被调用，
     * 方法参数 beginDate 被赋值为”2008-01-01”，endDate 被赋值为”2009-01-01”，
     * Account 数组类型的返回值被自动映射为 JSON 格式的响应体。
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    @Path("/accounts/{beginDate:\\d{4}-\\d{2}-\\d{2}},{endDate:\\d{4}-\\d{2}-\\d{2}}/")
    @GET
    // 作为服务端，Resource 方法的 Produces 标注用于指定响应体的数据格式（MIME 类型）,Consumes 标注用于指定请求体的数据格式
    @Produces("application/json")
    public Account[] readAccountsByDateBetween(@PathParam("beginDate")
                                                       String beginDate, @PathParam("endDate")
                                                       String endDate) throws ParseException {
        // ......
        return null;
    }

    /**
     * 如果使用 PUT 方法请求资源”/account”，则 updateAccount 方法将被调用，JSON 格式的请求体被自动映射为实体参数 account。
     * @param account
     * @return
     */
    @Path("/account/")
    @PUT
    // 作为服务端，Resource 方法的 Produces 标注用于指定响应体的数据格式（MIME 类型）,Consumes 标注用于指定请求体的数据格式
    @Consumes("application/json")
    public Response updateAccount(Account account) {
        // ......
        return null;
    }

    /**
     * 如果使用 DELETE 方法请求资源”/account/323”，则 deleteAccount 方法将被调用，方法参数 id 被赋值为 323。
     * @param id
     * @return
     */
    @Path("/account/{id:\\d+}/")
    @DELETE
    public Response deleteAccount(@PathParam("id")
                                          int id) {
        // ......
        return null;
    }
}