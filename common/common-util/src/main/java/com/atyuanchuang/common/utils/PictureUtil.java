package com.atyuanchuang.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Anzhi
 * @data 2023/8/26 - 20:58
 */
public class PictureUtil {
    public static String upload(MultipartFile file,Long id) throws Exception{
            String url = MD5.encrypt(id +"");
            //根据创建时间对文件进行重命名
            String fileName = System.currentTimeMillis() + url;
            //上传文件存储的位置
            String destFileName = "D:\\File\\images" + File.separator + fileName;
            //防止改文件夹不存在，创建一个新文件夹
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //将文件存储到该位置
            file.transferTo(destFile);
            return destFileName;
    }

//    public static void main(String[] args) {
//        Long st = new Long(10);
//        System.out.println(st.toString());
//    }
}
