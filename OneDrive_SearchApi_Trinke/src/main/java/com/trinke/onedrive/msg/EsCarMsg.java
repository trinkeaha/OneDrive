package com.trinke.onedrive.msg;

import com.alibaba.fastjson.JSON;
import com.trinke.onedrive.common.config.RedisKeyConfig;
import com.trinke.onedrive.dao.CarIndexDao;
import com.trinke.onedrive.model.CarIndex;
import com.trinke.onedrive.util.RedissonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EsCarMsg {
    @Autowired
    private CarIndexDao carIndexDao;

    @RabbitListener(queues = "escar")
    public void recMsg(String msg) {
        System.out.println("消息监听器:"+msg);

        List<String> adds = RedissonUtil.getList(RedisKeyConfig.ES_ADDKEY);
        if (adds != null && adds.size() > 0) {
            List<CarIndex> carIndices = new ArrayList<>();

            for (String s : adds) {
                carIndices.add(JSON.parseObject(s,CarIndex.class));
            }
            carIndexDao.saveAll(carIndices);
            RedissonUtil.delList(RedisKeyConfig.ES_ADDKEY);
        }

        List<String> dels = RedissonUtil.getList(RedisKeyConfig.ES_DELKEY);
        if (dels != null && dels.size() > 0) {
            for (String s:dels) {
                carIndexDao.deleteById(Integer.parseInt(s));
            }
            RedissonUtil.delList(RedisKeyConfig.ES_DELKEY);
        }
        List<String> updates = RedissonUtil.getList(RedisKeyConfig.ES_UPDATEKEY);
        if (updates != null && updates.size() > 0) {
            List<CarIndex> carIndices = new ArrayList<>();
            for (String s: updates) {
                carIndices.add(JSON.parseObject(s,CarIndex.class));
            }
            carIndexDao.saveAll(carIndices);
            RedissonUtil.delList(RedisKeyConfig.ES_UPDATEKEY);
        }


    }
}
