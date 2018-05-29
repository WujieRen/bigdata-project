package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util.HdfsUtil;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 23:08
 */
public class TestMKdirs {
    public static void main(String[] args) throws IOException {
        testMkDirs();
    }

    static void testMkDirs() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        boolean created = fs.mkdirs(new Path("/test-hdfs/api/mkdirs"));
        System.out.println(created);
        fs.close();
    }
}
