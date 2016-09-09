package semana3.ejemplo1.interfaz;

import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import semana3.ejemplo1.controladores.ControladorMaterias;
import semana3.ejemplo1.entidades.Materia;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class listadoMaterias extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public listadoMaterias() {
		
		table = new JTable();
		
		table.setBackground(Color.WHITE);

		cargarTabla();
		//Se debe colocar la tabla dentro de un jscrollpane ya que sino no se ven los nombres de las columnas
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 396, 174);		 
		add(scrollPane);

		//table.setBounds(33, 11, 344, 278);
		//add(table);
		
				setLayout(null);
		
		
		JLabel lblListadoDeMaterias = new JLabel("Listado de Materias");
		lblListadoDeMaterias.setFont(new Font("Calibri", Font.BOLD, 16));
		lblListadoDeMaterias.setBounds(124, 11, 150, 14);
		add(lblListadoDeMaterias);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//JTable table =(JTable) arg0.getSource();
		        Point p = arg0.getPoint();
		        int row = table.rowAtPoint(p);
		        long idMateria = Long.parseLong( table.getModel().getValueAt(row, 0).toString() );
		        if (arg0.getClickCount() == 2) {
		            //System.out.println("Doble click"); 
		            editarMateria frame = new editarMateria(idMateria);
		            frame.setVisible(true);
		            frame.addWindowListener(new java.awt.event.WindowAdapter() {
		                @Override
		                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		                	//System.out.println("Cerro Editar");
		                	recargarPanel();
		                }
		            });
		        }
			}
		});
	}
	
	public void recargarPanel(){
		//Cargo tabla de nuevo (para que se tomen los cambios de la edición)
		cargarTabla();
		this.revalidate();
		this.repaint();
		
	}
	
	public void cargarTabla(){
		//Nombre de las columnas de la tabla
        String[] columnas = new String[] { "Id", "Nombre", "Carrera"};
            
        //Se obtienen las materias para llenar la tabla
        LinkedList<Materia> materias = ControladorMaterias.obtenerMaterias();
        /*Los datos de una tabla se pueden ver como una matriz o un doble array de objetos 
         * (ya que los campos son o numero o caraceres se especifica que el tipo de datos es un objeto genérico)*/
        Object[][] datosTabla = new Object[materias.size()][3];
        int fila = 0;
        for(Materia m : materias){
        	datosTabla[fila][0] = m.getIdMateria();
        	datosTabla[fila][1] = m.getNombre();
        	datosTabla[fila][2] = m.getCarrera().getNombre();
			fila++;
        }
        
		//Se crea un modelo para setearle a la tabla, de esta forma se indica los datos y las columnas
		DefaultTableModel model = new DefaultTableModel(datosTabla, columnas) {
			/*
			 * Este codigo indica que las celdas no son editables y que son todas
			 * del tipos String
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}
		};
		

		table.setModel(model);


	}
}
