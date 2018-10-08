package com.treasure.ssc.act;

import com.treasure.ssc.svc.BzSvc;
import com.treasure.ssc.util.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mazy
 * @date: 2018/10/8 14:48
 */
@RestController
@RequestMapping(value = "/bz")
public class BzAct {
    @Autowired
    private BzSvc bzSvc;

    @GetMapping("/init")
    public Object init() {
        bzSvc.initBz();
        return ResUtils.success(null);
    }
}
