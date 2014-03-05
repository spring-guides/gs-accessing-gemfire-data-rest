
package hello;

import com.gemstone.gemfire.cache.GemFireCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableGemfireRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application {

	@Bean
	CacheFactoryBean cacheFactoryBean() {
		return new CacheFactoryBean();
	}

	@Bean
	LocalRegionFactoryBean<String, Person> localRegionFactory(final GemFireCache cache) {
		return new LocalRegionFactoryBean<String, Person>() {{
			setCache(cache);
			setName("hello");
		}};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
