package semana3.ejemplo1.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmIngresarCurso = new JMenuItem("Ingresar Curso");
		mntmIngresarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Creo el panel de altaCurso
				altaCurso panel = new altaCurso();
				//Lo seteo como contenido de la ventana
				frame.setContentPane(panel);
				//Refresca el contenido de la ventana y se muestra el nuevo panel
				frame.revalidate();
			}
		});
		mnNewMenu.add(mntmIngresarCurso);
		
		JMenuItem mntmListadoCursos = new JMenuItem("Listado Cursos");
		mntmListadoCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmListadoCursos);
	}

}
