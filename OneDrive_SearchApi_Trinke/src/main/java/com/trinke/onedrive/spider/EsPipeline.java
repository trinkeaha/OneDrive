package com.trinke.onedrive.spider;

import com.trinke.onedrive.dao.NewsIndexDao;
import com.trinke.onedrive.model.NewsIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Component
public class EsPipeline implements Pipeline {

    @Autowired
    private NewsIndexDao newsIndexDao;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<NewsIndex> list = resultItems.get("news");
        if (list != null && list.size()>0) {
            newsIndexDao.saveAll(list);
        }
    }
}
