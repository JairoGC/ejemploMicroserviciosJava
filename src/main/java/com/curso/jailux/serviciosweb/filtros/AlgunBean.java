package com.curso.jailux.serviciosweb.filtros;

import com.fasterxml.jackson.annotation.JsonFilter;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"campo1","campo2"})

 @JsonFilter("AlgunBeanFiltro")
public class AlgunBean {
	
	private String campo1;
	
	private String campo2;
	
	//@JsonIgnore
	private String campo3;
	
	public AlgunBean(String campo1, String campo2, String campo3) {
		super();
		this.campo1 = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
	}

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCampo3() {
		return campo3;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}
	
}
