package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.AcessorioService;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroService carroService;
	
	@Inject
	private AcessorioService acessorioService; 
	
	@Inject
	private ModeloCarroService modeloCarroService;  

	private Carro carro; 
	private List<ModeloCarro> modelosCarros;
	private List<Acessorio> acessorios;

	
	@PostConstruct
	public void inicializar() {
		if (carro==null) {
			limpar();
		}
		acessorios = acessorioService.buscarTodos();
		modelosCarros = modeloCarroService.buscarTodos();
	}
	
	public void salvar() {
		
		try {
			carroService.salvar(carro);
			FacesUtil.addSuccessMessage("Salvo com sucesso");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
		
	private void limpar() {
		this.carro = new Carro();
		this.carro.setAcessorios(new ArrayList<Acessorio>());
	}
	
	
	public boolean isEditando() {
		return this.carro.getCodigo() != null;
	}
	
	public CarroService getCarroService() {
		return carroService;
	}
	public AcessorioService getAcessorioService() {
		return acessorioService;
	}
	public ModeloCarroService getModeloCarroService() {
		return modeloCarroService;
	}
	public Carro getCarro() {
		return carro;
	}
	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setCarroService(CarroService carroService) {
		this.carroService = carroService;
	}
	public void setAcessorioService(AcessorioService acessorioService) {
		this.acessorioService = acessorioService;
	}
	public void setModeloCarroService(ModeloCarroService modeloCarroService) {
		this.modeloCarroService = modeloCarroService;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public void setModelosCarros(List<ModeloCarro> modelosCarros) {
		this.modelosCarros = modelosCarros;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
