package modelo;

public class Mensagem {
		private int id;
		private Pessoa emitente;
		private Pessoa destinatario;
		private String texto;
		private String data;
		
		public Mensagem(int id, Pessoa emitente, Pessoa destinatario, String texto, String data) {
			super();
			this.id = id;
			this.emitente = emitente;
			this.destinatario = destinatario;
			this.texto = texto;
			this.data = data;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Pessoa getEmitente() {
			return emitente;
		}

		public void setEmitente(Pessoa emitente) {
			this.emitente = emitente;
		}

		public Pessoa getDestinatario() {
			return destinatario;
		}

		public void setDestinatario(Pessoa destinatario) {
			this.destinatario = destinatario;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Mensagem [id=" + id + ", emitente=" + emitente + ", destinatario=" + destinatario + ", texto="
					+ texto + ", data=" + data + "]";
		}
		
		
	
}
