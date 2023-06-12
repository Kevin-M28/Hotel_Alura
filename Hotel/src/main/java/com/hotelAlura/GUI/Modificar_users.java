package com.hotelAlura.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.dao.ClientesDao;
import com.hotelAlura.utiles.JPAUtils;
import com.toedter.calendar.JDateChooser;

import jakarta.persistence.EntityManager;

import java.awt.Dimension;
import javax.swing.JButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Modificar_users extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNacio;
	private JTextField textTelefono;
	private JTable table;
	private JTextField textID;
	private DefaultTableModel model;
	private JDateChooser dateChooser;

	@SuppressWarnings("serial")
	public Modificar_users() {
		setBackground(new Color(255, 255, 255));

		JLabel lblNomnbre = new JLabel("Nombre");
		lblNomnbre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomnbre.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textNombre = new JTextField();
		textNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textApellido = new JTextField();
		textApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textApellido.setColumns(10);

		JLabel lblF_Nacimiento = new JLabel("Fecha Nacimineto");
		lblF_Nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_Nacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setSize(new Dimension(75, 75));
		dateChooser.getCalendarButton().setMinimumSize(new Dimension(21, 22));
		dateChooser.getCalendarButton().setMaximumSize(new Dimension(21, 22));
		dateChooser.getCalendarButton().setHorizontalTextPosition(SwingConstants.CENTER);

		JLabel lblNaciona = new JLabel("Nacionalidad");
		lblNaciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaciona.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textNacio = new JTextField();
		textNacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textNacio.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textTelefono.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JButton btnActualizar = new JButton("Actualizar");

		btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);

		String[] columnNames = { "ID", "Nombre", "Apellido", "Nacimiento", "Nacionalidad", "Telefono" };
		model = new DefaultTableModel(columnNames, 0){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		table = new JTable(model);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		JScrollPane pruebaJScrollPane = new JScrollPane(table);

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textID = new JTextField();
		textID.setEditable(false);
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(38).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
										.addComponent(textApellido, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
										.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
										.addComponent(textNacio, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
										.addComponent(textTelefono, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
										.addComponent(lblNomnbre, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblF_Nacimiento, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNaciona, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(20)
								.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
				.addGap(26).addComponent(pruebaJScrollPane, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(pruebaJScrollPane,
								GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(34).addComponent(lblID)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(lblNomnbre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblF_Nacimiento, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNaciona, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNacio, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		setLayout(groupLayout);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNombre.getText().trim().length() > 0 && textApellido.getText().trim().length() > 0) {
					String nom = textNombre.getText();
					String ape = textApellido.getText();
					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
					RowFilter<DefaultTableModel, Object> filter1 = RowFilter.regexFilter("(?i)" + nom, 1);
					RowFilter<DefaultTableModel, Object> filter2 = RowFilter.regexFilter("(?i)" + ape, 2);
					RowFilter<DefaultTableModel, Object> combinedFilter = RowFilter
							.andFilter(Arrays.asList(filter1, filter2));
					sorter.setRowFilter(combinedFilter);
					table.setRowSorter(sorter);
					
					textNacio.setText(null);
					dateChooser.setDate(null);
					textTelefono.setText(null);
					
				}else {
					txtBlanco();
				}
			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().trim().length() > 0) {
					try (JPAUtils entityManagerUtil = new JPAUtils()) {
						EntityManager entityManager = entityManagerUtil.getEntityManager();
						ClientesDao clientesDao =new ClientesDao(entityManager);
						Cliente c1 = clientesDao.buscarCliente(Long.parseLong(textID.getText()));
						if(c1!=null) {
							c1.setNombre(textNombre.getText());
							c1.setApellido(textApellido.getText());
							c1.setFecha_nacimiento(dateChooser.getDate());
							c1.setNacionalidad(textNacio.getText());
							c1.setTelefono(Long.parseLong(textTelefono.getText()));
							clientesDao.actualizarCliente(c1);
						}
						refrescar();
					} catch (Exception e2) {
						throw new RuntimeException(e2);
					}
				}
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

					if (selectedRow >= 0) {
						String id = table.getValueAt(selectedRow, 0).toString();
						String nom = table.getValueAt(selectedRow, 1).toString();
						String ape = table.getValueAt(selectedRow, 2).toString();
						String date = table.getValueAt(selectedRow, 3).toString();
						String naci = table.getValueAt(selectedRow, 4).toString();
						String tel = table.getValueAt(selectedRow, 5).toString();
						textID.setText(null);
						textID.setText(id);
						textNombre.setText(nom);
						textApellido.setText(ape);
						try {
							dateChooser.setDate(dateFormat.parse(date));
						} catch (ParseException e) {
							e.printStackTrace();
						} 
						textNacio.setText(naci);
						textTelefono.setText(tel);
					}
				}
			}
		});
		refrescar();
	}

	public void refrescar() {
		if (table.getRowSorter() == null) {
			try (JPAUtils entityManagerUtil = new JPAUtils()) {
				EntityManager entityManager = entityManagerUtil.getEntityManager();
				ClientesDao clientesDao = new ClientesDao(entityManager);
				List<Cliente> clientes = clientesDao.listaClientes();
				model.setRowCount(0);
				if (clientes != null) {
					for (Cliente c1 : clientes) {
						Object[] filaObjects = { c1.getId_usuarios(), c1.getNombre(), c1.getApellido(),
								c1.getFecha_nacimiento(), c1.getNacionalidad(), c1.getTelefono() };
						model.addRow(filaObjects);
					}
					txtBlanco();
					table.repaint();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			table.setRowSorter(null);
			txtBlanco();
			table.repaint();
		}

	}

	public void txtBlanco() {
			textID.setText(null);
			textNombre.setText(null);
			textApellido.setText(null);
			textNacio.setText(null);
			dateChooser.setDate(null);
			textTelefono.setText(null);
	}
}
