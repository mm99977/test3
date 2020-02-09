package com.xr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -4457800623393668218L;
    private Integer rid;
    private String roleName;
    //多对多
    private List<Menu> menus;
}
