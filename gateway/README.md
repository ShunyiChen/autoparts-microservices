payment 服务2，用于测试负载均衡

//测试Predicate 断言各种限制
curl -u username:123 http://localhost:9527/payment/get/1?username=1 --cookie "username=123" -H "X-Request-Id:1"

Predicate详细参照:
https://blog.csdn.net/qq_41922608/article/details/108919075

//测试Filter
curl -u username:123 http://localhost:9527/payment/get/1?username=1\&uname=c --cookie "username=123" -H "X-Request-Id:1"
