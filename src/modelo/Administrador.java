package modelo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Administrador extends Pessoa {

	public Administrador(String email, String senha, String nome, ) {
		super(email, senha, nome);

	}

	public String setor;

	public String getsetor() {
		return setor;
	}

	public void setsetor(String setor) {
		this.setor = setor
	}


}




