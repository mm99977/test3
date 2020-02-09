package com.xr.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 559903389742933427L;
    private Integer mid;
    private  String menuName;
    private String url;
    private  Integer parentId;
    private String code;
    private String iconCls;

    //多对多
    private List<Role> roles;
}
