package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 22:16
 */
public class TestCreateNewFile {
    public static void main(String[] args) throws IOException {
        test1();
        //test2();
    }

    /**
     * 使用绝对路径
     * @throws IOException
     */
    private static void test1() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        FileSystem fs = FileSystem.get(conf);
        boolean created = fs.createNewFile(new Path("/test-hdfs/api/createNewFile.txt"));
        System.out.println(created ? "创建成功" : "创建失败");
        fs.close();
    }

    /**
     * 使用相对路径
     * @throws IOException
     */
    private static void test2() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        FileSystem fs = FileSystem.get(conf);
        //相对路径默认是/user/username/
        boolean created = fs.createNewFile(new Path("createNewFile2.txt"));
        System.out.println(created);
        fs.close();
    }
}
