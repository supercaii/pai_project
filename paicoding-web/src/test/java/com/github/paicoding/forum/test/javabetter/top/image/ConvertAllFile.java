package com.github.paicoding.forum.test.javabetter.top.image;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 微信搜索「沉默王二」，回复 Java
 *
 * @author 沉默王二
 * @date 4/30/22
 */
@Slf4j
public class ConvertAllFile {
    public static final String img_url_pre_before = "https://cdn.jsdelivr.net/gh/itwanger/toBeBetterJavaer/images/";
    private final static String img_url_pre_after = "http://cdn.tobebetterjavaer.com/tobebetterjavaer/images/images/";
    private final static String docPath = "/Users/maweiqing/Documents/GitHub/toBeBetterJavaer/docs/";

    public static void main(String[] args) throws IOException {
        // 递归遍历目录以及子目录中的所有文件
        List<File> files = FileUtil.loopFiles(docPath);
        for (File file: files) {
            FileReader fileReader = FileReader.create(file,Charset.forName("utf-8"));
            String result = fileReader.readString().replaceAll(img_url_pre_before,img_url_pre_after);
            log.info("转换后{}",result);

            FileWriter writer = new FileWriter(file);
            writer.write(result);
            writer.flush();
        }
    }
}
