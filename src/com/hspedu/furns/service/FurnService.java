package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;

import java.util.List;

public interface FurnService {
    public List<Furn> queryFurns();
    //添加家具，返回false则没添加成功
    public boolean add(Furn furn);
    //删除家具
    public boolean deleteById(int id);
}
