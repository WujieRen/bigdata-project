package com.lmmOffLineDataAnalysis.cornerstone.hadoop.mapreduce.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/31 at 0:44
 */
public class HdfsUtil {
    public static boolean deleteFile(String path) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);
            return fs.delete(new Path(path), true);
        } finally {
            if(fs != null)
                fs.close();
        }
    }
}
