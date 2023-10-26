package com.hspedu.furns.test;

import com.hspedu.furns.dao.FurnDao;
import com.hspedu.furns.dao.impl.FurnDaoImpl;
import com.hspedu.furns.entity.Furn;
import org.junit.Test;

import java.util.List;

public class FurnDaoImplTest {
    FurnDao furnDao = new FurnDaoImpl();
    @Test
    public void queryFurnTest(){
        List<Furn> furns = furnDao.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
}
