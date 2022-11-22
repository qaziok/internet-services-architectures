package pl.edu.pg.qaziok.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public GatewayApplication(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        String movieUrl = discoveryClient.getInstances("movie").stream()
                .findFirst().map(ServiceInstance::getUri).map(URI::toString).orElseThrow();//("http://localhost:8082");

        String directorUrl = discoveryClient.getInstances("director").stream()
                .findFirst().map(ServiceInstance::getUri).map(URI::toString).orElseThrow();//("http://localhost:8081");

        return builder
                .routes()
                .route("directors", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/directors/{id}", "/api/directors")
                        .uri(directorUrl))
                .route("movies", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/movies", "/api/movies/**", "/api/directors/movies", "/api/directors/{id}/movies", "/api/directors/{id}/movies/**")
                        .uri(movieUrl))
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
