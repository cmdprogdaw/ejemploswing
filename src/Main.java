import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public Main() {
		super("Prueba de Swing");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar();
		
		JButton load = new JButton("Cargar");
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de cargar");
			}
		});
		toolBar.add(load);
		
		ImageIcon guardar = new ImageIcon("C:\\Users\\aula9\\Downloads\\guardar.png");
		JButton save = new JButton(guardar);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
			}
		});
		toolBar.add(save);
		
		JButton saveAs = new JButton("Guardar como ...");
		saveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
			}
		});
		toolBar.add(saveAs);
		
		add(toolBar, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTextField cmd = new JTextField();
		panel.add(cmd, BorderLayout.CENTER);
		
		JButton run = new JButton("Ejecutar");
		panel.add(run, BorderLayout.EAST);
		
		add(panel, BorderLayout.SOUTH);
		
		pack();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(Main.this, "¿Estás Seguro?", "Cierre de la aplicación", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			
		});
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}

}
