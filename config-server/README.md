1.Generate keypair 
ssh-keygen -t rsa -m PEM

2.Create a git repostory
https://github.com/ShunyiChen/autoparts-config-repo

create two yml files, config-dev.yml and config-test.yml

3.启动eureka

4.启动config server服务

5.打开浏览器看效果
http://config-3344.com:3344/main/config-test.yml

6.通过Bus通知其它服务更改配置，一处更改处处更新(通知全部)
curl -X POST "http://localhost:3344/actuator/bus-refresh"

7.通过Bus通知指定服务更改配置，一处更改处处更新(定点通知)
curl -X POST "http://localhost:3344/actuator/bus-refresh/customer-app:3345"
