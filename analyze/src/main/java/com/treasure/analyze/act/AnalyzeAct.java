package com.treasure.analyze.act;

import com.treasure.analyze.svc.AnalyzeSvc;
import com.treasure.analyze.vo.AnalyzeVo;
import com.treasure.analyze.vo.ShaVo;
import com.treasure.common.util.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    public Object list(Date date) {
        List<AnalyzeVo> list = analyzeSvc.getDateFromRemote(date);
        return ResultUtils.success(list);
    }

    @GetMapping(value = "/shalist")
    public Object shaList(Date date, String shaNum) {
        if (StringUtils.isBlank(shaNum)) {
            throw new RuntimeException("shaNum必填");
        }
        List<ShaVo> list = analyzeSvc.getShaDateFromRemote(date, shaNum);
        return ResultUtils.success(list);
    }

    @GetMapping(value = "/mapallnum")
    public Object mapallnum(Date date, String no) {
        List<String> list = analyzeSvc.mapAllNum(date, no);
        return ResultUtils.success(list);
    }
}
