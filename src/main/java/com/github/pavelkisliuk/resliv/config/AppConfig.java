package com.github.pavelkisliuk.resliv.config;

import com.github.pavelkisliuk.resliv.entity.BotProperty;
import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.entity.ReslivString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("/sql/data.sql"));
		resourceDatabasePopulator.setContinueOnError(true);
		resourceDatabasePopulator.setSqlScriptEncoding("UTF8");
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}

	@Bean
	public BotProperty botProperty() {
		return BotProperty.INSTANCE;
	}

	@Bean
	public ReslivString reslivString() {
		return new ReslivString();
	}

	@Bean
	public Message message() {
		return new Message();
	}

	@Bean
	public City city() {
		return new City();
	}
}