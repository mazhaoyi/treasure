package com.treasure.ssc;

import com.alibaba.fastjson.JSON;
import com.treasure.ssc.svc.SscService;
import com.treasure.ssc.svc.impl.SscServiceImpl;
import com.treasure.ssc.util.FileUtils;
import com.treasure.ssc.vo.SscVo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/18 16:33
 */
public class SscServiceTest {
    /*public static void main(String[] args) {
        // 现在
        LocalDate date = LocalDate.now();
        // 一年前
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        // LocalDate oneYearAgo = LocalDate.of(2018, 2, 22);
        SscService sscService = new SscServiceImpl();
        // 从一年前开始，一天一天往现在走，直到走到现在
        while (oneYearAgo.isBefore(date)) {

            List<SscVo> list = sscService.list(oneYearAgo);
            Path path = Paths.get("E:", "files", oneYearAgo.toString() + ".json");
            try {
                FileUtils.write(JSON.toJSONBytes(list), path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            oneYearAgo = oneYearAgo.plusDays(1);
        }
    }*/
}
