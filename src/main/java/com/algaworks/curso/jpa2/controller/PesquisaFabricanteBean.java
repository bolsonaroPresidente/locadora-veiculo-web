package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.FabricanteService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FabricanteService fabService;
	
	private List<Fabricante> fabricantes = new ArrayList<>();
	
	private Fabricante fabricanteSelecionado;
	
	@PostConstruct
	public void inicializar() {
		fabricantes = fabService.buscarTodos();
	}

	public void excluir() {
		try {
			fabService.excluir(fabricanteSelecionado);
			fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + "excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabriSelecionado) {
		this.fabricanteSelecionado = fabriSelecionado;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	

	

	
	
	
	
}




























