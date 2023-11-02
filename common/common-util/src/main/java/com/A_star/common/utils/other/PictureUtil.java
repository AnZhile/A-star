package com.A_star.common.utils.other;

import com.A_star.common.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Anzhi
 * @data 2023/8/26 - 20:58
 */
public class PictureUtil {

    @Value("${file.save.path}")
    String fileSavePath;
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

    public static String base64ToImage(String jpgToBase ,Long id ,String option) {
        String destFileName = null;
        String url = null;
        try {
            //获取Base64，并解码成字节
            byte[] bytes = Base64Utils.decodeFromString(jpgToBase);
            url = MD5.encrypt(id +"");
            //新图片的文件路径
            destFileName = "D:\\File\\images\\" + option + "/" + url + ".png";
            File file = new File(destFileName);
            //判断文件所在目录是否存在，如果不存在，则就创建目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //创建新的图片文件
            file.createNewFile();
            //创建文件输出流
            FileOutputStream fos = new FileOutputStream(file);
            //将字节写入到图片文件中
            fos.write(bytes);
            fos.close();
            System.out.println(true);
        } catch (IOException e) {
            e.printStackTrace();
            Result.fail();
        }
        return option + "\\" + url + ".png";
    }

}
