package com.trinke.onedrive.spider;


import com.trinke.onedrive.common.util.IdGenerator;
import com.trinke.onedrive.model.NewsIndex;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class NewsPage implements PageProcessor {
    private IdGenerator idGenerator = new IdGenerator();
    @Override
    public void process(Page page) {
        List<String> titles=page.getHtml().xpath("div[@class='newsleft']/ul[@class='newsleftul']/li/a/text()").all();
        List<String> times=page.getHtml().xpath("div[@class='newsleft']/ul[@class='newsleftul']/li/span/text()").all();
        List<String> urls=page.getHtml().xpath("div[@class='newsleft']/ul[@class='newsleftul']/li/a/@href").all();
        List<NewsIndex> list=new ArrayList<>();

        for(int i=0;i<titles.size();i++){
            NewsIndex ni=new NewsIndex();
            ni.setTime(times.get(i));
            ni.setTitle(titles.get(i));
            ni.setUrl(urls.get(i));
            ni.setId(idGenerator.nextId()+"");
            list.add(ni);
        }
        System.out.println(list.size());

        //将数据传递到处理器
        page.putField("news",list);
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(5000).setTimeOut(10000);
    }
}
