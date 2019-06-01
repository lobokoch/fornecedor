package br.com.kerubin.api.cadastros.fornecedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import br.com.kerubin.api.database.core.ServiceContext;

@SpringBootApplication(
		exclude = { 
		        DataSourceAutoConfiguration.class,
		        HibernateJpaAutoConfiguration.class,
		        DataSourceTransactionManagerAutoConfiguration.class
		}
		, scanBasePackages = { "br.com.kerubin.api" }
)

@EnableEurekaClient
public class CadastrosFornecedorApplication {

	public static void main(String[] args) {
		init();
		SpringApplication.run(CadastrosFornecedorApplication.class, args);
	}
	
	private static void init() {
		ServiceContext.setDefaultDomain(CadastrosFornecedorConstants.DOMAIN);
		ServiceContext.setDefaultService(CadastrosFornecedorConstants.SERVICE);
		// ServiceConnectionProvider.INSTANCE.setMigrateDefaultTenant(true);
	}
}
