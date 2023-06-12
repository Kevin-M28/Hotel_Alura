package com.hotelAlura.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.clases.Reserva;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DatosUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textNacio;
	private JTextField textFieldTel;
	private JTextField textFieldF_Naci;
	private JTextField textFieldApellido;
	private JTable table;
	private final Cliente cliente;
	private DateFormat formato;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public DatosUsuario(Cliente c1) {
		setBackground(new Color(255, 255, 255));
		this.formato = new SimpleDateFormat("dd/MM/yyyy");
		setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		this.cliente = c1;

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(new Color(255, 255, 255));

		textFieldNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldNombre.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldNombre.setFocusable(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textFieldNombre.setColumns(10);

		JLabel lblNciona = new JLabel("Nacionalidad");
		lblNciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblNciona.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		textNacio = new JTextField();
		textNacio.setBackground(new Color(255, 255, 255));

		textNacio.setBorder(new EmptyBorder(0, 0, 0, 0));
		textNacio.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textNacio.setFocusable(false);
		textNacio.setEditable(false);
		textNacio.setHorizontalAlignment(SwingConstants.CENTER);
		textNacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textNacio.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		textFieldTel = new JTextField();
		textFieldTel.setBackground(new Color(255, 255, 255));

		textFieldTel.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldTel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldTel.setFocusable(false);
		textFieldTel.setEditable(false);
		textFieldTel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textFieldTel.setColumns(10);

		JLabel lblF_Nacimiento = new JLabel("Fecha de Nacimiento");
		lblF_Nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_Nacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		textFieldF_Naci = new JTextField();
		textFieldF_Naci.setBackground(new Color(255, 255, 255));

		textFieldF_Naci.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldF_Naci.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldF_Naci.setFocusable(false);
		textFieldF_Naci.setEditable(false);
		textFieldF_Naci.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldF_Naci.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textFieldF_Naci.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		textFieldApellido = new JTextField();
		textFieldApellido.setBackground(new Color(255, 255, 255));

		textFieldApellido.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldApellido.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldApellido.setFocusable(false);
		textFieldApellido.setEditable(false);
		textFieldApellido.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textFieldApellido.setColumns(10);

		String[] columnNames = {"ID","Entrada", "Salida", "Valor","Pago"};
		model = new DefaultTableModel(columnNames,0){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		if (cliente != null) {
			textFieldNombre.setText(cliente.getNombre());
			textFieldF_Naci.setText(cliente.getFecha_nacimiento().toString());
			textNacio.setText(cliente.getNacionalidad());
			textFieldTel.setText(cliente.getTelefono().toString());
			textFieldApellido.setText(cliente.getApellido());
			for (Reserva a : cliente.getReservas()) {
				Object[] rowDatos = { a.getId_res(), formato.format(a.getFecha_entrada()), formato.format(a.getFecha_salida()), a.getValor(),
						a.getForma_pago() };
				model.addRow(rowDatos);
			}
			
		}

		table = new JTable(model);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		JScrollPane pruebaJScrollPane = new JScrollPane(table);
		pruebaJScrollPane.setBackground(new Color(240, 240, 240));
		pruebaJScrollPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setToolTipText("Refersca la tabla");
		btnRefrescar.setFocusable(false);
		btnRefrescar.setIcon(new ImageIcon(DatosUsuario.class.getResource("/com/hotelAlura/GUI/Imagenes/refresh.png")));
		btnRefrescar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRefrescar.setContentAreaFilled(false);
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textNacio, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(textFieldTel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(textFieldF_Naci, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(textFieldApellido, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(lblF_Nacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNciona, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnRefrescar)
							.addGap(67)))
					.addGap(26)
					.addComponent(pruebaJScrollPane, GroupLayout.PREFERRED_SIZE, 637, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pruebaJScrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblF_Nacimiento, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldF_Naci, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNciona, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNacio, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRefrescar)
					.addGap(100))
		);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescar();
			}
		});
		setLayout(groupLayout);
		
	}
	public void refrescar() {
		
		model.setRowCount(0);
		for (Reserva a : cliente.getReservas()) {
			Object[] rowDatos = { a.getId_res(), formato.format(a.getFecha_entrada()), formato.format(a.getFecha_salida()), a.getValor(),
					a.getForma_pago() };
			model.addRow(rowDatos);
		}
		table.repaint();
	}
}
