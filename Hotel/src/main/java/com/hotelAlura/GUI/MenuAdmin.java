package com.hotelAlura.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdmin {

	private JFrame frmMenuadmin;
	private JPanel contentPane;
	private JPanel panelOpc;
	private JPanel panelMenus;
	private JLabel lblAdmin;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnLeer;
	private JButton btnEliminar;
	private JButton btnSalir;
	private GroupLayout gl_panelOpc;
	private String nombre;

	public MenuAdmin(String nom) {
		this.nombre = nom;
		frmMenuadmin = new JFrame();
		frmMenuadmin.setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		frmMenuadmin.setResizable(false);
		frmMenuadmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuadmin.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/busqueda.png")));
		frmMenuadmin.setTitle("Menu_Admin_CRUD");
		frmMenuadmin.setBounds(100, 100, 1230, 765);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmMenuadmin.setContentPane(contentPane);

		panelOpc = new JPanel();
		panelOpc.setBackground(new Color(255, 255, 255));

		panelMenus = new JPanel();

		lblAdmin = new JLabel(nombre);
		lblAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);

		btnAgregar = new JButton("Agregar");

		btnAgregar.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAgregar.setFocusable(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setIconTextGap(20);
		btnAgregar.setSelectedIcon(
				new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/Agregar.png")));
		btnAgregar.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/Agregar.png")));
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		btnModificar = new JButton("Modificar");

		btnModificar.setFocusable(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setHorizontalTextPosition(SwingConstants.LEADING);
		btnModificar.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/Modificar.png")));
		btnModificar.setIconTextGap(8);
		btnModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		btnLeer = new JButton("Leer");

		btnLeer.setFocusable(false);
		btnLeer.setBorderPainted(false);
		btnLeer.setContentAreaFilled(false);
		btnLeer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLeer.setIconTextGap(45);
		btnLeer.setHorizontalTextPosition(SwingConstants.LEADING);
		btnLeer.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/Leer.png")));
		btnLeer.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		btnEliminar = new JButton("Eliminar");

		btnEliminar.setFocusable(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setHorizontalTextPosition(SwingConstants.LEADING);
		btnEliminar.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/Eliminar.png")));
		btnEliminar.setIconTextGap(22);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		btnSalir = new JButton("Salir");

		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSalir.setFocusable(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/hotelAlura/GUI/Imagenes/casa.png")));
		btnSalir.setIconTextGap(8);
		btnSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		gl_panelOpc = new GroupLayout(panelOpc);
		gl_panelOpc.setHorizontalGroup(gl_panelOpc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpc.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelOpc.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdmin, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
								.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
								.addComponent(btnModificar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLeer, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panelOpc.setVerticalGroup(gl_panelOpc.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelOpc
				.createSequentialGroup().addGap(65)
				.addComponent(lblAdmin, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE).addGap(86)
				.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnLeer, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
				.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(49)));
		panelOpc.setLayout(gl_panelOpc);
		panelMenus.setLayout(new CardLayout(0, 0));
		panelMenus.add(new Agregar_users(), "Agregar");
		panelMenus.add(new Modificar_users(), "Modificar");
		panelMenus.add(new Leer_user(), "Leer");
		panelMenus.add(new Eliminar_user(), "Eliminar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(7)
						.addComponent(panelOpc, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelMenus, GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(7)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(panelMenus, GroupLayout.DEFAULT_SIZE, 701,
														Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(panelOpc, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
												.addGap(6)))));

		contentPane.setLayout(gl_contentPane);
		CardLayout cardLayout = (CardLayout) panelMenus.getLayout();
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(panelMenus, "Agregar");
				JPanel panelRefrescar =(JPanel) panelMenus.getComponent(0);
				((Agregar_users) panelRefrescar).refrescar();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMenus, "Modificar");
				JPanel panelRefrescar =(JPanel) panelMenus.getComponent(1);
				((Modificar_users) panelRefrescar).refrescar();
			}
		});
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMenus, "Leer");
				JPanel panelRefrescar =(JPanel) panelMenus.getComponent(2);
				((Leer_user) panelRefrescar).refrescar();
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMenus, "Eliminar");
				JPanel panelRefrescar =(JPanel) panelMenus.getComponent(3);
				((Eliminar_user) panelRefrescar).refrescar();
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmMenuadmin.dispose();

					@SuppressWarnings("unused")
					InicioSesion n1 = new InicioSesion();

				} catch (Exception e2) {
					System.out.println("Error al abrir");
				}
			}
		});
		frmMenuadmin.setVisible(true);

	}
}
