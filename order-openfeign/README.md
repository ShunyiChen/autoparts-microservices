//获取
curl -X GET "http://localhost:33484/consumer/payment/get/26"
//创建
curl -X GET "http://localhost:33484/consumer/payment/create?serial=openfeigh123"

// feign timeout, 默认timeout是1秒
http://localhost:33484/consumer/payment/feign/timeout

//feign 日志级别，输出更详细得http 协议头，体的信息
