Sentinel 测试
概念：Sentinel用于监控微服务，作用相当于hystrix


下载地址：https://github.com/alibaba/Sentinel/releases
启动Sentinel
java -jar sentinel-dashboard-1.8.0.jar

控制台网站：http://localhost:8080/#/login
用户名sentinel
密码sentinel

需要注意： 需要先发送请求，sentinel才会有记录，采取迟延策略


1.启动nacos集群
2.启动Jmeter加载配置文件
3.查看限流和降级http://localhost:8080/#/login



热点规则
1.http://localhost:8401/testhotspot?p1=a
当p1=a qps超过1，则输出异常
当设置例外p1!=a QPS即使超过1，也不输出错误



