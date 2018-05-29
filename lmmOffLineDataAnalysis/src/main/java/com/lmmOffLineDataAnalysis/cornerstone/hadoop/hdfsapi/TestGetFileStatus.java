package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util.HdfsUtil;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 23:25
 */
public class TestGetFileStatus {
    public static void main(String[] args) throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        FileStatus status = fs.getFileStatus(new Path("/test-hdfs/api/create.txt"));
        System.out.println(status.isDirectory() ? "是文件夹" : "是文件");
        System.out.println("提交时间：" + status.getAccessTime());
        System.out.println("副本数：" + status.getReplication());
        System.out.println("文件大小" + status.getLen());
        System.out.println("最后修改时间：" + status.getModificationTime());
        fs.close();
    }
}
