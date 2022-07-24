package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatis {

    @Test
    public void  testMyabtis() throws IOException {
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.insertUser();

//        sqlSession.commit();
        System.out.println(i);

    }

}
