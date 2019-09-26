package com.trinke.onedrive.task;

import com.trinke.onedrive.spider.EsPipeline;
import com.trinke.onedrive.spider.NewsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class NewsTask {

    @Autowired
    private EsPipeline esPipeline;

    //@Scheduled(cron = "0 0/2 * * * ?")
    public void startNews() {
        new Spider(new NewsPage()).addPipeline(esPipeline).addUrl("https://news.dahe.cn/yl/").run();
    }
}
