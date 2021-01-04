package com.awesome.team.ticket.processor;

import org.springframework.batch.item.ItemProcessor;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;

/**
 * @author 陈建业
 * @since 2021-01-03 00:33:26
 */
public abstract class CommonProcessor<I, O> implements ItemProcessor<I, O> {

    private Class<I> input;

    private Class<O> output;

    @PostConstruct
    public void init() {
        input = (Class<I>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        output = (Class<O>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public O process(I i) throws Exception {
        O o = output.newInstance();
        processor(o, i);
        return o;
    }

    /**
     * 执行
     *
     * @param o 输出
     * @param i 输入
     */
    public abstract void processor(O o, I i);

}
