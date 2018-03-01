
package hello;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class,
	clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
