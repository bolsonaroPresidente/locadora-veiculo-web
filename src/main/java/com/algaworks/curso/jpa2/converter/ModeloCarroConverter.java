package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.ModeloCarroService;

@FacesConverter(forClass=ModeloCarro.class)
public class ModeloCarroConverter implements Converter {

	@Inject
	private ModeloCarroService modelCarroService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro modeloCarro = null;
		if (StringUtils.isNotBlank(value) && StringUtils.isNumeric(value)) {
			modeloCarro = modelCarroService.buscarPeloCodigo(new Long(value));
			return modeloCarro;
		}
		return modeloCarro;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			Long cod =((ModeloCarro)object).getCodigo();
			return (cod ==null)? null:cod.toString(); 
		}
		return "";
	}

	
}















