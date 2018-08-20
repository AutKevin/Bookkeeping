package com.autumn.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTool {
    public static void main(String[] args) {
        writeToFile("D:"+File.separator+"autumn"+File.separator+"android.log","123");
    }

    /**
     * 在文件中添加数据
     * @param filePath 文件路径
     * @param data 添加数据
     * @return
     */
    public static String writeToFile(String filePath, String data){
        FileOutputStream out = null;
        try
        {
            //目标文件
            File file=new File(filePath);
            //若不存在即创建文件
            if(!file.exists()) {
                if (!file.getParentFile().exists()) {   //如果父文件夹不存在
                    file.getParentFile().mkdirs();   //新建多层文件夹
                }
                file.createNewFile();
            }
            //创建文件输入流
            out =new FileOutputStream(file,true); //如果追加方式用true
            //写入内容
            StringBuffer sb=new StringBuffer();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append("-----------"+sdf.format(new Date())+"------------\n");
            sb.append(data+"\n");
            //写入
            out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
            return "success";
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }finally {
            try {
                if(out!=null){
                    out.close();   //关闭流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "false";
    }
}
