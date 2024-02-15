package com.baseball.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.baseball")
public class DataBaseConfig {
    @Bean
    public  SqlSessionFactory  sqlSessionFactory(DataSource dataSource )  throws Exception {

        SqlSessionFactoryBean sqlSessionFactory = new  SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new  PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResource("classpath:mappers/BaseBallDao.xml"));
        return sqlSessionFactory.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory  sqlSessionFactory) throws Exception{

        final  SqlSessionTemplate  sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
