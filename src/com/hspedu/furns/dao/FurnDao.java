package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Furn;

import java.util.List;

public interface FurnDao {
    //返回所有家具信息
    public List<Furn> queryFurns();

    //添加家具
    public int add(Furn furn);

    //删除家具
    public int delete(int id);

}
