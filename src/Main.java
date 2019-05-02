import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements KeyListener, ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;
	
	private Contacts contacts = new Contacts();
	private JTextField cmd;
	private JTextArea textArea;

	
	public Main() throws IOException {
		super("Prueba de Swing");
		setIconImage(ImageIO.read(getClass().getResource("exe.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar();
		
		JButton load = new JButton(new ImageIcon(getClass().getResource("load.png")));
		load.setActionCommand("LOAD");
		load.addActionListener(this);
//		load.addActionListener(new ActionListener() { //clase interna anonima
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de cargar");
//			}
//		});
		toolBar.add(load);
		
		JButton save = new JButton(new ImageIcon(getClass().getResource("save.png")));
		save.setActionCommand("SAVE");
		save.addActionListener(this);
//		save.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
//			}
//		});
		toolBar.add(save);
		
		JButton saveAs = new JButton(new ImageIcon(getClass().getResource("save-as.png")));
		saveAs.setActionCommand("SAVEAS");
		saveAs.addActionListener(this);
//		saveAs.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(Main.this, "Has pulsado el botón de guardar");
//			}
//		});
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
		cmd.addKeyListener(this);
		panel.add(cmd, BorderLayout.CENTER);
		
		JButton exec = new JButton(new ImageIcon(getClass().getResource("run.png")));
		exec.setActionCommand("EXEC");
		exec.addActionListener(this);
		panel.add(exec, BorderLayout.EAST);
//		run.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String result = contacts.exec(cmd.getText());
//				if(result != null) {
//				textArea.append(result + "\n");
//				}
//				cmd.setText("");
////				cmd.requestFocus();
//			}
//		});
//		
//		panel.add(run, BorderLayout.EAST);
		
		add(panel, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null); //para que ponga el lienzo en medio
		addWindowListener(this);
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				cmd.requestFocus();
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				int respuesta = JOptionPane.showConfirmDialog(Main.this, "¿Estás Seguro?", "Cierre de la aplicación", JOptionPane.YES_NO_OPTION);
//				if (respuesta == JOptionPane.YES_OPTION)
//					System.exit(0);
//			}
//			
//		});
	}
	
	private void exec() {
		String result = contacts.exec(cmd.getText());
		if (result != null) {
			textArea.append(result + "\n");
		}
		cmd.setText("");
//		cmd.requestFocus();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new Main().setVisible(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("LOAD")) {
			
		}
		else if (e.getActionCommand().equals("SAVE")) {
			
		}
		else if (e.getActionCommand().equals("SAVEAS")) {
			
		}
		else if (e.getActionCommand().equals("EXEC")) {
			exec();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		exec();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		cmd.requestFocus();
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		int respuesta = JOptionPane.showConfirmDialog(Main.this, "¿Estás Seguro?", "Cierre de la aplicación", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
