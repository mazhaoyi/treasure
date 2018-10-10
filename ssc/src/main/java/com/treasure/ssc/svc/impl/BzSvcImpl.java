package com.treasure.ssc.svc.impl;

import com.treasure.mbgenerator.entity.Bz;
import com.treasure.mbgenerator.entity.BzExample;
import com.treasure.mbgenerator.mapper.BzMapper;
import com.treasure.common.constant.SscConst;
import com.treasure.common.util.DateUtils;
import com.treasure.common.util.HttpUtils;
import com.treasure.ssc.svc.BzSvc;
import com.treasure.ssc.vo.BzOtherVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/10/8 12:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BzSvcImpl implements BzSvc {
    @Autowired
    private BzMapper bzMapper;

    @Override
    public void initBz() {
        Long count = bzMapper.countByExample(null);
        if (count > 0) {
            return;
        }
        List<BzOtherVo> list = HttpUtils.getList(SscConst.BZ_URL, null, BzOtherVo.class);
        if (CollectionUtils.isNotEmpty(list)) {
            list.stream().forEach(e -> {
                Bz bz = new Bz();
                bz.setBzDate(e.getDay());
                bz.setBsg(e.getIsBsg());
                bz.setQbg(e.getIsQbg());
                bz.setQbs(e.getIsQbs());
                bz.setQsg(e.getIsQsg());
                bz.setWbg(e.getIsWbg());
                bz.setWbs(e.getIsWbs());
                bz.setWqb(e.getIsWqb());
                bz.setWqg(e.getIsWqg());
                bz.setWqs(e.getIsWqs());
                bz.setWsg(e.getIsWsg());
                bz.setWxzs(e.getWxType());
                bz.setWxzw(e.getBsgType());
                bzMapper.insertSelective(bz);
            });
        }
    }

    @Override
    public BigDecimal oneDayMoney(LocalDate date) {
        BzExample example = new BzExample();
        BzExample.Criteria criteria = example.createCriteria();
        criteria.andBzDateEqualTo(DateUtils.toDate(date));
        List<Bz> list = bzMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return BigDecimal.ZERO;
        }
        // 豹子倍数
        BigDecimal bzMul = BigDecimal.valueOf(0.9);
        // 组10倍数
        BigDecimal zsMul = BigDecimal.valueOf(10);
        // 组5倍数
        BigDecimal zwMul = BigDecimal.valueOf(10);
        // 豹子种类数
        BigDecimal bzTypeCount = BigDecimal.valueOf(10);
        // 总期数
        BigDecimal countNo = BigDecimal.valueOf(120);
        // 初始金钱
        BigDecimal initMoney = BigDecimal.valueOf(0);
        // 豹子一期消费 * 倍数
        BigDecimal bz1Money = BigDecimal.valueOf(1).multiply(bzMul);
        // 豹子一期赚钱 * 倍数
        BigDecimal bz1Fee = BigDecimal.valueOf(96).multiply(bzMul);
        // 组10一期消费 * 倍数
        BigDecimal zs1Money = BigDecimal.valueOf(0.9).multiply(zsMul);
        // 组10一期赚钱 * 倍数
        BigDecimal zs1Fee = BigDecimal.valueOf(96.9).multiply(zsMul);
        // 组5一期消费 * 倍数
        BigDecimal zw1Money = BigDecimal.valueOf(0.9).multiply(zwMul);
        // 组5一期赚钱 * 倍数
        BigDecimal zw1Fee = BigDecimal.valueOf(193.8).multiply(zwMul);
        Bz bz = list.get(0);
        // 消费后金钱 = 初始金钱 - 豹子金钱*10 - 组10金钱 - 组5金钱
        BigDecimal result = initMoney
                // 豹子金钱
                .subtract(bz1Money.multiply(countNo).multiply(bzTypeCount))
                // 组10金钱
                .subtract(zs1Money.multiply(countNo))
                // 组5金钱
                .subtract(zw1Money.multiply(countNo));
        // 豹子个数
        int bzSum = bz.getWqb() + bz.getWqs() + bz.getWqg() + bz.getWbs() + bz.getWbg() + bz.getWsg() + bz.getQbs() + bz.getQbg() + bz.getQsg() + bz.getBsg();
        // 组10个数
        int zsSum = bz.getWxzs();
        // 组5个数
        int zwSum = bz.getWxzw();
        // 中奖后金钱 = 初始金钱 + 豹子赚钱 + 组10赚钱 + 组5赚钱
        result = result
                // 豹子
                .add(BigDecimal.valueOf(bzSum).multiply(bz1Fee))
                // 组10
                .add(BigDecimal.valueOf(zsSum).multiply(zs1Fee))
                // 组5
                .add(BigDecimal.valueOf(zwSum).multiply(zw1Fee));
        return result;
    }

    @Override
    public BigDecimal daysMoney(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            return BigDecimal.ZERO;
        }
        if (start.isAfter(end)) {
            return BigDecimal.ZERO;
        }
        BigDecimal result = BigDecimal.ZERO;
        while (start.isBefore(end)) {
            BigDecimal oneDayMoney = oneDayMoney(start);
            result = result.add(oneDayMoney);
            start = start.plusDays(1);
        }
        return result;
    }
}
