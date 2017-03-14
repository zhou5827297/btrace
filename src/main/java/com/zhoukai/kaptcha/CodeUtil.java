package com.zhoukai.kaptcha;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhoukai on 2017/3/14.
 * kaptcha 实现验证码
 */
public class CodeUtil {

    public static void main(String[] args) {
        DefaultKaptcha producer = new DefaultKaptcha();

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.image.width", "160");
        properties.setProperty("kaptcha.image.height", "50");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.font.color", "red");
        properties.setProperty("kaptcha.textproducer.font.size", "35");
        properties.setProperty("kaptcha.textproducer.char.space", "3");
        properties.setProperty("kaptcha.textproducer.char.length", "5");
        properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.ChineseTextProducer");

        properties.setProperty("kaptcha.textproducer.font.names", "彩云,宋体,楷体,微软雅黑");

        Config config = new Config(properties);

        producer.setConfig(config);

        String capText = producer.createText();// 为图片创建文本


        BufferedImage bi = producer.createImage(capText); // 创建带有文本的图片


        FileOutputStream out = null;
        try {
            out = new FileOutputStream("d:\\code\\code.jpg");
            ImageIO.write(bi, "jpg", out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
