package com.awesome.team.ticket.processor;

import org.springframework.beans.BeanUtils;

/**
 * @author 陈建业
 * @since 2021-01-03 00:33:26
 */
public class CommonProcessorInstance<I, O> extends CommonProcessor<I, O> {

    @Override
    public void processor(O o, I i) {
        BeanUtils.copyProperties(i, o);
    }
}
