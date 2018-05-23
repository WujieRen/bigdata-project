# 基础知识准备
1. Linux + Java
2. Hadoop
    - 安装
      - HDFS部分
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
        - 6 格式化HDFS
            ```sbtshell
            $HADOOP_HOME/bin/hdfs -format 
            ```
        - 7 测试。可以创建目录，上传文件等。 
          - 浏览器查看：sparkproject1:50070
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
          - 浏览器查看：sparkproject1:8088
      - SecondaryNameNode
        - hdfs-site.xml
        ```xml
        <property>
            <name>dfs.namenode.secondary.http-address</name>
            <value>sparkproject1:50090</value>
        </property>
        ```
        - 外部UI界面访问： sparkprojet1:50090
      - MapReduce自带历史服务器
        - mapred-site.xml
        ```xml
        <property>
            <name>mapreduce.jobhistory.address</name>
            <value>sparkproject1:10020</value>
        </property>
        <property>
            <name>mapreduce.jobhistory.webapp.address</name>
            <value>sparkproject1:19888</value>
        </property>
        ```
        - 启动
        ```sbtshell
        $ sbin/mr-jobhistory-daemon.sh start historyserver
        ```
      - 日志聚合，开启并指定保存期限
        - yarn-site.xml
        ```xml
        <property>
            <name>yarn.log-aggregation-enable</name>
            <value>true</value>
        </property>
        <property>
            <name>yarn.log-aggregation.retain-seconds</name>
            <value>106800</value>
        </property>
        <!-- 另外，yarn.nodemanager.remote-app-log-dir代表日志转移到HDFS上的目录路径。
                1.默认路径：/tmp/logs
                2.可用户自定义
        -->
        ```
      - HDFS文件权限检测
        - HDFS的文件目录权限和Linux文件目录权限是一样的
        - hdfs-site.xml
        ```xml
        <!-- 关闭用户权限检测 -->
        <property>
            <name>dfs.permissions.enabled</name>
            <value>false</value>
        </property>
        <!-- 指定Hadoop的http静态用户名，可配置项 -->
        <property>
            <name>hadoop.http.staticuser.user</name>
            <value>renwujie</value>
        </property>
        ```
      - 总结：
        - 配置完历史服务器和日至聚合后需要重启HDFS的所有进程。
        - 启动过程注意先启动HDFS在启动yarn。
    - HDFS相关命令
    - HDFS架构
    - HDFSJavaAPI
      - 第一个例子就遇到个问题：
      ```sbtshell
      java.lang.NoClassDefFoundError: org/apache/hadoop/fs/FSDataOutputStream
      ...
      Caused by: java.lang.ClassNotFoundException: org.apache.hadoop.fs.FSDataOutputStream
      ...
      ```
      - 原因：依赖的问题。（王鑫说找不到包通常和依赖相关，比如依赖冲突等）
          ```xml
          <dependency>
              <groupId>org.apache.hadoop</groupId>
              <artifactId>hadoop-common</artifactId>
              <version>${hadoop.version}</version>
              <scope>provided</scope>
          </dependency>
          ```
      - 解决：去掉上述依赖中的<scope>provided</scope>即可。
      - 这也促使我去了解了下<a href="https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html  ">scope</a>  
      > reference1: https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html  
      reference2: http://ifeve.com/maven-dependency-mechanism/  
    - MapReduce原理及demo
3. HBase
4. Hive
5. Nginx
6. Flume
7. Sqoop
8. Oozie
9. Highcharts
