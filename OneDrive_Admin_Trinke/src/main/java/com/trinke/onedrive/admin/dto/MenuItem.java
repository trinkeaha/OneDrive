package com.trinke.onedrive.admin.dto;


import lombok.Data;

@Data
public class MenuItem {
    private int id;
    private String name;
    private String murl;
    private String icon;
    private int level;
}
