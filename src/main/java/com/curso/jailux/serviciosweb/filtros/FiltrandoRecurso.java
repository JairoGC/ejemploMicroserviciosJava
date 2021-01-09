package com.curso.jailux.serviciosweb.filtros;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FiltrandoRecurso {
 
	@GetMapping("/filtrando")
	public MappingJacksonValue encontrarAlgunBean() {
		AlgunBean algunBean = new AlgunBean("valor1","valor2","valor3");
		return crearFiltro(algunBean, new HashSet<String>(Arrays.asList("campo1", "campo2")));
	}
	
	@GetMapping("/filtrando-list")
	public MappingJacksonValue encontrarListaDeAlgunBean() {
		List<AlgunBean> list = Arrays.asList(
				new AlgunBean("valor1","valor2","valor3"),
				new AlgunBean("valor13","valor23","valor33")
				);
		return crearFiltro(list, new HashSet<String>(Arrays.asList("campo2", "campo3")));
	}
	
	private MappingJacksonValue crearFiltro(Object value, Set<String> properties) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
		FilterProvider filters = new SimpleFilterProvider().addFilter("AlgunBeanFiltro", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(value);
		mapping.setFilters(filters);
		return mapping;
	}
	
}
