package cn.huizhi.util;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

public class DataBaseUtils {
	Log loger = LogFactory.getLog(this.getClass());
	 
    private String HOSTIP = "127.0.0.1";//数据库服务器IP
    private String USERNAME = "root";//数据库用户
    private String PASSWORD = "root";//数据库密码
    private String SAVEPATH = "/root/stup/mysqlbase/";//备份文件路径
    /**
     * 每隔xxx时间就执行，暂定每天0点
     */
    public  boolean dbbackup() {
        loger.debug("数据库备份开始");
        String[] databaseName = {"traininginstitutions"};
        String dates = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        String dated = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        System.out.println(dates);
        System.out.println(dated);
        for (Object o : databaseName) {
            String savePath=SAVEPATH + "/" + dated;
            String fileName =  o.toString() + dates+".sql";
            System.out.println(SAVEPATH + "/" + dated + "/" + o.toString() + dates+".sql");
           return exportDatabaseTool(HOSTIP, USERNAME, PASSWORD, savePath,fileName, o.toString());
        }
        return false;
    }
 
 
    public boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath,String fileName, String databaseName) {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump")/*.append(" --opt")*/.append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password).append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath+fileName).append(" --default-character-set=utf8 ").append(databaseName);
        try {
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                loger.info("数据库备份成功");
                return true;
            }
        } catch (IOException e) {
            loger.info("数据库备份异常");
            e.printStackTrace();
        } catch (InterruptedException e) {
            loger.info("数据库备份异常");
            e.printStackTrace();
        }
        
        return false;
    }

	
}
