package com.example.demo.service.impl;

import com.example.demo.entity.UserTemp;
import com.example.demo.mapper.UserTempMapper;
import com.example.demo.service.IUserTempService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.utils.ChangeToPinYin;
import com.example.demo.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户临时表 服务实现类
 * </p>
 *
 * @author 董鑫
 * @since 2019-10-30
 */
@Service("userTempServiceImpl")
public class UserTempServiceImpl extends ServiceImpl<UserTempMapper, UserTemp> implements IUserTempService {

    @Resource
    private ChangeToPinYin changeToPinYin;
    @Resource
    private ExcelUtil excelUtil;

    @Override
    public void saveUserList(String filePath) {
        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<UserTemp> list = null;
        //读取Excel文件
        wb = excelUtil.readExcel(filePath);
        //如果文件不为空
        if (wb != null) {
            //用来存放表中数据
            list = new ArrayList<UserTemp>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rowNum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);

            //循环行
            for (int i = 1; i < rowNum; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    String untiName = excelUtil.getCellFormatValue(row.getCell(0)).toString();
                    String nickname1 = excelUtil.getCellFormatValue(row.getCell(1)).toString();
                    String username1 = changeToPinYin.getStringPinYin(nickname1).replaceAll("\\s+","");
                    String phone1 = excelUtil.getCellFormatValue(row.getCell(2)).toString();
                    UserTemp userTemp1 = new UserTemp();
                    userTemp1.setUnitName(untiName);
                    userTemp1.setUsername(username1);
                    userTemp1.setNickname(nickname1);
                    userTemp1.setPhone(phone1);
                    userTemp1.setLeader(true);
                    list.add(userTemp1);
                    String nickname2 =  excelUtil.getCellFormatValue(row.getCell(3)).toString();
                    String username2 = changeToPinYin.getStringPinYin(nickname2).replaceAll("\\s+","");
                    String phone2 = excelUtil.getCellFormatValue(row.getCell(4)).toString();
                    UserTemp userTemp2 = new UserTemp();
                    userTemp2.setUnitName(untiName);
                    userTemp2.setUsername(username2);
                    userTemp2.setNickname(nickname2);
                    userTemp2.setPhone(phone2);
                    userTemp2.setAdmin(true);
                    list.add(userTemp2);
                    String nickname3 =  excelUtil.getCellFormatValue(row.getCell(5)).toString();
                    String username3 = changeToPinYin.getStringPinYin(nickname3).replaceAll("\\s+","");
                    String phone3 =  excelUtil.getCellFormatValue(row.getCell(6)).toString();
                    UserTemp userTemp3 = new UserTemp();
                    userTemp3.setUnitName(untiName);
                    userTemp3.setUsername(username3);
                    userTemp3.setNickname(nickname3);
                    userTemp3.setPhone(phone3);
                    userTemp3.setDeptmanager(true);
                    list.add(userTemp3);

                } else {
                    break;
                }
            }
        }
        //遍历解析出来的list
        Map<String,UserTemp> map = new HashMap<>();
        assert list != null;
        for (UserTemp userTemp : list) {
            String phone = userTemp.getPhone();
            if(map.containsKey(phone)){
                UserTemp userTemp1 = map.get(phone);
                userTemp1.setLeader((userTemp.getLeader()!=null&&userTemp.getLeader())?userTemp.getLeader():userTemp1.getLeader());
                userTemp1.setAdmin((userTemp.getAdmin()!=null&&userTemp.getAdmin())?userTemp.getAdmin():userTemp1.getAdmin());
                userTemp1.setDeptmanager((userTemp.getDeptmanager()!=null&&userTemp.getDeptmanager())?userTemp.getDeptmanager():userTemp1.getDeptmanager());
                map.put(phone,userTemp1);
            }else{
                map.put(phone,userTemp);
            }
        }
        List<UserTemp> userTempList = new ArrayList<>(map.values());
        saveBatch(userTempList);
    }
}
