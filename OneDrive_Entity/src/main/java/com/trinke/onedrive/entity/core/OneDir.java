package com.trinke.onedrive.entity.core;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dir")
public class OneDir {
    private int id;
    private String name;
}
