package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 22:11
 */
public class TestAppend {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        //conf.set("dfs.client.block.write.replace-datanode-on-failure.policy","NEVER");
        //conf.set("dfs.client.block.write.replace-datanode-on-failure.enable","true");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/test-hdfs/api/createNewFile.txt");
        //为啥下面这个不行？？？
        //Path path = new Path("/test-hdfs/api/create.txt");
        FSDataOutputStream fsd = fs.append(path);
        fsd.write("自胜者强".getBytes());
        fsd.close();
        fs.close();
    }
}
