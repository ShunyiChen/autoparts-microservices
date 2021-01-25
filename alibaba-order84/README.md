------------------
ribbon调用
1.启动alibaba-payment9002,alibaba-payment9003
2.启动alibaba-order84
使用ribbon @LoadBalanced
3.访问http://localhost:84/consumer/fallback/1
------------------
fallback管异常
blockHandler管sentinel控制台配置违规，比如超过QPS

------------------
openfeign调用
访问http://localhost:84/consumer/openfeign/1

断开9002
再访问http://localhost:84/consumer/openfeign/1，会出现服务降级信息
------------------
流控持久化(byURL)
描述：停止payment服务后，再重启流控规则依然生效
1.添加
<!--  Alibaba sentinel 持久化用到 -->
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
</dependency>
<!--  Spring cloud Alibaba sentinel -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
2.添加
sentinel:
  transport:
#       配置 sentinel dashboard
    dashboard: localhost:8080
#        默认8719， 如果发现被占用，则自动+1寻找，直到找到端口
    port: 8719
  datasource:
    ds1:
      nacos:
        server-addr: 192.168.1.43:1111
        dataId: alibaba-sentinel-service
        groupId: DEFAULT_GROUP
        data-type: json
        rule-type: flow

3.配置nacos
新建配置dataId： alibaba-sentinel-service，选json
[
    {
    "resource": "/consumer/openfeign/{id}",
    "limitApp": "default",
    "grade": 1,
    "count": 1,
    "strategy": 0,
    "controlBehavior": 0,
    "clusterMode": false
    }
]
参数详细请参考流控持久化.jpg

4.打开sentinel控制台
会自动新增一个流控限制