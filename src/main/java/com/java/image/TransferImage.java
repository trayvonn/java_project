package com.java.image;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;

/**
 * @author 吴邪
 * @date 2020/12/11 10:01
 */
public class TransferImage {


    private static final String PATH = "/Users/trayvonn/Downloads";

    private static final String[] LEGAL_EXT = {"jpg", "jpeg", "png"};

    public static void main(String[] args) {

        File directory = new File(PATH);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles(file -> !file.isDirectory()&& ArrayUtil.contains(LEGAL_EXT, file.getName().split("\\.")[1]));
            if (files == null) {
                return;
            }
            for (File file : files) {
                File target = new File(PATH + "/" + System.currentTimeMillis() + ".gif");
                ImgUtil.convert(file, target);
                System.out.println(file.delete());
            }
        }

    }
}
