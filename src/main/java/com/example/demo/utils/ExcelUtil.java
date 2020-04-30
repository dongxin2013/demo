package com.example.demo.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.UserTemp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: excel文件读取工具类
 * @author: dongxin
 * @create: 2019-10-30 14:16
 **/
@Component
public class ExcelUtil {

    /**
     * 读取excel
     */
    public Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        //文件后缀名
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            //如果文件后缀名为xls
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            }//如果文件后缀名为xlsx
            else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    public Object getCellFormatValue(Cell cell) {
        Object cellValue = null;

        DecimalFormat df = new DecimalFormat("###########");
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case NUMERIC: {
                    cellValue = df.format(cell.getNumericCellValue());
                    break;
                }
                case FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    public static void main(String[] args) {
//        Workbook wb = null;
//        Sheet sheet = null;
//        Row row = null;
//        List<UserTemp> list = null;
//        //Excel文件路径
//        String filePath = "C:\\Users\\EDZ\\Desktop\\slxmk_user.xls";
//        //读取Excel文件
//        wb = readExcel(filePath);
//        //如果文件不为空
//        if (wb != null) {
//            //用来存放表中数据
//            list = new ArrayList<UserTemp>();
//            //获取第一个sheet
//            sheet = wb.getSheetAt(0);
//            //获取最大行数
//            int rowNum = sheet.getPhysicalNumberOfRows();
//            //获取第一行
//            row = sheet.getRow(0);
//
//            //循环行
//            for (int i = 1; i < rowNum; i++) {
//                row = sheet.getRow(i);
//                if (row != null) {
//                    String untiName = getCellFormatValue(row.getCell(0)).toString();
//                    String nickname1 = getCellFormatValue(row.getCell(1)).toString();
//                    String username1 = new ChangeToPinYin().getStringPinYin(nickname1).replaceAll("\\s+","");
//                    String phone1 = getCellFormatValue(row.getCell(2)).toString();
//                    UserTemp userTemp1 = new UserTemp();
//                    userTemp1.setUnitName(untiName);
//                    userTemp1.setUsername(username1);
//                    userTemp1.setNickname(nickname1);
//                    userTemp1.setPhone(phone1);
//                    userTemp1.setLeader(true);
//                    list.add(userTemp1);
//                    String nickname2 =  getCellFormatValue(row.getCell(3)).toString();
//                    String username2 = new ChangeToPinYin().getStringPinYin(nickname2).replaceAll("\\s+","");
//                    String phone2 = getCellFormatValue(row.getCell(4)).toString();
//                    UserTemp userTemp2 = new UserTemp();
//                    userTemp2.setUnitName(untiName);
//                    userTemp2.setUsername(username2);
//                    userTemp2.setNickname(nickname2);
//                    userTemp2.setPhone(phone2);
//                    userTemp2.setAdmin(true);
//                    list.add(userTemp2);
//                    String nickname3 =  getCellFormatValue(row.getCell(5)).toString();
//                    String username3 = new ChangeToPinYin().getStringPinYin(nickname3).replaceAll("\\s+","");
//                    String phone3 =  getCellFormatValue(row.getCell(6)).toString();
//                    UserTemp userTemp3 = new UserTemp();
//                    userTemp3.setUnitName(untiName);
//                    userTemp3.setUsername(username3);
//                    userTemp3.setNickname(nickname3);
//                    userTemp3.setPhone(phone3);
//                    userTemp3.setDeptmanager(true);
//                    list.add(userTemp3);
//
//                } else {
//                    break;
//                }
//            }
//        }
//        //遍历解析出来的list
//        Map<String,UserTemp> map = new HashMap<>();
//        assert list != null;
//        for (UserTemp userTemp : list) {
//            String phone = userTemp.getPhone();
//            if(map.containsKey(phone)){
//                UserTemp userTemp1 = map.get(phone);
//                userTemp1.setLeader((userTemp.getLeader()!=null&&userTemp.getLeader())?userTemp.getLeader():userTemp1.getLeader());
//                userTemp1.setAdmin((userTemp.getAdmin()!=null&&userTemp.getAdmin())?userTemp.getAdmin():userTemp1.getAdmin());
//                userTemp1.setDeptmanager((userTemp.getDeptmanager()!=null&&userTemp.getDeptmanager())?userTemp.getDeptmanager():userTemp1.getDeptmanager());
//                map.put(phone,userTemp1);
//            }else{
//                map.put(phone,userTemp);
//            }
//        }
//
//        for (UserTemp userTemp:map.values()){
//            System.out.println(userTemp);
//        }
//
    }
}
