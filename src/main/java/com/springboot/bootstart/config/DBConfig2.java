package com.springboot.bootstart.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.bootstart.dao.mapper2",sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DBConfig2 {


//    @Primary
//    @Bean(name= "primaryDataSourceProperties")
//    @Qualifier("primaryDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSourceProperties primaryDataSourceProperties(){
//        return new DataSourceProperties();
//    }

    /**
     * 配置数据库
     * @return
     */
    @Bean(name="db2Datasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource testDataSource(){
//        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
        return DataSourceBuilder.create().build();
    }


    /**
     * 创建sqlSessionFactory
     */
    @Bean(name = "db2SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2Datasource")DataSource dataSource ) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean("db2TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2Datasource") DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }
    @Bean("db2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
