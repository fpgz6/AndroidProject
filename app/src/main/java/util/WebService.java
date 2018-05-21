package util;

/**
 * Created by jazzyin on 2016/3/25.
 */

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Entity.Teacher;

public class WebService {
   // private static String IP = "45.76.205.111:8080/OVO";
   private static String IP = "192.168.1.114:8080";
    //把TOMCATURL改为你的服务地址

    /**
     * 通过Get方式获取HTTP服务器数据
     *
     * @return
     */
    public static String executeHttpGet(String url, String action ) {
        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // 用户名 密码
            // URL 地址
            String path = "http://" + IP + "/";
            path = path + url + "?action=" + action;
            Log.e("urlllllllllllll",path);
            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(30000); // 设置超时时间
            conn.setReadTimeout(30000);

            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // 设置获取信息方式
            conn.setRequestProperty("Charset", "UTF-8"); // 设置接收数据编码格式

            Log.e("连接输入完成","11111");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                Log.e("连接200","11111");
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
           // e.printStackTrace();
            Log.e("返回错误原因",e.toString());
        } finally {
            // 意外退出时进行连接关闭保护
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "服务器连接超时...";
    }
    public static String executeHttpGetP1(String url, String action ,String teacher_id) {
        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // 用户名 密码
            // URL 地址
            String path = "http://" + IP + "/";
            path = path + url + "?action=" + action+"&teacher_id="+ teacher_id;
            Log.e("urlllllllllllll",path);
            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(30000); // 设置超时时间
            conn.setReadTimeout(30000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // 设置获取信息方式
            conn.setRequestProperty("Charset", "UTF-8"); // 设置接收数据编码格式

            Log.e("连接输入完成","11111");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                Log.e("连接200","11111");
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 意外退出时进行连接关闭保护
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "服务器连接超时...";
    }
    public static String executeHttpGetP1s(String url, String action ,String student_id) {
        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // 用户名 密码
            // URL 地址
            String path = "http://" + IP + "/";
            path = path + url + "?action=" + action+"&student_id="+ student_id;
            Log.e("urlllllllllllll",path);
            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(30000); // 设置超时时间
            conn.setReadTimeout(30000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // 设置获取信息方式
            conn.setRequestProperty("Charset", "UTF-8"); // 设置接收数据编码格式

            Log.e("连接输入完成","11111");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                Log.e("连接200","11111");
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 意外退出时进行连接关闭保护
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "服务器连接超时...";
    }
    // 将输入流转化为 String 型
    private static String parseInfo(InputStream inStream) throws Exception {
        byte[] data = read(inStream);
        // 转化为字符串
        return new String(data, "UTF-8");
    }

    // 将输入流转化为byte型
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }

    public static String executeHttpGetP3s(String url,String status,String id,String password ) {
        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // 用户名 密码
            // URL 地址
            String path = "http://" + IP + "/";
            path = path + url + "?status="+status+"&id=" + id+"&password="+password;
            Log.e("urlllllllllllll",path);
            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(30000); // 设置超时时间
            conn.setReadTimeout(30000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // 设置获取信息方式
            conn.setRequestProperty("Charset", "UTF-8"); // 设置接收数据编码格式

            Log.e("连接输入完成","11111");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                Log.e("连接200","11111");
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 意外退出时进行连接关闭保护
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "服务器连接超时...";
    }




}
