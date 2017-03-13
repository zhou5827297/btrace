package com.zhoukai.storm;


import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
public class WordCountTopologyMain {
    public static void main(String[] args) {
        try {
            //定义一个Topology
            TopologyBuilder builder = new TopologyBuilder();
            builder.setSpout("word-reader", new WordReader());
            builder.setBolt("word-normalizer", new WordNormalizer()).shuffleGrouping("word-reader");
            builder.setBolt("word-counter", new WordCounter(), 2).fieldsGrouping("word-normalizer", new Fields("word"));
            //配置
            Config conf = new Config();
            conf.put("wordsFile", "D:/data/1474872667212.txt");
            conf.setDebug(false);

//        conf.put(Config.NIMBUS_HOST,NIMBUS_HOST); //配置nimbus连接主机地址，比如：192.168.10.1
//            conf.put(Config.NIMBUS_THRIFT_PORT, "6627");//配置nimbus连接端口，默认 6627
//            conf.put(Config.STORM_ZOOKEEPER_SERVERS, "192.168.0.50"); //配置zookeeper连接主机地址，可以使用集合存放多个
//            conf.put(Config.STORM_ZOOKEEPER_PORT, "2181"); //配置zookeeper连接端口，默认2181
            //提交Topology
            conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 5000);
            conf.setNumWorkers(3);
            //创建一个本地模式cluster

            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("Getting-Started-Toplogie", conf, builder.createTopology());
            Thread.sleep(10000);
            cluster.killTopology("Getting-Started-Toplogie");
            cluster.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}