package com.treasure.ssc;

import com.alibaba.fastjson.JSON;
import com.treasure.ssc.svc.SscService;
import com.treasure.ssc.svc.impl.SscServiceImpl;
import com.treasure.ssc.util.FileUtils;
import com.treasure.ssc.vo.SscVo;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/18 16:33
 */
public class SscServiceTest {

    /**
     * 归纳从6月2号到9月18号金钱
     */
    @Test
    public void reduceAllMoney() throws IOException {
        SscService sscService = new SscServiceImpl();
        LocalDate begin = LocalDate.of(2018, 6, 17);
        LocalDate end = LocalDate.of(2018, 9, 18);
        BigDecimal total = BigDecimal.valueOf(1000);
        BigDecimal start = BigDecimal.valueOf(1);
        while (begin.isBefore(end)) {
            Path path = Paths.get("E:", "files3", begin.toString() + ".json");
            byte[] bytes = Files.readAllBytes(path);
            List<SscVo> list = JSON.parseArray(new String(bytes, Charset.defaultCharset()), SscVo.class);
            total = sscService.reduceMoney12OneDay(list, total, start);
            begin = begin.plusDays(1);
        }
    }

    /**
     * 归纳一天收入
     */
    @Test
    public void reduceMoney() throws IOException {
        SscService sscService = new SscServiceImpl();
        Path path = Paths.get("E:", "files3", "2018-06-02.json");
        byte[] bytes = Files.readAllBytes(path);
        List<SscVo> list = JSON.parseArray(new String(bytes, Charset.defaultCharset()), SscVo.class);
        sscService.reduceMoney12OneDay(list, BigDecimal.valueOf(500), BigDecimal.valueOf(3));
    }

    /**
     * 初始化数据
     */
    @Test
    public void initData() {
        // 现在
        LocalDate endDate = LocalDate.now();
        // 2018.6.2号开始，2号之前的数据有问题
        LocalDate beginDate = LocalDate.of(2018, 6, 2);

        SscService sscService = new SscServiceImpl();
        // 从一年前开始，一天一天往现在走，直到走到现在
        while (beginDate.isBefore(endDate)) {

            List<SscVo> list = sscService.list(beginDate);
            Path path = Paths.get("E:", "files", beginDate.toString() + ".json");
            try {
                FileUtils.write(JSON.toJSONBytes(list), path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            beginDate = beginDate.plusDays(1);
        }
    }

    /**
     * 计算数据，从文件中把json读出来，计算过后，再存入另外一个文件中
     */
    @Test
    public void reduceData() {
        SscService sscService = new SscServiceImpl();
        // 文件根目录
        Path fromPath = Paths.get("E:", "files");
        try {
            // 读取所有文件，计算
            Files.walk(fromPath).forEach(e -> {
                if (Files.isDirectory(e)) {
                    return;
                }
                try {
                    // 文件名
                    String pathName = e.getFileName().toString();
                    List<SscVo> list = JSON.parseArray(new String(Files.readAllBytes(e)), SscVo.class);
                    // 计算文件
                    list = sscService.reduceList(list);
                    // 计算完的文件目录
                    Path targetPath = Paths.get("E:", "files3", pathName);
                    // 计算完成，放入新文件
                    FileUtils.write(JSON.toJSONBytes(list), targetPath);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
