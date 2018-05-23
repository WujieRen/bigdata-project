# 基础知识准备
1. Linux + Java
2. Hadoop
    - 安装
      - hdfs部分
        - 1 <a href="http://archive.apache.org/dist/hadoop/core/">下载hadoop</a>，并解压至相应目录。（建议删掉$HADOOP_HOME/share/doc目录）
        - 2 指定JAVA_HOME，包括以下文件
          - $HADOOP_HOME/etc/hadoop/hdfs-env.sh
          - $HADOOP_HOME/etc/hadoop/mapred-env.sh
          - $HADOOP_HOME/etc/hadoop/yarn-env.sh
        - 3 $HADOOP_HOME/etc/hadoop/core-site.xml：
          - 指定默认文件系统和访问端口 & 覆盖hadoop生成临时文件的目录
            ```xml
                 <property>
                        <name>fs.defaultFS</name>
                        <value>hdfs://sparkproject1:8020</value>
                </property>
                <property>
                        <name>hadoop.tmp.dir</name>
                        <value>/opt/lmm/hadoop-2.9.0/tmp</value>
                </property>
            ```
        - 4 $HADOOP_HOME/etc/hadoop/hdfs-site.xml：
          - 指定副本个数
              ```xml
                   <property>
                           <name>dfs.replication</name>
                           <value>1</value>
                   </property>
              ```
        - 5 $HADOOP_HOME/etc/hadoop/slaves：
          - 添加datanode所在的机器的hostname
        - 6 格式化hdfs
            ```sbtshell
            $HADOOP_HOME/bin/hdfs -format 
            ```
        - 7 测试。可以创建目录，上传文件等。 
          - 浏览器查看：hostname:50070
      - mapreduce部分
        - 1 mapred-site.xml
          - mapreduce设置运行在yarn上
            ```xml
                <property>
                    <name>mapreduce.framework.name</name>
                    <value>yarn</value>
                </property>
            ```
        - 2 yarn-site.xml
          - NodeManager上运行的附属服务。需配置成mapreduce_shuffle，才可运行MapReduce程序。
            ```xml
            <property>
                <name>yarn.nodemanager.aux-services</name>
                <value>mapreduce_shuffle</value>
            </property>
            ```
          > reference: http://dongxicheng.org/mapreduce-nextgen/hadoop-yarn-configurations-resourcemanager-nodemanager/
          - 指定ResourceManager主节点机器
            ```xml
            <property>
                <name>yarn.resourcemanager.hostname</name>
                <value>sparkproject1</value>
            </property>
            ```
        - 3 启动 & 测试（运行一个mapreduce任务）
          - 浏览器查看：hostname:8088
    - hdfs相关命令
    - hdfs架构
    - hdfsJavaAPI
    - MapReduce原理及demo
3. HBase
4. Hive
5. Nginx
6. Flume
7. Sqoop
8. Oozie
9. Highcharts
