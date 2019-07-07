package com.company.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.company.mapper.SysLogMapper;

public class MybatisConfig {//了解
	 private static SqlSessionFactory sqlSessionFactory;
	 static {//类加载时执行一次
		 //创建数据源对象
		 PooledDataSource dataSource=
			new PooledDataSource();
		 dataSource.setDriver("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql:///jtsys?serverTimezone=GMT");
		 dataSource.setUsername("root");
		 dataSource.setPassword("root");
		 //创建事务工厂
		 TransactionFactory transactionFactory =
		 new JdbcTransactionFactory();
		 //创建环境对象
		 Environment environment =
		 new Environment("development",
				         transactionFactory, 
				         dataSource);
		 //创建配置对象
		 Configuration configuration =
		 new Configuration(environment);
		 //注册映射文件
		 configuration.addMapper(SysLogMapper.class);
		 //基于配置对象构建SqlSessionFactory工厂对象
		 sqlSessionFactory =
		 new SqlSessionFactoryBuilder().build(configuration);
	 }
	
	 public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	 }

}
