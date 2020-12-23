package com.shunyi.autoparts.paymenthystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentAppForHystrix {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAppForHystrix.class, args);
	}

	// 为解决Hystrix Dashboard中Unable to connect to Command Metric Stream问题，该配置需要加在被监控模块启动类中
	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);

		servletRegistrationBean.setLoadOnStartup(1);
		servletRegistrationBean.setUrlMappings(Arrays.asList("/hystrix.stream"));
		servletRegistrationBean.setName("HystrixMetricsStreamServlet");
		return servletRegistrationBean;
	}
}
