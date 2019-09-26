package com.trinke.onedrive.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trinke.onedrive.entity.core.OneDir;
import com.trinke.onedrive.server.dao.OneDirDao;
import com.trinke.onedrive.server.service.OneDirService;
import org.springframework.stereotype.Service;

@Service
public class OneDirServiceImpl extends ServiceImpl<OneDirDao, OneDir> implements OneDirService  {
}
