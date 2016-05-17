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

public class ObtenerListado extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldDni;
    private JTextField textFieldDestino;
    private JTextField textFieldCantidad;
    private JComboBox op = null;
    private String DNI;
    private Cuenta cuentaorigen;
    private int cuentadestino;
    private float cantidad;
    protected Component frame;
    private DefaultComboBoxModel c = new DefaultComboBoxModel();
    private Collection coleccion;
    FacadeImplementationWS facade = new FacadeImplementationWS();

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */



    private void setLabels() {
        JLabel lblHacerTransferencia = new JLabel("Obtener Listado");
        lblHacerTransferencia.setFont(new Font("Courier 10 Pitch", Font.BOLD, 24));
        lblHacerTransferencia.setBounds(80, 12, 293, 47);
        contentPane.add(lblHacerTransferencia);

        JLabel lblDni = new JLabel("Listado de Operaciones y Transferencias");
        lblDni.setBounds(36, 137, 213, 15);
        contentPane.add(lblDni);


    }


    public ObtenerListado() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 473, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        this.setSize(671, 649);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        setLabels();
        getOp();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (true) {

                    coleccion = facade.GetOperaciones("Gros");
                    for (Object v : coleccion) c.addElement(v);

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
    private JComboBox getOp() {
        if (op == null) {
            op = new JComboBox();
            op.setBounds(269, 184, 914, 24);
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

