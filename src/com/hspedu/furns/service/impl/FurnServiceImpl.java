package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.FurnDao;
import com.hspedu.furns.dao.impl.FurnDaoImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
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

    @Override
    public boolean deleteById(int id) {
        return furnDao.delete(id) == -1 ? false : true;
    }

    @Override
    public Furn queryById(int id) {
        return furnDao.getFurn(id);
    }

    @Override
    public boolean update(Furn furn) {
        return furnDao.update(furn) == -1 ? false : true;
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDao.getTotalRow();
        page.setTotalRow(totalRow);
        //设计一个简单的算法获取pageTotalCount
        int pageTotalCount = totalRow / pageSize;
        if(totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);

        //不明白的看mysql分页查询
        //这里藏了个坑后面演示
        int begin = (pageNo - 1) * pageSize;
        List<Furn> pageItems = furnDao.getPageItems(begin, pageSize);
        page.setItems(pageItems);

        //还差一个url 后面实现
        return page;
    }


}
