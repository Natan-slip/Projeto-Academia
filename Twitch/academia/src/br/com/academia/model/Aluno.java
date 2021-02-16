package br.com.academia.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {

	private String nome;
	private String dataNasc;
	private String dataNascimento;
	private int idade;
	private double altura;
	private double peso;
	private String sexo;
	private String nivelDeAtividade;

	// *** Nome *** \\
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

	// *** Data *** \\
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public int getIdade() {
		LocalDate nascimento = LocalDate.parse(this.dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate hoje = LocalDate.now();
		int idade = Period.between(nascimento, hoje).getYears();
		return idade;

	}

	// *** Altura *** \\
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getAltura() {
		return this.altura;
	}

	// *** Peso *** \\
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPeso() {
		return this.peso;
	}

	// *** Sexo *** \\
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSexo() {
		return this.sexo;
	}

	
	// *** Nivel De Atividade F�rmula *** \\
public void setNivelDeAtividade(String nivelDeAtividade) {
	if(nivelDeAtividade.equals("Leve") || nivelDeAtividade.equals("Moderada") || nivelDeAtividade.equals("Intensa")) {	
	  if(getSexo().equals("Masculino")) {
		if(nivelDeAtividade.equals("Leve")) {
			this.nivelDeAtividade = String.valueOf(1.5);
			}
			else if(nivelDeAtividade.equals("Moderada")) {
			this.nivelDeAtividade = String.valueOf(1.8);
			}
			else if(getSexo().equals("Intesa")) {
			this.nivelDeAtividade = String.valueOf(2.1);
			}
		}
	  else if(getSexo().equals("Feminino")) {
		  if(nivelDeAtividade.equals("Leve")) {
			this.nivelDeAtividade = String.valueOf(1.6);
			}
			else if(nivelDeAtividade.equals("Moderada")) {
			this.nivelDeAtividade = String.valueOf(1.6);
			}
			else if(getSexo().equals("Intesa")) {
			this.nivelDeAtividade = String.valueOf(1.8);
			}
	  	  }
		}
	 }
	public String getNivelDeAtividade() {
		return this.nivelDeAtividade;
	}
	
	
	// *** Calculos Imc *** \\
		public double getImc() {
			return this.peso / Math.pow(altura, 2);
		}

		public String getStatusImc() {
			if (this.getImc() <= 18.6) {
				return "Abaixo do peso";
			} else if (this.getImc() > 18.6 && this.getImc() < 25) {
				return "Peso ideal (Parab�ns)";
			} else if (this.getImc() >= 25 && this.getImc() < 30) {
				return "Levemente acima do peso";
			} else if (this.getImc() >= 30 && this.getImc() < 35) {
				return "Obesidade grau I";
			} else if (this.getImc() >= 35 && this.getImc() <= 40) {
				return "Obesidade grau II (Severa)";
			} else {
				return "Obesidade III (Morbida)";
			}
		  }
		
		
	
	// *** NCD F�rmula *** \\
public double getNcd() {
		if(getSexo().equals("Masculino")) {
			if(getIdade() >= 18 && getIdade() <= 30) {
				return  (15.3 * getPeso() + 679) * Double.parseDouble(getNivelDeAtividade());
			} 
			else if(getIdade() > 30 && getIdade() <= 60) {
				return (11.6 * getPeso() + 879) * Double.parseDouble(getNivelDeAtividade());
			} 
			else {
				return (13.5 * getPeso() + 487) * Double.parseDouble(getNivelDeAtividade());
			}
		} 
		else if (getSexo().equals("Feminino")) {
			if(getIdade() >= 18 && getIdade() <= 30) {
				return (14.7 * getPeso() + 496) * Double.parseDouble(getNivelDeAtividade());
			} 
			else if(getIdade() > 30 && getIdade() <= 60) {
				return (8.7 * getPeso() + 829) * Double.parseDouble(getNivelDeAtividade());
			} 
			else {
				return (10.5 * getPeso() + 596) * Double.parseDouble(getNivelDeAtividade());
			}
		}
		return this.getNcd();
	}

}
