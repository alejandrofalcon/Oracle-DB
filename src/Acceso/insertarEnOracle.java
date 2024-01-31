package Acceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class insertarEnOracle extends JFrame {
	private JTextField textField1;
    private JTextField textField2;
    private JButton boton;

    public insertarEnOracle() {
        // Configuración del JFrame
        setTitle("Inserción de Datos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialización de componentes
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        boton = new JButton("Insertar Datos");

        // Configuración del ActionListener para el botón
        boton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Lógica para insertar los datos
                insertarDatos();
            }
        });

        // Configuración del diseño del JFrame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Usuario:"));
        add(textField1);
        add(new JLabel("Contraseña:"));
        add(textField2);
        add(boton);

        // Hacer visible el JFrame
        setVisible(true);
    }

    // Método para insertar los datos (puedes personalizar según tus necesidades)
    private void insertarDatos() {
        String dato1 = textField1.getText();
        String dato2 = textField2.getText();
        
        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Ajusta la URL de conexión
        String usuario = "SYSTEM";
        String contraseña = "200102";

        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            // Crear la sentencia SQL para la inserción
            String sql = "INSERT INTO LOGIN (usuario, contraseña) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Establecer los parámetros de la sentencia SQL
                preparedStatement.setString(1, dato1);
                preparedStatement.setString(2, dato2);

                // Ejecutar la inserción
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Datos insertados correctamente en la base de datos.");
                } else {
                    System.out.println("No se insertaron datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Aquí puedes realizar la lógica para insertar los datos en tu base de datos u otro lugar
        System.out.println("Usuario: " + dato1);
        System.out.println("Contraseña " + dato2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new insertarEnOracle();
            }
        });
    }
    
};

