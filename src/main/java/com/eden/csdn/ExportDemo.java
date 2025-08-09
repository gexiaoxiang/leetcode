package com.eden.csdn;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExportDemo {
    public static void main(String[] args) throws MalformedURLException {
        // 准备测试数据
        List<TestDataVO> dataList = new ArrayList<>();

        // 第一条数据（含2张图片）
        dataList.add(new TestDataVO(
                "A字段内容1",
                Arrays.asList(new File("D:/1.jpg").toURI().toURL(),
                        new File("D:/2.jpeg").toURI().toURL(),
                        new File("D:/4.jpeg").toURI().toURL(),
                        new File("D:/5.jpg").toURI().toURL(),
                        new File("D:/6.jpeg").toURI().toURL()

                ) // 图片本地路径
        ));

        // 第二条数据（含1张图片）
        dataList.add(new TestDataVO(
                "A字段内容2",
                Arrays.asList(new File("D:/3.jpg").toURI().toURL())
        ));

        dataList.add(new TestDataVO(
                "33333",
                Arrays.asList()
        ));
        // 构建写入器并确保资源正确释放
        ExcelWriterBuilder writerBuilder = EasyExcel.write("D:1.xlsx", TestDataVO.class);
        ExcelWriterSheetBuilder sheetBuilder = writerBuilder.sheet("数据sheet");

        // 注册处理器
        sheetBuilder.registerConverter(new ExcelUrlConverterUtil());
        sheetBuilder.registerWriteHandler(new CustomImageModifyHandler());

        // 执行写入
        sheetBuilder.doWrite(dataList);
        System.out.println("导出完成，文件路径：" + new File("D:1.xlsx").getAbsolutePath());
    }
}
    