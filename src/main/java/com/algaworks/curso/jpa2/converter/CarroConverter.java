package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.CarroService;

/*
 * Classe necessária para a edição pois o CadastroFabricante Espera um objeto e não um número
 * como é enviado para o CadastroFabricanteBean
 */

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter {

	@Inject
	private CarroService carroService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro retorno = null;
		if (StringUtils.isNotBlank(value)) {
			retorno = this.carroService.buscaComModeloPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Carro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}