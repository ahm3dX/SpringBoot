package esprit.DevUp.FoRest.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	private final String moduleName;
	private final String apiVersion;

	public OpenApiConfig(@Value("${application.title}") String moduleName, @Value("${application.version}") String moduleVersion) {
		this.moduleName = moduleName;
		this.apiVersion = moduleVersion;
	}

	@Bean
	public OpenAPI customOpenAPI() {
		final String securitySchemeName = "bearerAuth";
		final String apiTitle = String.format("%s API", StringUtils.capitalize(moduleName));
		return new OpenAPI().addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) .components(
				new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme().name(securitySchemeName).type(SecurityScheme.Type.HTTP)
				.scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title(apiTitle).version(apiVersion));
	}

}