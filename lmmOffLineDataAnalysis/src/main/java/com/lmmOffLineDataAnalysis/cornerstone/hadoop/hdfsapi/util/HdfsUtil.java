package com.lmmOffLineDataAnalysis.cornerstone.hadoop.hdfsapi.util;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/29 at 22:56
 */
public class HdfsUtil {
    public static Configuration getConfiguration() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
        return conf;
    }

    public static FileSystem getFileSystem() throws IOException {
        return getFileSystem(getConfiguration());
    }

    public static FileSystem getFileSystem(Configuration configuration) throws IOException {
        return FileSystem.get(configuration);
    }
}
