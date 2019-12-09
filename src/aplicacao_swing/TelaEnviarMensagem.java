package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pessoa;


public class TelaEnviarMensagem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JButton btnCriar;
	private JLabel lblmsg;
	private JLabel label;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroPrateleira frame = new TelaCadastroPrateleira();
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
	public TelaEnviarMensagem() {
		setTitle("Enviar Mensagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("Destinatário");
		label.setBounds(10, 19, 77, 16);
		contentPane.add(label);
		
		lblNome = new JLabel("Texto");
		lblNome.setBounds(44, 69, 43, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 14, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnCriar = new JButton("Enviar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String email_desti = textField_1.getText();
					String texto = textField.getText();
					Pessoa destinatario = null;
					for(Pessoa p: Fachada.listarPessoas()) {
						if(p.getEmail()==email_desti) {
							destinatario = p;
						}
					}
					
					Fachada.enviarMensagem(destinatario, texto);
					
					lblmsg.setText("Mensagem enviada para="+destinatario.getNome());
					textField.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());

				}
			}
		});
		
				textField = new JTextField();
				textField.setBounds(106, 58, 189, 104);
				contentPane.add(textField);
				textField.setColumns(10);
		btnCriar.setBounds(225, 174, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 174, 196, 14);
		contentPane.add(lblmsg);
	}
}
