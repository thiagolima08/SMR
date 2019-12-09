package modelo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Administrador {
	private String email;
	private String senha;
	private String nome;
	private BufferedImage imagem;
	private ArrayList<Mensagem> caixaEntrada = new ArrayList<>();
	private ArrayList<Mensagem> caixaSaida = new ArrayList<>();
	
	public Administrador(String email, String senha,String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public ArrayList<Mensagem> getCaixaEntrada() {
		return caixaEntrada;
	}

	public void adicionarCaixaEntrada(Mensagem mensagem) {
		this.caixaEntrada.add(mensagem);
	}
	
	public void removerCaixaEntrada(Mensagem mensagem) {
		this.caixaEntrada.remove(mensagem);
	}
	
	public String localizarCaixaEntrada(int id) {
		for(Mensagem p : caixaEntrada){
			if(p.getId()==id)
				return p.getTexto();
		}
		return null;
	}

	public ArrayList<Mensagem> getCaixaSaida() {
		return caixaSaida;
	}

	public void adicionarCaixaSaida(Mensagem mensagem) {
		this.caixaSaida.add(mensagem);
	}
	
	public void removerCaixaSaida(Mensagem mensagem) {
		this.caixaEntrada.remove(mensagem);
	}
	
	public String localizarCaixaSaida(int id) {
		for(Mensagem p : caixaSaida){
			if(p.getId()==id)
				return p.getTexto();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + ", nome=" + nome + ", imagem=" + imagem
				+ ", caixaEntrada=" + caixaEntrada + ", caixaSaida=" + caixaSaida + "]";
	}
	
	
	
}
