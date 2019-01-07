package com.treasure.psh.poi;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * excel读写工具类 */
public class PoiUtils {
    private static Logger logger  = LoggerFactory.getLogger(PoiUtils.class);
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    //CSV文件分隔符
    private final static String NEW_LINE_SEPARATOR="\n";

    /**
     * 读入excel文件，解析后返回 
     * @param path
     * @throws IOException
     */
    public static List<String[]> readExcel(Path path) throws IOException{
        //检查文件  
        checkFile(path);
        //获得Workbook工作薄对象  
        Workbook workbook = null;
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回  
        List<String[]> list = new ArrayList<String[]>();
        try {
            workbook = getWorkBook(path);
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return list;
    }

    /**
     * 写EXCEL
     * @param path
     * @param headers
     * @param contentList
     */
    public static void writeExcel(Path path, String[] headers, List<String[]> contentList) throws IOException {
        Workbook workbook = null;
        FileOutputStream fos = null;
        try {

            workbook = getWorkBook(path);
            // 创建一张工作表
            Sheet sheet = workbook.createSheet();
            int rowIndex = 0;
            // 创建表头
            if (headers != null && headers.length > 0) {
                Row row = sheet.createRow(rowIndex);
                rowIndex++;
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(headers[i]);
                }
            }
            // 写内容
            if (contentList != null && contentList.size() > 0) {
                for (int i = 0; i < contentList.size(); i++, rowIndex++) {
                    Row row = sheet.createRow(rowIndex);
                    String[] contents = contentList.get(i);
                    for (int j = 0; j < contents.length; j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(contents[j]);
                    }
                }
            }
            fos = new FileOutputStream(path.toFile());
            workbook.write(fos);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 检查文件是否是Excel
     * @param path
     * @throws IOException
     */
    public static void checkFile(Path path) throws IOException{
        //判断文件是否存在  
        if(null == path){
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名  
        String fileName = path.getFileName().toString();
        //判断文件是否是excel文件  
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){
            logger.error(fileName + "不是excel文件");
            throw new IOException(fileName + "不是excel文件");
        }
    }

    /**
     * 获取工作簿
     * @param path
     * @return
     */
    public static Workbook getWorkBook(Path path) {
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        String fileName = path.getFileName().toString();
        //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
        if(fileName.endsWith(xls)){
            //2003
            workbook = new HSSFWorkbook();
        }else if(fileName.endsWith(xlsx)){
            //2007
            workbook = new XSSFWorkbook();
        }
        return workbook;
    }

    /**
     * 获取值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况  
        if(cell.getCellType() == CellType.NUMERIC){
            cell.setCellType(CellType.STRING);
        }
        //判断数据的类型  
        switch (cell.getCellType()){
            //数字
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            //字符串
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            //Boolean
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            //公式
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            //空值
            case BLANK:
                cellValue = "";
                break;
            //故障
            case ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     * 读取CSV文件
     * @param path
     * @param headers
     * @return
     * @throws Exception
     */
    public static List<CSVRecord> csvRead(Charset charset, Path path, String[] headers) throws Exception {
        //创建CSVFormat
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);

        //创建CSVParser对象
        CSVParser parser = CSVParser.parse(path, charset, formator);

        List<CSVRecord> records=parser.getRecords();

        parser.close();

        return records;
    }

    /**写入csv文件
     * @param headers 列头
     * @param data 数据内容
     * @param filePath 创建的csv文件路径
     * @throws IOException **/
    public static void writeCsv(String[] headers, List<String[]> data, String filePath) throws IOException {

        //初始化csvformat
        CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        //创建FileWriter对象
        FileWriter fileWriter = null;

        //创建CSVPrinter对象
        CSVPrinter printer = null;
        try {
            fileWriter = new FileWriter(filePath, true);

            printer = new CSVPrinter(fileWriter, formator);
            //写入列头数据
            if (headers != null && headers.length > 0) {
                printer.printRecord(headers);
            }

            if(null != data){
                //循环写入数据
                for(String[] lineData : data){

                    printer.printRecord(lineData);
                }
            }
            printer.flush();
            fileWriter.flush();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (printer != null) {
                try {
                    printer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 获取项目所在文件夹的绝对路径
     * @return
     */
    public static String getCurrentDirPath() {
        URL url = PoiUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String path = url.getPath();
        if(path.startsWith("file:")) {
            path = path.replace("file:", "");
        }
        if(path.contains(".jar!/")) {
            path = path.substring(0, path.indexOf(".jar!/")+4);
        }

        File file = new File(path);
        path = file.getParentFile().getAbsolutePath();
        return path;
    }

    /*public static void main(String[] args) throws Exception {
        Path path = Paths.get("E:", "psh", "结算", "248030623-2018-11-22.csv");
        List<CSVRecord> list = csvRead(Charset.forName("GBK"), path, null);
        List<String[]> contentList = new ArrayList<>();
        for (CSVRecord r : list) {
            int size = r.size();
            String[] contents = new String[size];
            for (int i = 0; i < size; i++) {
                String rv = r.get(i);
                contents[i] = rv;
            }
            contentList.add(contents);
        }
        Path resPath = Paths.get("E:", "psh", "结算", "res", "test.xls");
        writeExcel(resPath, null, contentList);
    }*/

    public static void main(String[] args) throws Exception {
        String propPath = getCurrentDirPath();
        Properties prop = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = null;
        try {
            in = Files.newInputStream(Paths.get(propPath + "/" + "psh.properties"));
            prop.load(in);
            String fromPath = prop.getProperty("fromPath");
            String toPath = prop.getProperty("toPath");
            String toName = prop.getProperty("toName");

            Files.walk(Paths.get(fromPath)).filter(e -> e.toFile().isFile()).forEach(e -> {
                List<CSVRecord> list = null;
                try {
                    list = csvRead(Charset.forName("GBK"), e, null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (CollectionUtils.isEmpty(list)) {
                    return;
                }
                List<String[]> contentList = new ArrayList<>();
                for (CSVRecord r : list) {
                    int size = r.size();
                    String[] contents = new String[size];
                    for (int i = 0; i < size; i++) {
                        String rv = r.get(i);
                        contents[i] = rv;
                    }
                    contentList.add(contents);
                }
                Path resPath = Paths.get(toPath + "/" + toName);
                try {
                    writeCsv(null, contentList, resPath.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } finally {
            if (in != null) {
                in.close();
            }
        }

        System.out.println("完成！按任意键结束！");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextLine());
    }

}