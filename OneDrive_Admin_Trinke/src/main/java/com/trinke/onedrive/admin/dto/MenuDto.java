package com.trinke.onedrive.admin.dto;


import lombok.Data;

import java.util.List;

@Data
public class MenuDto {

    private int id;
    private String name;
    private String icon;
    private List<MenuItem> childs;
}
