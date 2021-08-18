package tw.yung.framework.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * 配置Bean
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-07-11
 * @version 2021-07-11 崔永昀
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan({ "tw.yung.framework.aop", "tw.yung.*.controller", "tw.yung.*.service", "tw.yung.*.dao" })
@PropertySource("classpath:main.properties")
public class WebRootConfig {

	@Value("${dataSource.javaconfig.jndiName}")
	private String configJndiName;

	/**
	 * <pre>
	 * 使用JNDI DataSource
	 * </pre>
	 *
	 * @since 2021-08-06 崔永昀
	 */
	@Bean
	@Primary
	public DataSource getDataSource() {
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		return lookup.getDataSource(configJndiName);
	}

	/**
	 * <pre>
	 * JDBCTemplate 注入DataSource
	 * </pre>
	 *
	 * @since 2021-08-07 崔永昀
	 */
	@Bean
	@Primary
	public JdbcTemplate jdbcTemplate() throws IllegalArgumentException {
		return new JdbcTemplate(getDataSource());
	}
	
    /**
     * <pre>
     * 事務管理器 注入DataSource
     * </pre>
     *
     * @since 2021-08-18 崔永昀
     */
    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(getDataSource());
    }

}
