package com.libei.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCoderUtils {
    private static final Logger log = LoggerFactory.getLogger(FileCoderUtils.class);

    public FileCoderUtils() {
    }

    public static InputStream createInputStream(String fileBase64) throws Exception {
        Assert.notNull(fileBase64, "传入的文件内容不能为空");

        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(fileBase64);
            return new ByteArrayInputStream(bytes);
        } catch (IOException var3) {
            throw new Exception("base64格式文件转inputStream异常", var3);
        }
    }

    public static String createBase64(InputStream in) throws Exception {
        byte[] buff = new byte[100];
        boolean var2 = false;

        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            Throwable var4 = null;

            String var5;
            try {
                int rc;
                while ((rc = in.read(buff, 0, 100)) > 0) {
                    swapStream.write(buff, 0, rc);
                }

                var5 = new String(Base64.encodeBase64(swapStream.toByteArray()));
            } catch (Throwable var15) {
                var4 = var15;
                throw var15;
            } finally {
                if (swapStream != null) {
                    if (var4 != null) {
                        try {
                            swapStream.close();
                        } catch (Throwable var14) {
                            var4.addSuppressed(var14);
                        }
                    } else {
                        swapStream.close();
                    }
                }

            }

            return var5;
        } catch (IOException var17) {
            throw new Exception("inputStream格式文件转base64异常");
        }
    }

    public static String createBase64(RenderedImage image) throws Exception {
        Assert.notNull(image, "传入图像文件不能为空");
        ByteArrayOutputStream out = null;

        String var3;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);
            out.flush();
            byte[] picBytes = out.toByteArray();
            var3 = Base64Utils.encodeToString(picBytes);
        } catch (IOException var12) {
            throw new Exception("图片转base64异常", var12);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException var11) {
                    log.warn("文件流关闭异常", var11);
                }
            }

        }

        return var3;
    }
}

