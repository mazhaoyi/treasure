package com.treasure.ssc.act;

import com.treasure.ssc.svc.AnalyzeSvc;
import com.treasure.ssc.util.ResUtils;
import com.treasure.ssc.vo.AnalyzeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: mazy
 * @date: 2018/10/9 15:22
 */
@RestController
@RequestMapping(value = "/analyze")
public class AnalyzeAct {
    @Autowired
    private AnalyzeSvc analyzeSvc;

    @GetMapping(value = "/list")
    public Object list() {
        List<AnalyzeVo> list = analyzeSvc.getDateFromRemote();
        return ResUtils.success(list);
    }
}
