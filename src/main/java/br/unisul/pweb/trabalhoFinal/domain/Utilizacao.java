package br.unisul.pweb.trabalhoFinal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Utilizacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id //chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=5) 
	private Integer id;
	@Column(length=30) 
	private String nomeFuncionario;
	@Column(length=30) 
	private String veiculo;
	@Column(length=5) 
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	@Column(length=5) 
	@JsonFormat(pattern="HH:mm")
	private Date hora;
	@Column(length=5) 
	private double kmInicial;
	@Column(length=5) 
	private double kmFinal;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="veiculo_id")
	private Veiculo vl;
	
	public Utilizacao() {
		
	}
	
	public Utilizacao(Veiculo MarcaModelo,Funcionario nomeFun, Date dt,Date hr, double kmIn, double kmFin) {
		super();
		this.veiculo = MarcaModelo.toString();
		this.nomeFuncionario = nomeFun.getNome();
		this.data = dt;
		this.hora = hr;
		this.kmInicial = kmIn;
		this.kmFinal = kmFin;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public double getKmInicial() {
		return kmInicial;
	}
	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}
	public double getKmFinal() {
		return kmFinal;
	}
	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}
	
	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	///*
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVl() {
		return vl;
	}

	public void setVl(Veiculo vl) {
		this.vl = vl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Utilizacao other = (Utilizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
