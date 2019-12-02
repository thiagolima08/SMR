package fachada;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.Mensagem;
import modelo.Pessoa;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static Pessoa logado;
	private static int idmensagem = 1;	//autoincremento

	public static Pessoa login(String email, String senha) throws  Exception {
		if(logado!=null)
			throw new Exception("ja existe um usuario logado:"+logado.getEmail());
		
		Pessoa pes = repositorio.localizarPessoa(email,senha);
		logado = pes;
		return pes;
	}
	public static Pessoa logoff(String email, String senha) throws  Exception {
		if(logado==null)
			throw new Exception("Pessoa não logada:");
		
		Pessoa pes = repositorio.localizarPessoa(email,senha);
		if(pes!=logado)
			throw new Exception("Esta pessoa não está logada:");
		
		logado = null; 
		return pes;
	}
	
	public static Pessoa getLogado() {
		return logado;
	}
	
	public static Pessoa cadastrarPessoa(String email, String senha, String nome, BufferedImage imagem) 
			throws  Exception{
		Pessoa pes = repositorio.localizarPessoa(email,senha);
		if (pes!=null)
			throw new Exception("Pessoa já cadastrada:" + nome);
		
		pes = new Pessoa(email,senha,nome);
		repositorio.adicionar(pes);
		return pes;
	}

	public static ArrayList<Pessoa> listarPessoas() {
		return repositorio.getPessoas();
	}
	
	public static Mensagem enviarMensagem(Pessoa destinatario, String texto) 
			throws  Exception{
		
		if(logado==null)
			throw new Exception("operação inválida - faça o login");
		
		Mensagem m = repositorio.localizarMensagem(idmensagem);
		if (m!=null)
			throw new Exception("Mensagem ja enviada:" + idmensagem);
		//Enviar mensagem e adicionar no repositorio
		idmensagem++;
		LocalDateTime time;
		String t;
		time = LocalDateTime.now();
		t = time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		m = new Mensagem(idmensagem,getLogado(),destinatario,texto,t);
		repositorio.adicionar(m);
		destinatario.adicionarCaixaEntrada(m);
		logado.adicionarCaixaSaida(m);
		return m;
	}
	
	public static ArrayList<Mensagem> listarCaixaEntrada() {
		return repositorio.getMensagens();
	}
	
	public static ArrayList<Mensagem> listarCaixaSaida() {
		return repositorio.getMensagens();
	}
	
	public static Mensagem apagarMensagem(int idmensagem) 
			throws Exception {
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");

		Mensagem msg = repositorio.localizarMensagem(idmensagem);
		if (msg==null)
			throw new Exception("Mensagem inexistente:"+idmensagem);

		repositorio.remover(msg);
		
		//remover da caixa
		
		return msg;
	}
	

}//class
