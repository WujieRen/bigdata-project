package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by renwujie on 2018/05/23 at 16:16
 */
public class TestCreate {

    public static void main(String[] args) throws IOException {
        //test1();
        test2();
    }

    static void test1() throws IOException{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        FileSystem fileSystem = FileSystem.get(conf);
        FSDataOutputStream fsd = fileSystem.create(new Path("/test-hdfs/api/create.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fsd));
        bw.write("用hdfs api测试创建文件");
        bw.newLine();
        bw.write("test creating file with hdfs api");
        bw.close();
        fsd.close();
        fileSystem.close();
    }

    static void test2() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        FileSystem fileSystem = FileSystem.get(conf);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileSystem.create(new Path("/test-hdfs/api/create_1_replication.txt"), (short) 1)));
        bw.write("创建1个副本的文件");
        bw.newLine();
        bw.write("create a file which has one replication");
        bw.close();
        fileSystem.close();
    }
}
