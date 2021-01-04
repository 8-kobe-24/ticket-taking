package com.awesome.team.ticket.processor;

import org.springframework.batch.item.ItemProcessor;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
//        output = (Class<O>) (((ParameterizedTypeImpl) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
        Type[] types = ((ParameterizedTypeImpl) getClass().getGenericSuperclass()).getActualTypeArguments();
        output = (Class<O>) types[0];
        System.out.println(output);
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
