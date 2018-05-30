package com.lmmOffLineDataAnalysis.cornerstone.hadoop.mapreduce;

import com.lmmOffLineDataAnalysis.cornerstone.hadoop.mapreduce.util.HdfsUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by renwujie on 2018/05/31 at 0:35
 */
public class WordCountRunner implements Tool{

    private Configuration conf = null;

    @Override
    public int run(String[] args) throws Exception {
        Configuration configuration = this.getConf();
        Job job = Job.getInstance(configuration);
        //1.input
        FileInputFormat.addInputPath(job, new Path("/test-hdfs/api/"));
        //2.map
        job.setMapperClass(WordcountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        //3.shuffler
        //4.reduce
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //5.output
        HdfsUtil.deleteFile("/test-hdfs/wordcount/1");
        FileOutputFormat.setOutputPath(job, new Path("/test-hdfs/wordcount/1"));
        return job.waitForCompletion(true) ? 0 : 1;
    }

    @Override
    public void setConf(Configuration that) {
        this.conf = that;
        this.conf.set("fs.defaultFS", "hdfs://sparkproject1:8020");
    }

    @Override
    public Configuration getConf() {
        return this.conf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ToolRunner.run(new WordCountRunner(), args));
    }
}
