# Kafka使用及推荐学习路线

### 介绍
Kafka官网文档 https://kafka.apache.org/ (课程总计：31小时)
Kakfa是一个分布式流平台，用于高性能的流水分析。

### 版本 V2.4

### Kafka文档
#### Admin
1. 创建Topic实例
2. 删除Topic实例
3. 获取Topic列表
4. 描述Topic
5. 修改Config
6. 查询Config
7. 增加partition数量
    
#### 消费者
1. 手动提交offset
2. 手动对每个Partition进行提交
3. 手动订阅某个或某些分区，并提交offset
4. 手动指定offset的起始位置，及手动提交offset
5. 流量控制
6. 一个consumer对应多个partion

#### 生产者
1. 异步发送演示
2. 异步阻塞发送演示
3. 异步发送带回调函数
4. 异步发送带回调函数和Partition负载均衡
5. Producer是线程安全的，建议多线程复用。利用spring容器特性创建一个单例模式的producer

#### 流处理
1. 仅作demo演示。不建议使用。


### 学习路线
1.  https://time.geekbang.org/column/intro/100029201 作者:胡夕 (课程时间：5小时)
2.  https://coding.imooc.com/class/434.html 作者:allen  (课程时间：21小时)
3.  https://time.geekbang.org/column/intro/100050101 作者:胡夕 (课程时间：5小时)
4.  https://item.jd.com/12489649.html
5.  https://mp.weixin.qq.com/s/9fOjmpb-KV2dnV2WZbSmoQ (美团技术团队对Kafka的优化)

### 推荐理由
1. 胡夕是Kafka的committer,分别从整体和源码的角度讲解Kafka
2. allen之前就职京东，小米，主要从实战和使用角度讲解Kafka

### 迭代
Kafka集群以及监控,SSL以及最佳实践



