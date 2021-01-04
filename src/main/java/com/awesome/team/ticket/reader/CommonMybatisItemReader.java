package com.awesome.team.ticket.reader;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

import java.util.Map;

/**
 * 公共ItemReader
 *
 * @author 陈建业
 * @since 2020-10-22 17:12:33
 */
@Slf4j
public class CommonMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonMybatisItemReader(SqlSessionFactory sqlSessionFactory,
                                   String queryId,
                                   Map<String, Object> parameterValues) {
        setSqlSessionFactory(sqlSessionFactory);
        setParameterValues(parameterValues);
        setQueryId(queryId);
    }
}
