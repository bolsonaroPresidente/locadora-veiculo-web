package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Categoria;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloCarro modeloCarro;

	private List<Fabricante> fabricantes;

	private List<Categoria> categorias;
	
	@Inject
	private ModeloCarroService cadastroModeloCarroService;

	@Inject
	private FabricanteDAO fabricanteDAO;

	@PostConstruct
	public void inicializar() {
		if (this.modeloCarro == null) {
			this.limpar();
		}
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}
	
	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo carro salvo com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}


	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	
	public boolean isEditando() {
		return this.modeloCarro.getCodigo() != null;
	}
	
	private void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

}
