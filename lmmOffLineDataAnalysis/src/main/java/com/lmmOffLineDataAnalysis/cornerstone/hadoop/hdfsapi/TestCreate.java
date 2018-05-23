package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/23 at 16:16
 */
public class TestCreate {

    static void test1() throws IOException{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "");
        FileSystem fileSystem = FileSystem.get(conf);
        FSDataOutputStream fsd = fileSystem.create(new Path(""));
    }
}
