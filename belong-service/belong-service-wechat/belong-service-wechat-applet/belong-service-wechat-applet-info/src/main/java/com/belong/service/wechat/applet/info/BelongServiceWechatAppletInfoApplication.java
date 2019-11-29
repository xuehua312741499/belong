package com.belong.service.wechat.applet.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:微信小程序个人中心服务启动类
 * @Author: fengyu
 * @CreateDate: 2019/10/28 15:28
 * @UpdateUser: fengyu
 * @UpdateDate: 2019/10/28 15:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class}, scanBasePackages = {"com.belong"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.belong"})
@MapperScan("com.belong.**.mapper")
public class BelongServiceWechatAppletInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BelongServiceWechatAppletInfoApplication.class, args);
    }
}