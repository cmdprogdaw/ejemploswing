import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements KeyListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Contacts contacts = new Contacts();
	private JTextField cmd;
	private JTextArea textArea;

	public Main() {
		super("Prueba de Swing");
//		setIconImage(ImageIO.read(getClass))
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar();
		
		JButton load = new JButton(new ImageIcon(getClass().getResource("load.png")));
		load.addActionListener(this);
//				new ActionListener() { //clase interna anonima
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de cargar");
//			}
//		});
		toolBar.add(load);
		
		JButton save = new JButton(new ImageIcon(getClass().getResource("save.png")));
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
			}
		});
		toolBar.add(save);
		
		JButton saveAs = new JButton(new ImageIcon(getClass().getResource("save-as.png")));
		saveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
			}
		});
		toolBar.add(saveAs);
		
		add(toolBar, BorderLayout.NORTH);
		
		textArea = new JTextArea(30, 80);
		textArea.setEditable(false); //para que no se pueda escribir en el
		textArea.setFocusable(false); //no puede recibir el foco de teclado
		add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
//		panel.add(new JLabel(" Comando: "), BorderLayout.WEST);
		
		cmd = new JTextField();
		cmd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
			}
		});
		panel.add(cmd, BorderLayout.CENTER);
		
		JButton run = new JButton(new ImageIcon(getClass().getResource("run.png")));
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = contacts.exec(cmd.getText());
				if(result != null) {
				textArea.append(result + "\n");
				}
				cmd.setText("");
//				cmd.requestFocus();
			}
		});
		
		panel.add(run, BorderLayout.EAST);
		
		add(panel, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null); //para que ponga el lienzo en medio
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				cmd.requestFocus();
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(Main.this, "¿Estás Seguro?", "Cierre de la aplicación", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			
		});
	}
	
	private void exec() {
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
