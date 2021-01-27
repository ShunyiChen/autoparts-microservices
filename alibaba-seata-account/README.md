seata 1.4.0 配置参考
https://www.cnblogs.com/bestlmc/p/14315180.html（DEFAULT_GROUP应该改成SEATA_GROUP）
https://www.jianshu.com/p/bca866390a77

配置步骤
1.config.txt放入seata目录下
config.txt
下载地址：https://github.com/seata/seata/blob/develop/script/config-center/config.txt

2.nacos-config.sh放入seata/conf
nacos-config.sh
下载地址：https://github.com/seata/seata/blob/develop/script/config-center/nacos/nacos-config.sh
2.1 cd seata/conf
2.2 sh nacos-config.sh -h 127.0.0.1

3.启动seata服务，直接双击seata-server.bat

4.微服务
pom添加:
<!--       seata -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>io.seata</groupId>
                    <artifactId>seata-all</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>io.seata</groupId>
            <artifactId>seata-all</artifactId>
            <version>1.4.0</version>
        </dependency>

application.yml添加:
````
seata:
  enabled: true
  application-id: ${spring.application.name}
  enable-auto-data-source-proxy: false
  tx-service-group: SEATA_GROUP
  service:
    vgroupMapping:
      SEATA_GROUP: default
  config:
    type: nacos
    nacos:
      server-addr: 127.0.0.1:8848
      group : "SEATA_GROUP"
      namespace: ""
      username: "nacos"
      password: "nacos"
  registry:
    type: nacos
    nacos:
      server-addr: 127.0.0.1:8848
      namespace: ""
      group: SEATA_GROUP
      cluster: default
​
feign:
  hystrix:
    enabled: false
​
logging:
  level:
    io:
      seata: info
````

