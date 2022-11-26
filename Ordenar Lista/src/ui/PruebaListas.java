package ui;

import java.awt.Font;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import nucleo.Persona;
import nucleo.Principal;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import auxiliares.ComparadoresPersona;
import auxiliares.ListadoTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaListas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPersonas;
	private ListadoTableModel modelo;
	private Principal p;

	public PruebaListas() {
		p = Principal.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 575);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane panelListado = new JScrollPane();
		panelListado.setBounds(15, 127, 850, 376);
		contentPane.add(panelListado);
		
		modelo = new ListadoTableModel();
		tablaPersonas = new JTable();
		tablaPersonas.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		tablaPersonas.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		tablaPersonas.setModel(modelo);
		panelListado.setViewportView(tablaPersonas);
		
		JButton eliminarBtn = new JButton("Eliminar");
		eliminarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTabla();
			}
		});
		eliminarBtn.setBounds(750, 68, 115, 29);
		contentPane.add(eliminarBtn);
		
		JButton restaurarBtn = new JButton("Restaurar");
		restaurarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		restaurarBtn.setBounds(620, 68, 115, 29);
		contentPane.add(restaurarBtn);
		
		JPanel panelOrdenar = new JPanel();
		panelOrdenar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ordenar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrdenar.setBounds(15, 42, 590, 69);
		contentPane.add(panelOrdenar);
		panelOrdenar.setLayout(null);
		
		JButton ordenNaturalBtn = new JButton("Natural");
		ordenNaturalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.NULL));
			}
		});
		ordenNaturalBtn.setBounds(15, 24, 103, 29);
		panelOrdenar.add(ordenNaturalBtn);
		
		JButton ordenNombreBtn = new JButton("Nombre");
		ordenNombreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.NOMBRE));
			}
		});
		ordenNombreBtn.setBounds(133, 24, 103, 29);
		panelOrdenar.add(ordenNombreBtn);
		
		JButton ordenarPABtn = new JButton("1 Apellido");
		ordenarPABtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.PRIMER_APELLIDO));
			}
		});
		ordenarPABtn.setBounds(253, 24, 115, 29);
		panelOrdenar.add(ordenarPABtn);
		
		JButton segundoApellidoBtn = new JButton("2 Apellido");
		segundoApellidoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.SEGUNDO_APELLIDO));
			}
		});
		segundoApellidoBtn.setBounds(383, 24, 106, 29);
		panelOrdenar.add(segundoApellidoBtn);
		
		JButton ordenarCiBtn = new JButton("CI");
		ordenarCiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla(ComparadoresPersona.getComparadorPersona(ComparadoresPersona.CI));
			}
		});
		ordenarCiBtn.setBounds(504, 24, 71, 29);
		panelOrdenar.add(ordenarCiBtn);
		actualizarTabla();
	}
	
	public void actualizarTabla(){
		modelo.actualizar(p.getListado());
	}
	public void actualizarTabla(Comparator<Persona> c){
		modelo.actualizar(p.getListado(),c);
	}
	public void eliminarTabla(){
		modelo.eliminarFilas();
	}
}
