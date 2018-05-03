package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.service.AcessorioService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioService acessService;
	
	private Acessorio acessorio;
	
	@PostConstruct
	public void inicializar() {
		if (this.acessorio == null) {
			this.limpar();
		}
	}

	public void salvar() {
		try {
			this.acessService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório salvo com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limpar() {
		this.acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
	public boolean isEditando() {
		return this.acessorio.getCodigo() != null;
	}
	
	
	
}






































