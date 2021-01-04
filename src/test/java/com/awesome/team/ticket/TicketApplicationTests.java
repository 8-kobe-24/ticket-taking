package com.awesome.team.ticket;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.service.sync.TblDocStockService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.redisson.api.RSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = TicketApplication.class)
class TicketApplicationTests {

    @Resource
    RedissonClient redissonClient;

    @Test
    void testRedis() {
        long t1 = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        RSortedSet<Integer> set1 = redissonClient.getSortedSet("ticket");
        set1.addAll(set);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        // set1是号池的数据，set2是已经用过票号的数据
        set1.removeAll(set2);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        Assert.assertNotNull(t2 - t1);
    }

    @Resource
    private TblDocStockService tblDocStockService;

    @Test
    public void testGetList() {
        long t1 = System.currentTimeMillis();
        List<TblDocStock> list = tblDocStockService.list();
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    @Test
    public void testJob() throws Exception {
        tblDocStockService.syncData();
    }

}
