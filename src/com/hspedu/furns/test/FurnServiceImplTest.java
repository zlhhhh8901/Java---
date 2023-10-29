package com.hspedu.furns.test;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class FurnServiceImplTest {
    Furn furn = new Furn(null,"小桌子","力华家具",new BigDecimal(1999.00),100,5,"assets/images/product-image/6.jpg");
    FurnService furnService = new FurnServiceImpl();
    @Test
    public void addTest(){
        furnService.add(furn);
    }
}
