package com.eden.csdn;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.net.URL;
import java.util.List;
@Data
public class TestDataVO {
    @ExcelProperty
    @ColumnWidth(20)
    private String imgUrls;

    @ExcelProperty(value = "图片" ,converter = ExcelUrlConverterUtil.class)
    private List<URL> imgUrlList;

    public TestDataVO(String a, List<URL> list) {
        this.imgUrls=a;
        this.imgUrlList=list;
    }
}
