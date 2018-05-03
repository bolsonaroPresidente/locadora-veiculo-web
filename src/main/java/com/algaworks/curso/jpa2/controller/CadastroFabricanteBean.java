package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFabricanteService fabricanteService;
	
	private Fabricante fabricante;

	@PostConstruct
	public void inicializar() {
	   if (fabricante == null) {
		   this.limpar();
	   }
	}
	
//	@PostConstruct
	private void limpar() {
		this.fabricante = new Fabricante();
	}
	
	public void salvar() {
		try {
			fabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso.");
			limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());		
		}
	}
	
	public boolean isEditando() {
		return this.fabricante.getCodigo() != null;
	}
	
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
