package com.libei.util;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

@Component
public class ImageCodeUtils {
    private static int width = 90;
    private static int height = 20;
    private static int xx = 15;
    private static int fontHeight = 18;
    private static int codeY = 16;
    private static int number = 30;
    private static SecureRandom random = new SecureRandom();

    public ImageCodeUtils() {
    }

    public static String createCaptcha(char[] code) throws Exception {
        Assert.notNull(code, "传入的验证码不能为空");
        Assert.isTrue(code.length > 0, "传入的验证码的位数不正确");
        BufferedImage buffImg = new BufferedImage(width, height, 1);
        Graphics gd = buffImg.getGraphics();
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
        gd.setFont(new Font("Fixedsys", 1, fontHeight));
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
        gd.setColor(Color.BLACK);

        int red;
        int green;
        int blue;
        int i;
        for(red = 0; red < number; ++red) {
            green = random.nextInt(width);
            blue = random.nextInt(height);
            i = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(green, blue, green + i, blue + yl);
        }

        for(i = 0; i < code.length; ++i) {
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            gd.setColor(new Color(red, green, blue));
            gd.drawString(String.valueOf(code[i]), (i + 1) * xx, codeY);
        }

        return FileCoderUtils.createBase64(buffImg);
    }
}
