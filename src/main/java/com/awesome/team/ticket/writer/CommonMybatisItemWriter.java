package com.awesome.team.ticket.writer;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

/**
 * @author 陈建业
 * @since 2021-01-03 13:02:19
 */
@Slf4j
public class CommonMybatisItemWriter<T> extends MyBatisBatchItemWriter<T> {

    public CommonMybatisItemWriter(SqlSessionFactory sqlSessionFactory,
                                   String queryId) {
        setSqlSessionFactory(sqlSessionFactory);
        setStatementId(queryId);
    }
}
