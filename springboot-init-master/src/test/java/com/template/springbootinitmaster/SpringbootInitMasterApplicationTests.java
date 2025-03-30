package com.template.springbootinitmaster;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.template.springbootinitmaster.infrastructure.common.core.utils.StringUtils;
import com.template.springbootinitmaster.infrastructure.common.excel.listener.*;
import com.template.springbootinitmaster.infrastructure.common.excel.utils.ExcelUtil;
import com.template.springbootinitmaster.interfaces.vo.AiResourceVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class SpringbootInitMasterApplicationTests {

    @Test
    void contextLoads() {

//            File file = new File("C:\\Users\\zsq\\Desktop\\数据分类.xlsx");
//            InputStream inputStream = null;

//            try {
//                // 创建 FileInputStream
//                inputStream = new FileInputStream(file);
//                // 调用 importExcel 方法
//                EasyExcel.read("C:\\Users\\zsq\\Desktop\\数据分类.xlsx", AiResourceVo.class, new AiResourceListener()).doReadAll();
//
//
//            } catch (IOException e) {
//                e.printStackTrace(); // 处理异常
//            } finally {
//                // 确保 inputStream 关闭以释放资源
//                if (inputStream != null) {
//                    try {
//                        inputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        // 写法1
        try (ExcelReader excelReader = EasyExcel.read("C:\\Users\\zsq\\Desktop\\数据分类指导(3).xlsx").build()) {
            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(AiResourceVo.class).registerReadListener(new AiResourceListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(AiResourceVo.class).registerReadListener(new AiResourceListener1()).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            ReadSheet readSheet3 =
                    EasyExcel.readSheet(2).head(AiResourceVo.class).registerReadListener(new AiResourceListener2()).build();
            ReadSheet readSheet4 =
                    EasyExcel.readSheet(3).head(AiResourceVo.class).registerReadListener(new AiResourceListener3()).build();
            ReadSheet readSheet5 =
                    EasyExcel.readSheet(4).head(AiResourceVo.class).registerReadListener(new AiResourceListener4()).build();
            ReadSheet readSheet6 =
                    EasyExcel.readSheet(5).head(AiResourceVo.class).registerReadListener(new AiResourceListener6()).build();
            excelReader.read(readSheet1, readSheet2, readSheet3, readSheet4, readSheet5, readSheet6);
        }


    }

    @Test
    void test1(){
            List<String>list =  StringUtils.splitList("\\发展中心\\李广临时通知导航学院林珊为小学语文授课\\336", "\\");
        System.out.println(list.get(list.size()-1));
    }

}
