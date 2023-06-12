package com.hotelAlura.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.dao.ClientesDao;
import com.hotelAlura.utiles.JPAUtils;
import com.toedter.calendar.JDateChooser;

import jakarta.persistence.EntityManager;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Agregar_users extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNacionalidad;
	private JTextField textTelefono;
	private JTable table;
	private JTextField textContra;
	private JTextField textUsuario;
	private DefaultTableModel model;
	private JDateChooser dateChooser;

	@SuppressWarnings("serial")
	public Agregar_users() {
		setBackground(new Color(255, 255, 255));

		textNombre = new JTextField();
		textNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textNombre.setColumns(10);

		JLabel lblNomnbre = new JLabel("Nombre");
		lblNomnbre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomnbre.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textApellido = new JTextField();
		textApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textApellido.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JLabel lblF_Nacimiento = new JLabel("Fecha Nacimineto");
		lblF_Nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_Nacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textNacionalidad = new JTextField();
		textNacionalidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textNacionalidad.setColumns(10);

		JLabel lblNaciona = new JLabel("Nacionalidad");
		lblNaciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaciona.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textTelefono.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		String[] columnNames = {"ID","Nombre", "Apellido", "Nacimiento","Nacionalidad","Telefono"};
		model = new DefaultTableModel(columnNames,0){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		refrescar();
		table = new JTable(model);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		JScrollPane pruebaJScrollPane = new JScrollPane(table);
		

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setMinimumSize(new Dimension(21, 22));
		dateChooser.getCalendarButton().setMaximumSize(new Dimension(21, 22));
		dateChooser.getCalendarButton().setHorizontalTextPosition(SwingConstants.CENTER);
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.getCalendarButton().setSize(new Dimension(75, 75));

		JButton btnAgregar = new JButton("Agregar");

		btnAgregar.setMinimumSize(new Dimension(75, 21));
		btnAgregar.setMaximumSize(new Dimension(75, 21));
		btnAgregar.setPreferredSize(new Dimension(75, 21));
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		textContra = new JTextField();
		textContra.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textContra.setColumns(10);
		
		JLabel lblTelefono_1 = new JLabel("Contraseña");
		lblTelefono_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		
		JLabel lblNaciona_1 = new JLabel("Usuario");
		lblNaciona_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaciona_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textApellido, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addComponent(textNacionalidad, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addComponent(textTelefono, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addComponent(lblF_Nacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNomnbre, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addComponent(lblNaciona, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNaciona_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addComponent(textUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addComponent(textContra, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addComponent(lblTelefono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(60))
						.addComponent(lblTelefono_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(pruebaJScrollPane, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pruebaJScrollPane, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(lblNomnbre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblF_Nacimiento, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNaciona, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNacionalidad, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNaciona_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTelefono_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textContra, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textApellido.getText().trim() != null && textNacionalidad.getText().trim() != null
						&& textNombre.getText().trim() != null && textTelefono.getText().trim() != null
						&& dateChooser.getDate().toString().trim() != null && textUsuario.getText().trim() != null && textContra.getText().trim() != null) {
					try (JPAUtils entityManagerUtil = new JPAUtils()) {
						EntityManager entityManager = entityManagerUtil.getEntityManager();
						ClientesDao cli_nuevo = new ClientesDao(entityManager);
						cli_nuevo.guardarCliente(new Cliente(textNombre.getText(), textApellido.getText(),
								dateChooser.getDate(), textNacionalidad.getText(),
								Long.parseLong(textTelefono.getText()),textUsuario.getText() , textContra.getText()));
						refrescar();
						txtblancos();
					} catch (Exception e1) {
						
					}
				}

			}
		});

	}
	public void refrescar() {
		try (JPAUtils entityManagerUtil = new JPAUtils()) {
			EntityManager entityManager = entityManagerUtil.getEntityManager();
			ClientesDao clientesDao = new ClientesDao(entityManager);
			List<Cliente> clientes= clientesDao.listaClientes();
			model.setRowCount(0);
			if(clientes!=null) {
				for(Cliente c1 : clientes) {
					Object [] filaObjects = {
						c1.getId_usuarios(),
						c1.getNombre(),
						c1.getApellido(),
						c1.getFecha_nacimiento(),
						c1.getNacionalidad(),
						c1.getTelefono()
					};
					model.addRow(filaObjects);
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void txtblancos() {
		textNombre.setText(null);
		textApellido.setText(null);
		dateChooser.setDate(null);
		textNacionalidad.setText(null);
		textTelefono.setText(null);
		textUsuario.setText(null);
		textContra.setText(null);
	}
}
