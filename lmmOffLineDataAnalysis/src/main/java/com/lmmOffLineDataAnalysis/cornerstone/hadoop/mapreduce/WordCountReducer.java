package com.lmmOffLineDataAnalysis.cornerstone.hadoop.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by renwujie on 2018/05/31 at 0:29
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    private LongWritable count = new LongWritable();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
        System.out.println("调用WordCountReducer的setup方法");
    }

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        System.out.println("调用WordCountReducer的reduce方法");
        long sum = 0;
        for(LongWritable value : values) {
            sum += value.get();
        }
        count.set(sum);
        context.write(key, count);
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
        System.out.println("调用WordCountReducer的cleanup方法");
    }
}
