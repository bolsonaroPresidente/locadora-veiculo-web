package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.service.AcessorioService;

@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter {

	@Inject
	private AcessorioService acessorioService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;
		if (StringUtils.isNoneBlank(value)) {
			retorno = acessorioService.buscaPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			Long codigo = ((Acessorio)object).getCodigo();
			String retorno = (codigo ==null)?null:codigo.toString();
			return retorno;
		}
		return "";
	}

}
