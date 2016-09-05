package semana3.ejemplo1.interfaz;

import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import semana3.ejemplo1.controladores.ControladorMaterias;
import semana3.ejemplo1.entidades.Materia;
import javax.swing.JScrollPane;

public class listadoMaterias extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public listadoMaterias() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(33, 11, 344, 278);
		add(table);
		
		//headers for the table
        String[] columns = new String[] { "Id", "Nombre", "Carrera"};
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
        LinkedList<Materia> materias = ControladorMaterias.obtenerMaterias();
        Object[][] datosTabla = new Object[materias.size()][3];
        int fila = 0;
        for(Materia m : materias){
        	datosTabla[fila][0] = m.getIdMateria();
        	datosTabla[fila][1] = m.getNombre();
        	datosTabla[fila][2] = m.getCarrera().getNombre();
			fila++;
        }
        
		/*
		 * Este codigo indica que las celdas no son editables y que son todas
		 * del tipos String
		 */
		DefaultTableModel model = new DefaultTableModel(datosTabla, columns) {

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
		add(new JScrollPane(table));

	}
}
