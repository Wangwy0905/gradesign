package com.wenyi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//菜单管理
@Table(name="menu")
public class Menu {
    @Id
    private  Integer id;
    private  String  title;
    private  String  url;
    private  String  iconcls;
    private  Integer parentId;
    private  List<Menu> menuList;
}
