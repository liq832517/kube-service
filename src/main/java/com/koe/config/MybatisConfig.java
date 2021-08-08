package com.koe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * spring-boot集成mybatis的基本入口
 * 1）创建数据源
 * 2）创建SqlSessionFactory
 */
@Configuration    //该注解类似于spring配置文件
@MapperScan(basePackages = {"com.koe.dao", "com.koe.dao.custom"}, sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class MybatisConfig {

}
