1.启动alibaba-payment9002,alibaba-payment9003
2.启动alibaba-order84
使用ribbon @LoadBalanced
3.访问http://localhost:84/consumer/fallback/1

fallback管异常
blockHandler管sentinel控制台配置违规，比如超过QPS