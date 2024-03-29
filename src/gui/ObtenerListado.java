package gui;

import businessLogic.FacadeImplementationWS;
import com.db4o.ObjectSet;
import domain.Cuenta;
import domain.Operacion;
import domain.Sucursal;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

public class ObtenerListado extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldDni;
    private JTextField textFieldDestino;
    private JTextField textFieldCantidad;
    private JComboBox op = null;
    /*private JList o =null;
    private JPanel jContentPane=null;
    private JLabel jLabel = null;
    private JScrollPane oScrollPane = null;
    private JLabel searchResult = null;*/

    private String DNI;
    private Cuenta cuentaorigen;
    private int cuentadestino;
    private float cantidad;
    protected Component frame;
    private JList list;
    private DefaultComboBoxModel c = new DefaultComboBoxModel();
    private Collection coleccion;
    FacadeImplementationWS facade = new FacadeImplementationWS();

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */

    public ObtenerListado() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


		this.setSize(1243, 1205);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        setVisible(true);

        setLabels();
        getOp();
      /*  {
        	JList list = new JList();
        	list.setBounds(36, 405, 1125, 612);
        	contentPane.add(list);
        	
        	
        }
        /*getO();
        setContentPane(getJContentPane());*/

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (true) {
                	coleccion = facade.GetOperaciones("Gros");
                	/*
                	 DefaultListModel dm = new DefaultListModel();
                	for (int i=0; i< coleccion.size(); i++)
                		dm.addElement(coleccion);
                		*/
                    //coleccion = facade.GetOperaciones("Gros");
                    for (Object v : coleccion) c.addElement(v);
                    
           //         list.setModel(dm);
                    
                    

                   // JOptionPane.showMessageDialog(coleccion, "Hola mundo");
                    /*coleccion = facade.GetTransferencias(fecha);
                    for (Object v : coleccion) c.addElement(v);*/
                }

            }

            @Override
            public void windowClosing(WindowEvent e) {

                if (true) {

                    int res = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro que quieres descartar los cambios?", null, JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION)
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    else
                        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

                } else
                    dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });

    }

    private void setLabels() {
        JLabel lblHacerTransferencia = new JLabel("Obtener Listado");
        lblHacerTransferencia.setFont(new Font("Courier 10 Pitch", Font.BOLD, 24));
        lblHacerTransferencia.setBounds(158, 12, 293, 47);
        contentPane.add(lblHacerTransferencia);

        JLabel lblDni = new JLabel("Listado de Operaciones");
        lblDni.setBounds(36, 137, 415, 47);
        contentPane.add(lblDni);


    }

    private JComboBox getOp() {
        if (op == null) {
            op = new JComboBox();
            op.setBounds(36, 211, 1125, 124);
            contentPane.add(op);
            op.setModel(c);
            /*op.addActionListener(new  ActionListener() {


                public void actionPerformed(ActionEvent e) {

                    if (op.getItemCount() !=0){
                        cuentaorigen = (Operacion) op.getSelectedItem();


                    }
                }
            });

        }*/

        }
        return op;
    }
}