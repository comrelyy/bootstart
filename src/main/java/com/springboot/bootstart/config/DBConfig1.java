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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.bootstart.dao.mapper1",sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DBConfig1 {


//    @Bean(name= "db1Properties")
//    @Qualifier("db1Properties")
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSourceProperties db1Properties(){
//        return new DataSourceProperties();
//    }


    /**
     * 配置数据库
     * @return
     */
    @Bean(name="db1Datasource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource testDataSource(){
        //return db1Properties().initializeDataSourceBuilder().build();
        return DataSourceBuilder.create().build();
    }

    /**
     * 读取全局配置，因为使用了多数据源的配置方法，
     * 默认会读取@Configuration类下的配置，如果只在全局配置文件中设置，可能由于加载顺序问题，配置不会被加载
     */
    @Bean(name="mybatisConfig")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration globalConfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }

    /**
     * 创建sqlSessionFactory
     */
    @Bean(name = "db1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1Datasource")DataSource dataSource,@Qualifier("mybatisConfig") org.apache.ibatis.session.Configuration globalConfiguration ) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //开启驼峰映射
        //org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(globalConfiguration);
        bean.setDataSource(dataSource);
        //可以读取mapper.xml文件
       // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*******Mapper.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean("db1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1Datasource") DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("db1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
