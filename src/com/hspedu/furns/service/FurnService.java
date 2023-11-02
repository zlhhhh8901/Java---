package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

import java.util.List;

public interface FurnService {
    public List<Furn> queryFurns();
    //添加家具，返回false则没添加成功
    public boolean add(Furn furn);
    //删除家具
    public boolean deleteById(int id);
    //获取家具
    public Furn queryById(int id);
    //修改家具
    public boolean update(Furn furn);

    //根据页数pageNo和pageSize获取家具信息
    public Page<Furn> page(int pageNo, int pageSize);
}
