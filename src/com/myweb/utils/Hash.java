package com.myweb.utils;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import java.io.UnsupportedEncodingException;

import sun.misc.*;

public class Hash {
    /**
     * 生成32位md5码
     *
     * @param password
     * @return
     */
    public static String md5(String password) {
        try {
            //得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            //把每一个byte 做一个与运算 0xff;
            for (byte b : result) { // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            //标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * base64加密
     *
     * @param password
     * @return
     */
    public static String toBase64(String password) {
        byte[] b = null;
        String s = null;
        try {
            b = password.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * base64解密
     *
     * @param password
     * @return
     */
    public static String fromBase64(String password) {
        byte[] b = null;
        String result = null;
        if (password != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(password);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
