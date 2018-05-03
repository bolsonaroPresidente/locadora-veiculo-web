package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.model.Aluguel;
import com.algaworks.curso.jpa2.service.AluguelService;

//@FacesConverter(forClass=Aluguel.class)
public class AluguelConverter implements Converter {

	@Inject
	private AluguelService aluguelService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluguel retorno = null;
		if (StringUtils.isNoneBlank(value)) {
			retorno = aluguelService.buscaPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			Long codigo = ((Aluguel)object).getCodigo();
			String retorno = (codigo ==null)?null:codigo.toString();
			return retorno;
		}
		return "";
	}

}
