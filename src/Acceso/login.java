package Acceso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	Consulta consul = new Consulta();
	conexion conec = new conexion();
	
	//Este objeto es el que permite enviar instrucciones SQL a la BD
		private Statement consulta;
		//este nos permite almacenar los resultado de nuestra consulta
		private ResultSet resultado;
		private JTextField campo_clave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtUsuario = new JLabel("Usuario:");
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(174, 312, 60, 13);
		contentPane.add(txtUsuario);
		
		JLabel txtContaseña = new JLabel("Contraseña:");
		txtContaseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContaseña.setBounds(155, 364, 109, 19);
		contentPane.add(txtContaseña);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(244, 309, 96, 19);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 String usuario = campoUsuario.getText();
	           
					String contraseña = campo_clave.getText();

	                // Llamar al método para insertar en la base de datos
	               consul.insertarEnBaseDeDatos(usuario, contraseña);
				
			}
		});
		btnIniciar.setBounds(155, 393, 125, 21);
		contentPane.add(btnIniciar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(290, 393, 125, 21);
		contentPane.add(btnCancelar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\alejandro\\Desktop\\ARCHIVOS PC\\ACCESO A DATOS\\src\\accesoDatosLogin\\src\\img\\login.png"));
		lblLogo.setBounds(155, 58, 224, 224);
		contentPane.add(lblLogo);
		
		campo_clave = new JTextField();
		campo_clave.setBounds(244, 366, 96, 19);
		contentPane.add(campo_clave);
		campo_clave.setColumns(10);
		
		JButton eliminarUltimo = new JButton("Eliminar Ultimo Usuario");
		eliminarUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = campoUsuario.getText();
		           
				String contraseña = campo_clave.getText();
				 consul.eliminarUltimo(usuario, contraseña);
			}
		});
		eliminarUltimo.setBounds(194, 441, 185, 21);
		contentPane.add(eliminarUltimo);
	}
}
