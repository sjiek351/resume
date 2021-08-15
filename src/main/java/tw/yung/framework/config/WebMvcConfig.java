package tw.yung.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <pre>
 * Web MVC Config 設定
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-07-11
 * @version 2021-07-11 崔永昀
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "tw.yung.*.controller" })
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/dist/");// 訪問資源前綴，指定資源存放的位置
		viewResolver.setSuffix(".html");// 文件後綴名
		viewResolver.setContentType("text/html");// 內容類型
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 設定請求訪問html
		registry.addViewController("/index").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 設定前端資源請求的重新導向
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/views/dist/static/");
	}

}
