package repositorio;

import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Mensagem;
import modelo.Pessoa;

public class Repositorio {
	private TreeMap<String,Pessoa> pessoas = new TreeMap<>();
	private ArrayList<Mensagem> mensagens = new ArrayList<>();
	
	public void adicionar(Pessoa p){
		pessoas.put(p.getEmail()+p.getSenha(),  p); //chave concatenada
	}
	
	public void remover(Pessoa p){
		pessoas.remove(p.getEmail()+p.getSenha());
	}
	
	public Pessoa localizarPessoa(String email, String senha){
		return pessoas.get(email+senha);
	}
	
	public void adicionar(Mensagem m){
		mensagens.add(m);
	}
	
	public void remover(Mensagem m){
		mensagens.remove(m);
	}
	
	public Mensagem localizarMensagem(int id){
		for(Mensagem m : mensagens){
			if(m.getId()==id)
				return m;
		}
		return null;
	}
	
	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return  
				new ArrayList<Pessoa> (pessoas.values());	//TreeMap --> ArrayList
	}
	
	public int getTotalMensagens(){
		return mensagens.size();
	}


}

