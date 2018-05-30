package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util.HdfsUtil;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 23:11
 */
public class TestDelete {
    public static void main(String[] args) throws IOException {
        //testDelete();
        testDeleteOnExit();
    }

    static void testDelete() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        boolean deleted = fs.delete(new Path("/test-hdfs/api/createNewFile.txt"), true);
        System.out.println(deleted);
        deleted = fs.delete(new Path("/test-hdfs/api/mkdirs"), true);
        //第二个参数是指是否递归删除
        //deleted = fs.delete(new Path("/test-hdfs/api/mkdirs"), false);
        System.out.println(deleted);
        fs.delete(new Path("/test-hdfs/api"), false);
        System.out.println(deleted);
        fs.close();
    }

    static void testDeleteOnExit() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        boolean deleted = fs.delete(new Path("/test-hdfs/api/createNewFile.txt"), true);
        System.out.println("delete方法删除" + deleted);
        deleted = fs.deleteOnExit(new Path("/test-hdfs/api/create.txt"));
        System.out.printf("deleteOnExit方法删除" + deleted);
        System.in.read();
        fs.close();
    }
}
