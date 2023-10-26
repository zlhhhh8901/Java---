package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDAO;
import com.hspedu.furns.dao.FurnDao;
import com.hspedu.furns.entity.Furn;

import java.util.List;

public class FurnDaoImpl extends BasicDAO<Furn> implements FurnDao {
    @Override
    public List<Furn> queryFurns() {
        //这里不用 * 是为了解决前面遗留的问题
        //前面我们定义的属性名是imgPath，而其对应的列名是img_path
        //这样在我们查询时就无法得到img_path的信息，会返回 null
        //因此要在sql查询语句上做修改————加别名
        //遇到属性名和表的列名不一致时就可以这么做！
        String sql = "select `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` imgPath from furn";
        return queryMulti(sql, Furn.class);
    }
}
