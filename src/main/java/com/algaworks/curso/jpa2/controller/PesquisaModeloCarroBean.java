package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ModeloCarroService carroService;
	
	private List<ModeloCarro> modelosCarro = new ArrayList<>();
	
	private ModeloCarro modeloCarroSelecionado;
	
	@PostConstruct
	public void inicializar() {
		modelosCarro = carroService.buscarTodos();
	}

	public void excluir() {
		try {
			carroService.excluir(modeloCarroSelecionado);
			modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo de carro " + modeloCarroSelecionado.getDescricao() + "excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarroSelecionado(ModeloCarro modeloCarro) {
		this.modeloCarroSelecionado = modeloCarro;
	}

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}
	
	

	

	
	
	
	
}




























