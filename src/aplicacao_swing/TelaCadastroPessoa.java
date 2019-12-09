package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Mensagem;
import modelo.Pessoa;
import javax.swing.JPasswordField;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblImagem;
	private JButton btnCriar;
	private JLabel lblmsg;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastroProduto frame = new TelaCadastroProduto();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroPessoa() {
		setTitle("Cadastrar Pessoa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 396, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 84, 142, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 90, 46, 14);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 52, 46, 14);
		contentPane.add(lblSenha);
		
		lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(10, 126, 59, 20);
		contentPane.add(lblImagem);
		
		label = new JLabel("");
		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/pessoa.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setBounds(82, 128, 125, 89);
		label.setIcon(imagem);
		contentPane.add(label);
		
		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().isEmpty() || textField_2.getText().isEmpty())
						lblmsg.setText("campo vazio");
					else {
						String nome = textField.getText();
						String email = textField_2.getText();
						String senha = new String( passwordField.getPassword() );
						ImageIcon imagem=null;
							
						Pessoa p = Fachada.cadastrarPessoa(email, senha, nome, imagem);
						
						lblmsg.setText("Pessoa cadastrada ="+p.getNome());
						textField.setText("");
						textField_2.setText("");
						textField.requestFocus();
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(251, 207, 115, 23);
		contentPane.add(btnCriar);
		
		button = new JButton("Limpar");
		button.setBounds(249, 154, 117, 29);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_2.setText("");
				passwordField.setText("");
				textField.requestFocus();
			}
		});

		lblmsg = new JLabel("");
		lblmsg.setBounds(22, 207, 173, 20);
		contentPane.add(lblmsg);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 43, 142, 26);
		contentPane.add(passwordField);
		
	}
}
