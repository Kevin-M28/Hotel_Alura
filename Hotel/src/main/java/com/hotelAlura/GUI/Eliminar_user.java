package com.hotelAlura.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.dao.ClientesDao;
import com.hotelAlura.dao.UsuarioDao;
import com.hotelAlura.utiles.JPAUtils;

import jakarta.persistence.EntityManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Eliminar_user extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTable table;
	private JTextField textID;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public Eliminar_user() {
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

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textID.setEditable(false);
		textID.setColumns(10);

		String[] columnNames = { "ID", "Nombre", "Apellido", "Nacimiento", "Nacionalidad", "Telefono" };
		model = new DefaultTableModel(columnNames, 0){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		table = new JTable(model);
		refrescar();
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		JScrollPane pruebaJScrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addComponent(textApellido)
							.addComponent(textNombre)
							.addComponent(lblNomnbre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pruebaJScrollPane, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(183)
							.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNomnbre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pruebaJScrollPane, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();

					if (selectedRow >= 0) {
						String id = table.getValueAt(selectedRow, 0).toString();
						String nom = table.getValueAt(selectedRow, 1).toString();
						String ape = table.getValueAt(selectedRow, 2).toString();

						textID.setText(id);
						textNombre.setText(nom);
						textApellido.setText(ape);
					}
				}
			}
		});
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

				} else {
					refrescar();
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().trim().length() > 0) {
					try (JPAUtils entityManagerUtil = new JPAUtils()) {
						EntityManager entityManager = entityManagerUtil.getEntityManager();
						ClientesDao clientesDao = new ClientesDao(entityManager);
						UsuarioDao usuarioDao = new UsuarioDao(entityManager);
						clientesDao.eliminarCliente(Long.parseLong(textID.getText()));
						usuarioDao.eliminarUsuario(Long.parseLong(textID.getText()));
						refrescar();
					} catch (Exception e2) {
						throw new RuntimeException(e2);
					}
				}
			}
		});

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
		if (textID.getText() != null || textApellido.getText() != null || textNombre.getText() != null) {
			textID.setText(null);
			textNombre.setText(null);
			textApellido.setText(null);
		}
	}

}