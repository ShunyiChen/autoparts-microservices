Hystrix dashboard: http://localhost:9001/hystrix

被监控服务：http://localhost:33475/hystrix.stream



遇到的坑：
HystrixDashboard 监控页面 Unable to connect to Command Metric Stream.

解决方案：
在监控模块的yml中添加
hystrix:
  dashboard:
    proxy-stream-allow-list: "*"

然后在被监控模块的启动类中添加
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);

        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.setUrlMappings(Arrays.asList("/hystrix.stream"));
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
