package demo.bean;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Desc:
 *  JAX-RS 与 JPA 的结合使用
 *    由于 JAX-RS 和 JPA 同样都使用了基于 POJO 和标注的编程模型，因而很易于结合在一起使用。
 *    示例应用中的 Web 资源 ( 如账目 ) 同时也是持久化到数据库中的实体，
 *    同一个 POJO 类上既有 JAXB 的标注，也有 JPA 的标注 ( 或者还有 Gson 的标注 ) ，这使得应用中类的个数得以减少。
 *    如 清单 7所示，Account 类可以在 JAX-RS 与 JPA 之间得到复用，
 *    它不但可以被 JAX-RS 绑定为请求体 / 响应体的 XML/JSON 数据，也可以被 JPA 持久化到关系型数据库中。
 * User: TangBingbing
 * NT: tangbb/70288
 * Date：2017/6/26
 * Version: 1.0
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Table(name = "TABLE_ACCOUNT")
@XmlRootElement
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COL_ID")
    @Expose
    private int id;

    @ManyToOne
    @JoinColumn(name = "COL_PERSON")
    @Expose
    private Person person;

    @Column(name = "COL_AMOUNT")
    @Expose
    private BigDecimal amount;

    @Column(name = "COL_DATE")
    @Expose
    private Date date;

    @ManyToOne
    @JoinColumn(name = "COL_CATEGORY")
    @Expose
    private Category category;

    @Column(name = "COL_COMMENT")
    @Expose
    private String comment;
}
