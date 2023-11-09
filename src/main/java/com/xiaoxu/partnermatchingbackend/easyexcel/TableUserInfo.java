package com.xiaoxu.partnermatchingbackend.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TableUserInfo {
    /**
     * id
     */
    @ExcelProperty("成员编号")
    private String userAccount;

    /**
     * 用户昵称
     */
    @ExcelProperty("成员昵称")
    private String username;
}