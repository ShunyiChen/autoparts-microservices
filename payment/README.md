//查找
http://localhost:8001/payment/get/1
//创建
curl -X POST http://localhost:8001/payment/create  -H "Accept: application/json"  -H "Content-Type: application/json"  -d '{"serial": "test_table123"}'

//访问discovery
http://localhost:8001/payment/discovery

安装zipkin
参考官方文档 https://zipkin.io/pages/quickstart.html

# get the latest source
git clone https://github.com/openzipkin/zipkin
cd zipkin #用git bash打开 
# Build the server and also make its dependencies
./mvnw -DskipTests --also-make -pl zipkin-server clean install
# Run the server
java -jar ./zipkin-server/target/zipkin-server-*exec.jar


打开zipkin dashboard: 
http://127.0.0.1:9411/zipkin/
注意要用chrome浏览器


//单个服务自己刷github
curl -X POST "http://localhost:8001/actuator/refresh"