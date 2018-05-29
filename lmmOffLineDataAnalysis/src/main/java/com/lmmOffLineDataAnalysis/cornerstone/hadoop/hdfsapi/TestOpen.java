package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util.HdfsUtil;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by renwujie on 2018/05/29 at 23:00
 */
public class TestOpen {
    public static void main(String[] args) throws IOException {
        test1();
    }

    public static void test1() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        InputStream in = fs.open(new Path("/test-hdfs/api/create.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        in.close();
        fs.close();
    }
}
