package com.hotelAlura.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hotelAlura.clases.Administrador;
import com.hotelAlura.clases.Cliente;
import com.hotelAlura.dao.AdminDao;
import com.hotelAlura.dao.ClientesDao;
import com.hotelAlura.dao.UsuarioDao;
import com.hotelAlura.utiles.JPAUtils;

import jakarta.persistence.EntityManager;

public class MiBoton implements ActionListener {

	private JTextField t1;
	private JPasswordField t2;
	private JButton b1;
	private JFrame f1;

	public MiBoton(JTextField textUsuario, JPasswordField textContrasena, JButton btnIniciar, JFrame jf) {
		this.t1 = textUsuario;
		this.t2 = textContrasena;
		this.b1 = btnIniciar;
		this.f1 = jf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try (JPAUtils entityManagerUtil = new JPAUtils()) {
				EntityManager entityManager = entityManagerUtil.getEntityManager();
				UsuarioDao u1 = new UsuarioDao(entityManager);
				
				
				var verificicar = u1.verificarCredenciales(this.t1.getText().toString(),
						String.valueOf(this.t2.getPassword()));
				if (verificicar != null) {
					switch (verificicar.getClass().getSimpleName()) {
					case "Cliente":
						Cliente c1 = new ClientesDao(entityManager).buscarCliente(verificicar.getId_usuarios());
						@SuppressWarnings("unused")
						MenuUsuario m1 = new MenuUsuario(c1);
						this.f1.dispose();
						break;
					case "Administrador":
						Administrador a1 = new AdminDao(entityManager).buscarAdmin(verificicar.getId_usuarios());
						@SuppressWarnings("unused")
						MenuAdmin m2 = new MenuAdmin(a1.getNombre());
						this.f1.dispose();
						break;
					default:
						System.out.println("Error");
					}
				} else {
					JOptionPane.showMessageDialog(this.f1, "Usuario/Contraseña incorrecta");
				}

			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}

	}

}
