
package hello;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@ClientCacheApplication(name = "DataGemFireRestApplication", logLevel = "error")
@EnableGemfireRepositories
@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean("People")
	public ClientRegionFactoryBean<Object, Object> peopleRegion(GemFireCache gemfireCache) {

		ClientRegionFactoryBean<Object, Object> peopleRegion = new ClientRegionFactoryBean<>();

		peopleRegion.setCache(gemfireCache);
		peopleRegion.setClose(false);
		peopleRegion.setShortcut(ClientRegionShortcut.LOCAL);

		return peopleRegion;
	}
}
