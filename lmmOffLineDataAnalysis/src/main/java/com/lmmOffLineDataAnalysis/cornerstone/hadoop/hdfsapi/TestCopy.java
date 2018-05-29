package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util.HdfsUtil;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 23:30
 */
public class TestCopy {
    public static void main(String[] args) throws IOException {
        testCopyFromLocal();
    }

    static void testCopyFromLocal() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        fs.copyFromLocalFile(new Path("S:/test.txt"), new Path("/test-hdfs/api/copyFromWindows.txt"));
        fs.close();
    }

    static void testCopyToLocal() {
        //略
    }
}
