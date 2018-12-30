package com.mingqian.service.mallUser;

import com.mingqian.dao.mall.mapper.MallUserEntityMapper;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.base.PageBeanUtils;
import com.mingqian.domain.mybatis.entity.MallUserEntity;
import com.mingqian.domain.vo.mallUser.MallUserParamVo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanggang on 2018/12/30.
 */
@Service("mallUserService")
public class MallUserServiceImpl implements  MallUserService {

    private final String SHEET_NAME = "会员信息";


    @Autowired
    private MallUserEntityMapper mallUserEntityMapper;
    /**
     * 获取会员列表
     *
     * @param paramVo
     * @return
     */
    @Override
    public PageBean<MallUserEntity> queryMallUserList(MallUserParamVo paramVo) {
        List<MallUserEntity> list = mallUserEntityMapper.selectMallUserList(paramVo);
        Integer sum = mallUserEntityMapper.selectMallUserListCount(paramVo);
        return PageBeanUtils.make(list, sum);
    }

    /**
     * 导出excel查询会员
     *
     * @param paramVo
     * @return
     */
    @Override
    public List<MallUserEntity> queryMallUserExcel(MallUserParamVo paramVo) {
        return mallUserEntityMapper.selectMallUserExcel(paramVo);
    }

    /**
     * 导出excel
     *
     * @param mallUserEntities
     * @return
     */
    @Override
    public Workbook exportExcel(List<MallUserEntity> mallUserEntities) {
        String[] headers = new String[]{"会员名称", "身份证号", "地址", "毕业学校", "专业"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        Sheet sheet = workbook.createSheet(SHEET_NAME);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 25);
        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        // 遍历集合数据，产生数据行
        if(mallUserEntities.size() > 0){
            for(int i = 0; i < mallUserEntities.size(); i++){
                MallUserEntity mallUserEntity = mallUserEntities.get(i);
                row = sheet.createRow(i + 1);
                Cell cell = row.createCell(0);
                HSSFRichTextString text = new HSSFRichTextString(mallUserEntity.getUserName());
                cell.setCellValue(text);
                cell = row.createCell(1);
                cell.setCellValue(mallUserEntity.getUserCard());
                cell = row.createCell(2);
                cell.setCellValue(mallUserEntity.getUserAddress());
                cell = row.createCell(3);
                cell.setCellValue(mallUserEntity.getUserSchool());
                cell = row.createCell(4);
                cell.setCellValue(mallUserEntity.getUserSpecialty());
            }
        }
        return workbook;
    }
}
