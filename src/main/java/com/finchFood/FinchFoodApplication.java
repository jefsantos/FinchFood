package com.finchFood;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.finchFood.model.IngredienteModel;
import com.finchFood.model.LancheModel;
import com.finchFood.repository.IngredienteRepository;
import com.finchFood.repository.LancheRepository;



@SpringBootApplication
@ComponentScan("com.finchFood.services, com.finchFood.controllers")
public class FinchFoodApplication implements CommandLineRunner {
	


	@Autowired
	IngredienteRepository ingredienteRepository;

	@Autowired
	LancheRepository lancheRepository;


	public static void main(String[] args) {
		SpringApplication.run(FinchFoodApplication.class, args);

	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsXFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	@Override
	public void run(String... args) throws Exception {
		
		{
			
			LancheModel Xbacon = new LancheModel(null, "Xbacon");
			LancheModel Xburguer = new LancheModel(null, "Xburguer");
			LancheModel Xegg = new LancheModel(null, "Xegg");
			LancheModel XeggBacon = new LancheModel(null, "XeggBacon");
			LancheModel Xlight = new LancheModel(null, "Xlight");
			
			LancheModel XTestaMuitaCarne = new LancheModel(null, "XTestaMuitaCarne");
			LancheModel XTestaMuitoQueijo = new LancheModel(null, "XTestaMuitoQueijo");
			
			

			IngredienteModel alface = new IngredienteModel(null, "alface", 0.40);
			IngredienteModel bacon = new IngredienteModel(null, "bacon", 2.00);
			IngredienteModel hamburguer = new IngredienteModel(null, "hamburguer", 3.00);
			IngredienteModel ovo = new IngredienteModel(null, "ovo", 0.80);
			IngredienteModel queijo = new IngredienteModel(null, "queijo", 1.50);

			
			

			Xbacon.getIngredientes().addAll(Arrays.asList(hamburguer, queijo, bacon, alface));
			Xburguer.getIngredientes().addAll(Arrays.asList(hamburguer, queijo));
			Xegg.getIngredientes().addAll(Arrays.asList(ovo, hamburguer, queijo ));
			XeggBacon.getIngredientes().addAll(Arrays.asList(ovo,bacon,hamburguer,queijo));
			Xlight.getIngredientes().addAll(Arrays.asList(hamburguer, queijo, alface));
			
			XTestaMuitaCarne.getIngredientes().addAll(Arrays.asList(hamburguer, hamburguer, hamburguer));
			XTestaMuitoQueijo.getIngredientes().addAll(Arrays.asList(queijo, queijo, queijo));
			
			bacon.getLanches().addAll(Arrays.asList( XeggBacon, Xbacon));
			hamburguer.getLanches().addAll(Arrays.asList(Xbacon, Xburguer, Xegg,XeggBacon,Xlight, XTestaMuitaCarne, XTestaMuitaCarne,XTestaMuitaCarne));
			ovo.getLanches().addAll(Arrays.asList(Xegg, XeggBacon));
			queijo.getLanches().addAll(Arrays.asList(Xbacon, Xburguer, Xegg,XeggBacon, Xlight, XTestaMuitoQueijo, XTestaMuitoQueijo, XTestaMuitoQueijo));
			alface.getLanches().addAll(Arrays.asList(Xlight, Xbacon));
			
			
			
			
			
			lancheRepository.saveAll(Arrays.asList(Xbacon, Xburguer, Xegg,XeggBacon, Xlight, XTestaMuitaCarne, XTestaMuitoQueijo));
			
			ingredienteRepository.saveAll(Arrays.asList(ovo,bacon,hamburguer,queijo, alface));
			
			
			
			
		
			
		}




	}
	
}

