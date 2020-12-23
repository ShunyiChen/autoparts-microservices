//查找
http://localhost:3347/payment/get/25
//创建
curl -X POST http://localhost:3347/payment/create  -H "Accept: application/json"  -H "Content-Type: application/json"  -d '{"serial": "test_table123"}'


//访问discovery
http://localhost:3347/payment/discovery


演示 Hystrix 服务降级 断熔