package com.algaworks.curso.jpa2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	
	//esse mapeamento já foi feito pela classe Aluguel, o mapeamento foi efetuado pelo atributo carro.
	//um carro pode estar vinculado a vários alugueis então o código do carro vai no aluguel
	// e se avisa a classe carro dos alugueis onde ele (carro), está vinculado.
	@OneToMany(mappedBy="carro")
	private List<Aluguel> alugueis;
	
	//comportamento padrão do @ManyToOne é EAGER mas pode ser alterado para LAZY
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_modelo")
	private ModeloCarro modelo;
	
    //comportamento padrão do @ManyToMany é LAZY mas pode ser alterado para EAGER 
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Acessorio> acessorios;

	
	
	public Long getCodigo() {
		return codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public String getChassi() {
		return chassi;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public ModeloCarro getModelo() {
		return modelo;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acessorios == null) ? 0 : acessorios.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (acessorios == null) {
			if (other.acessorios != null)
				return false;
		} else if (!acessorios.equals(other.acessorios))
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}

































