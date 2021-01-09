
关于nacos spring cloud配置说明
https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html


关于Nacos 集群
两台linux虚拟机 + 1台Windows10，构建1nginx + 3个naocs集群
一个mysql 数据库,手动执行官方sql脚本nacos-mysql.sql
一个nginx 代理

1.配置192.168.1.106（Windows）: 
**1.1 修改mysql配置**
打开nacos/conf/application.properties 修改：
#*************** Config Module Related Configurations ***************#
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://192.168.1.43:33061/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=cDe3@wsx

**1.2 添加cluster.conf**
新建nacos/conf/cluster.conf，添加内容如下：
#2021-01-10T03:19:21.369
192.168.1.105:8848
192.168.1.106:8848
192.168.1.43:8848

**1.3 启动nacos**
Windows:  ./startup.cmd
Linux: sh /usr/shunyi/nacos/bin/startup.sh


2.配置192.168.1.106（Linux）:
与1都同一套路配置
3.配置192.168.1.43（Linux）:
与1都同一套路配置

4.配置Nginx
**4.1 修改nginx.conf配置**
cd /usr/local/nginx/conf/
改：
server {
    listen       1111;
加：
upstream cluster{
    server 192.168.1.106:8848;
    server 192.168.1.105:8848;
    server 192.168.1.43:8848;
}
改：
location / {
    #shunyi
    #proxy_pass http://100.98.102.43:8090;
    #root   html;
    #index  index.html index.htm;
    proxy_pass http://cluster;
}

**4.2 启动nginx**
cd /usr/local/nginx/sbin
./nginx -c /usr/local/nginx/conf/nginx.conf


5.访问nginx入口网址
192.168.1.43:1111/nacos
测试新增一个配置到配置列表，检查数据库是否有新纪录插入。

6.注册微服务到nacos集群
需要在client 服务中yaml修改如下
nacos:
discovery:
    server-addr: 192.168.1.43:1111
  config:
    server-addr: 192.168.1.43:1111
    file-extension: yaml
    group: DEV_GROUP # 设置不同分组
    namespace: 15c59e93-82c5-4f3a-96ba-378f5678ea9a

访问http://localhost:3377/config/info 检查该服务是否在nacos注册成功