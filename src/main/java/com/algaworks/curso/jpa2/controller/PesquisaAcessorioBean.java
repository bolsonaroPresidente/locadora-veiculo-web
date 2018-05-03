package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AcessorioDAO acessorioDAO;
	
	private List<Acessorio> acessorios;
	
	private Acessorio acessorioSelecionado;
	
	@PostConstruct
	public void inicializar() {
		acessorios = acessorioDAO.buscarTodos();
	}
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	public void excluir() {
		try {
			acessorioDAO.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessório " + acessorioSelecionado.getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}
	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}
	
}
