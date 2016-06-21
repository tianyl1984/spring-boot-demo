package com.tianyl.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Bean(name = "ds1DataSource")
	@Qualifier("ds1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.ds1")
	@Primary
	public DataSource leidaDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ds2DataSource")
	@Qualifier("ds2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.ds2")
	public DataSource payDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ds3DataSource")
	@Qualifier("ds3DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.ds3")
	public DataSource mallDataSource() {
		return DataSourceBuilder.create().build();
	}

}
