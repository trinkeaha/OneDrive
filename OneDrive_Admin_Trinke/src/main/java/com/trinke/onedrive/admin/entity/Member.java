package com.trinke.onedrive.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
public class Member extends Model<Member> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String mname;
    private String password;
    private Date ctime;
    private Integer flag;
}
