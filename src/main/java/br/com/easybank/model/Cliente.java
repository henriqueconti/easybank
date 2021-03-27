package br.com.easybank.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.easybank.enumerated.TipoCliente;
import br.com.easybank.enumerated.TipoPessoa;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("nome_titular")
	@Column(nullable = false)
	@NotNull
	private String titularConta;
	
	@JsonProperty("cpf_titular")
	@Column(nullable = false, unique = true)
	@CPF(message = "CPF invalido")
	@NotNull
	private String cpfTitular; 
	
//	@JsonProperty("data_nascimento")
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@Column(nullable = false)
//	private LocalDate dataNascimento;
	
	@JsonProperty("tipo_pessoa")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoPessoa tipoPessoa;
	
	@JsonProperty("tipo_cliente")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull
	private TipoCliente tipoCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String titularConta, @CPF(message = "CPF invalido") String cpfTitular,
					TipoPessoa tipoPessoa, TipoCliente tipoCliente) {
		this.id = id;
		this.titularConta = titularConta;
		this.cpfTitular = cpfTitular;
//		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
		this.tipoCliente = tipoCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

//	public LocalDate getDataNascimento() {
//		return dataNascimento;
//	}
//
//	public void setDataNascimento(LocalDate dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}