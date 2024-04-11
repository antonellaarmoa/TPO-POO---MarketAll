package Menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import impl.Administrador;
import impl.Datos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Menu.Catalogo;
import javax.swing.JToggleButton;
import java.awt.Label;
import java.awt.List;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Cursor;

@SuppressWarnings({ "serial", "unused" })
public class Venta extends JDialog {
	private Administrador adm;
	private Datos objDatos;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEspePrecio;
	private JTextField textPrecioPr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Venta dialog = new Venta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Venta() {
		setForeground(new Color(95, 158, 160));
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Venta.class.getResource("/imagenes/icono_market.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Market All - Venta del Producto");
		setBounds(100, 100, 560, 569);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtEspePrecio = new JTextField();
			txtEspePrecio.setBackground(new Color(250, 240, 230));
			txtEspePrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			txtEspePrecio.setEditable(false);
			txtEspePrecio.setBounds(303, 220, 204, 64);
			contentPanel.add(txtEspePrecio);
			txtEspePrecio.setColumns(500);
		}
		{
			textPrecioPr = new JTextField();
			textPrecioPr.setEditable(false);
			textPrecioPr.setBackground(new Color(250, 240, 230));
			textPrecioPr.setBounds(321, 316, 158, 31);
			contentPanel.add(textPrecioPr);
			textPrecioPr.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Especificación del pago");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel.setBounds(336, 165, 326, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblTotal.setBounds(384, 295, 34, 14);
			contentPanel.add(lblTotal);
		}
		{
			JLabel lblSeleccionarMetodoDe = new JLabel("Seleccionar Metodo de Pago");
			lblSeleccionarMetodoDe.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblSeleccionarMetodoDe.setBounds(40, 155, 294, 23);
			contentPanel.add(lblSeleccionarMetodoDe);
		}
		
		textDatosVenta = new JTextField();
		textDatosVenta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textDatosVenta.setFont(UIManager.getFont("ToolTip.font"));
		textDatosVenta.setBackground(new Color(250, 240, 230));
		textDatosVenta.setEditable(false);
		textDatosVenta.setColumns(10);
		textDatosVenta.setBounds(40, 38, 404, 74);
		contentPanel.add(textDatosVenta);
		
		Label label = new Label("Datos del producto:");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label.setBounds(40, 10, 179, 22);
		contentPanel.add(label);
		
		
		{
			JRadioButton RBDebito = new JRadioButton("Debito");
			RBDebito.setFont(UIManager.getFont("ToolTip.font"));
			RBDebito.setBackground(new Color(255, 250, 250));
			RBDebito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtEspePrecio.setText("El valor total de la cuenta.");
					txtTotal.setText(textPrecioPr.getText());
					 GrupoRDCredito.clearSelection();
				}
			});
			//especificaciones debito
			GrupoRDMetPago.add(RBDebito); RBDebito.setBounds(56, 208, 163, 37); contentPanel.add(RBDebito);
		
		
			JRadioButton RBCredito = new JRadioButton("Credito");
			RBCredito.setFont(UIManager.getFont("ToolTip.font"));
			RBCredito.setBackground(new Color(255, 250, 250));
			
			
			JRadioButton RD2cuotas = new JRadioButton("2 cuotas");
			RD2cuotas.setFont(UIManager.getFont("ToolTip.font"));
			RD2cuotas.setBackground(new Color(255, 239, 213));
			RD2cuotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						RBCredito.setSelected(true);
						int precio = Integer.parseInt(textPrecioPr.getText());
						txtEspePrecio.setText("2 cuotas tienen un recargo del 6% del valor total de la venta");
						precio = precio + ((6* precio) /100);
						txtTotal.setText(Integer.toString(precio));
				}
			});
			GrupoRDCredito.add(RD2cuotas);
			RD2cuotas.setBounds(110, 313, 109, 37);
			contentPanel.add(RD2cuotas);
			
			JRadioButton RD3cuotas = new JRadioButton("3 cuotas");
			RD3cuotas.setFont(UIManager.getFont("ToolTip.font"));
			RD3cuotas.setBackground(new Color(255, 239, 213));
			RD3cuotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						RBCredito.setSelected(true);
						int precio = Integer.parseInt(textPrecioPr.getText());
						txtEspePrecio.setText("3 cuotas tienen un recargo del 12% del valor total de la venta.");
						precio = precio + ((12* precio) /100);
						txtTotal.setText(Integer.toString(precio));
					}
			});
			GrupoRDCredito.add(RD3cuotas);
			RD3cuotas.setBounds(110, 348, 109, 37);
			contentPanel.add(RD3cuotas);
			
			JRadioButton RD6cuotas = new JRadioButton("6 cuotas");
			RD6cuotas.setFont(UIManager.getFont("ToolTip.font"));
			RD6cuotas.setBackground(new Color(255, 239, 213));
			RD6cuotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						RBCredito.setSelected(true);
						int precio = Integer.parseInt(textPrecioPr.getText());
						txtEspePrecio.setText("6 cuotas tienen un recargo del 20% del valor total de la venta.");
						precio = precio + ((20* precio) /100);
						txtTotal.setText(Integer.toString(precio));
				}
			});
			GrupoRDCredito.add(RD6cuotas);
			RD6cuotas.setBounds(110, 378, 109, 37);
			contentPanel.add(RD6cuotas);
			GrupoRDMetPago.add(RBCredito);
			RBCredito.setBounds(56, 277, 163, 37);
			contentPanel.add(RBCredito);
		
		
			JRadioButton RBEfectivo = new JRadioButton("Efectivo");
			RBEfectivo.setFont(UIManager.getFont("ToolTip.font"));
			RBEfectivo.setBackground(new Color(255, 250, 250));
			RBEfectivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtEspePrecio.setText("Recibe un descuento del 10 % del valor total de la venta.");
					int precio=Integer.parseInt(textPrecioPr.getText());
					precio = precio - ((10* precio) /100);
					txtTotal.setText(Integer.toString(precio));
					 GrupoRDCredito.clearSelection();
				}
			});
			GrupoRDMetPago.add(RBEfectivo);
			RBEfectivo.setBounds(56, 241, 163, 37);
			contentPanel.add(RBEfectivo);
		}
		
		txtTotal = new JTextField();
		txtTotal.setBackground(new Color(250, 240, 230));
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setEditable(false);
		txtTotal.setColumns(500);
		txtTotal.setBounds(321, 382, 158, 29);
		contentPanel.add(txtTotal);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(95, 158, 160));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setBackground(new Color(250, 240, 230));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar(nombre,descripcion,pr,codigo, stT, stM);
						JOptionPane.showMessageDialog(null, "Venta confirmada.", "",
					              JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/icono_ok.png"));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(250, 240, 230));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelar();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			adm = new Administrador();
		}
	}
	
	private int pr;
	private String nombre;
	private int codigo;
	private int stM;
	private String descripcion;
	private int stT;
	
	private JTextField textDatosVenta;
	private final ButtonGroup GrupoRDMetPago = new ButtonGroup();
	private JTextField txtTotal;
	private final ButtonGroup GrupoRDCredito = new ButtonGroup();
	
	
	
	public void setdatoo(String nom,String descr,int precio, int cod, int StT, int StM){
		this.pr = precio;
		this.nombre = nom;
		this.codigo=cod;
		this.stT=StT;
		this.stM=StM;
		this.descripcion=descr;
		
		textPrecioPr.setText(Integer.toString(precio));
		textDatosVenta.setText("Nombre del producto:  "+nom+"|  Codigo:   "+ Integer.toString(cod)+"|   Stock Total:   "+Integer.toString(stT)+"|   Stock Minimo:  "+Integer.toString(stM));
		
	}
	
	public void aceptar(String nom,String descr,int precio, int cod, int StT, int StM) {
		this.pr = precio;
		this.nombre = nom;
		this.codigo=cod;
		this.stM=StM;
		this.descripcion=descr;
		this.stT=StT-1;
		objDatos = new Datos(nom,cod,precio, StT,StM,descr);
		
		this.setVisible(false);
	}
	
	public Datos getDatos() {
		return this.objDatos;
	}
	
	private void cancelar() {
		this.objDatos=null;
		this.setVisible(false);
	}
}
