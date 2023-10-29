package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.FurnDao;
import com.hspedu.furns.dao.impl.FurnDaoImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;

import java.util.List;

public class FurnServiceImpl implements FurnService {
    FurnDao furnDao = new FurnDaoImpl();
    @Override
    public List<Furn> queryFurns() {
        return furnDao.queryFurns();
    }

    @Override
    public boolean add(Furn furn) {
        return furnDao.add(furn) == -1 ? false : true;
    }
}
