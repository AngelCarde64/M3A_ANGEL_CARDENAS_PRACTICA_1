package Controlador;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloPersona;
import Modelo.Persona;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import Vista.VistaPersona;

public class ControllerPersona {

    private ModeloPersona modelo;
    private VistaPersona vista;
    private JFileChooser jfc;
    private int i;
    private String id_persona = "", criterio = "";

    public ControllerPersona(ModeloPersona modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.getLblAlerta1().setVisible(false);
        CargarPersonas();
    }

    public void iniciaControl() {
        vista.getBtnActualizar().addActionListener(l -> CargarPersonas());
        //Buttoms pantalla principal
        vista.getBtnBuscar().addActionListener(l -> buscar());
        vista.getBtnCrear().addActionListener(l -> abrirDialogo(1));
        vista.getBtnEditar().addActionListener(l -> abrirDialogo(2));
        //Buttoms pantalla secundaria
        vista.getBtnAceptar().addActionListener(l -> crearEditarPersona());
        vista.getBtnCancelar().addActionListener(l -> cancelar());
        //Abrir examinar java
        vista.getBtnExaminar().addActionListener(l -> examinarFoto());
        //Recuperar datos de la tabla para moificar
        vista.getTblPersonas().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verIdDatos(evt);
            }
        });

        vista.getBtnEliminar().addActionListener(l -> eliminar());

        //busqueda invremental
        vista.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar();
            }
        });
    }

    private void CargarPersonas() {
        // Control para consultar al modelo
        // Y luego en la vista
        vista.getTblPersonas().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblPersonas().setRowHeight(50);

        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getTblPersonas().getModel();
        mTabla.setNumRows(0);

        List<Persona> listap = modelo.getListaPersonas();
        i = 0;

        // Uso de una expresion landa
        listap.stream().forEach(pe -> {
            String[] filaNueva = {pe.getIdPersona(), pe.getNombre(), pe.getApellido(),
                pe.getFechanacimiento().toString(), pe.getTelefono(), pe.getSexo(), String.valueOf(pe.getSueldo()),
                String.valueOf(pe.getCupo())};
            mTabla.addRow(filaNueva);
//            //Llenar imagen
            Image foto = pe.getFoto();
            if (foto != null) {
                foto = foto.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                vista.getTblPersonas().setValueAt(new JLabel(icono), i, 8);
            } else {
                vista.getTblPersonas().setValueAt(null, i, 8);
            }

            i = i + 1;
        });
    }

    private void verIdDatos(java.awt.event.MouseEvent evt) {
        id_persona = "";
        DefaultTableModel tm = (DefaultTableModel) vista.getTblPersonas().getModel();

        id_persona = String.valueOf(tm.getValueAt(vista.getTblPersonas().getSelectedRow(), 0));
    }

    private void cancelar() {
        vista.getDlgPersona().dispose();
        id_persona = "";
    }
    
    //Carga los datos en la pantalla editar
    private void cargarDatos() {
        ModeloPersona persona = new ModeloPersona();
        persona = persona.getPersonaEditar(id_persona);

        vista.getTxtDni().setText(persona.getIdPersona());
        vista.getTxtNombre().setText(persona.getNombre());
        vista.getTxtApellido().setText(persona.getApellido());
        vista.getJdcFechaNac().setDate(persona.getFechanacimiento());
        vista.getTxtTelefono().setText(persona.getTelefono());
        vista.getjComboBoxSexo().setSelectedItem(persona.getSexo());
        vista.getTxtSueldo().setText(persona.getSueldo() + "");
        vista.getTxtCupo().setText(persona.getCupo() + "");
        
        Image foto = persona.getFoto();

        if (foto != null) {
            foto = foto.getScaledInstance(90, 120, Image.SCALE_SMOOTH);
            ImageIcon icono = new ImageIcon(foto);
            vista.getLbl_foto().setIcon(icono);
        } else {
            vista.getLbl_foto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Caballo.jpg")));
        }
    }

    /**
     * ---> Para abrir un dialogo de editar o crear la persona
     */
    private void abrirDialogo(int op) {
        String titulo;
        if (op == 1) {
            titulo = "Crear Persona";
            vista.getDlgPersona().setName("C");
            vista.getTxtDni().setEnabled(true);
            activarJdialog(titulo);
        } else {
            if (id_persona.equals("")) {
                JOptionPane.showMessageDialog(vista, "Seleccione una persona");
            } else {
                titulo = "Editar Persona";
                vista.getDlgPersona().setName("E");
                vista.getTxtDni().setEnabled(false);
                activarJdialog(titulo);
                cargarDatos();
                id_persona = "";
            }
        }
    }
    
    private void examinarFoto() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, png & jpeg", "jpeg", "png", "jpg");

        jfc = new JFileChooser();
        jfc.setFileFilter(filter);
        int estado = jfc.showOpenDialog(vista);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLbl_foto().getWidth(),
                        vista.getLbl_foto().getHeight(),
                        Image.SCALE_DEFAULT);
                Icon icono = new ImageIcon(imagen);
                vista.getLbl_foto().setIcon(icono);
                vista.getLbl_foto().updateUI();
                vista.getDlgPersona().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void crearEditarPersona() {
        //registrar
        if (datosNoVacios()) {
            if (vista.getDlgPersona().getName().contentEquals("C")) {
                ModeloPersona persona = new ModeloPersona();
                persona = recuperarDatos(persona);
                if (persona.setPersonaFoto()) {
                    JOptionPane.showMessageDialog(null,
                            "Persona creada satisfactoriamente.");
                    limpiarDatos();
                    vista.getDlgPersona().dispose();
                    CargarPersonas();
                } else {
                    JOptionPane.showMessageDialog(vista,
                            "No se pudo crear persona error id repetido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Faltan datos");
        }

        if (vista.getDlgPersona().getName().contentEquals("E")) {
            if (datosNoVacios()) {
                ModeloPersona persona = new ModeloPersona();
                persona = recuperarDatos(persona);

                if (persona.ActualizarDatos()) {
                    JOptionPane.showMessageDialog(null,
                            "Persona Modificada satisfactoriamente.");
                    limpiarDatos();
                    vista.getDlgPersona().dispose();

                    CargarPersonas();
                } else {
                    JOptionPane.showMessageDialog(vista,
                            "No se pudo Modificar persona error base");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "No se puede editar faltan datos");
            }
        }
    }

    private void eliminar() {
        if (id_persona.equals("")) {
            JOptionPane.showMessageDialog(vista, "Selecciona una persona");

        } else {
            int respuesta = 0;

            respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminar!", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {

                ModeloPersona persona = new ModeloPersona(id_persona, null, null, null, null, null, 0, 0);

                if (persona.deletePersona() == null) {
                    JOptionPane.showMessageDialog(vista, "Registro Eliminado");
                    id_persona = "";
                    CargarPersonas();
                } else {
                    JOptionPane.showMessageDialog(vista, "El registro no se elimino");
                    id_persona = "";
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Cancelado");
                id_persona = "";
            }
        }
    }

    private boolean datosNoVacios() {
        return !vista.getTxtDni().getText().equals("") && !vista.getTxtNombre().getText().equals("") && !vista.getTxtApellido().getText().equals("")
                && !vista.getJdcFechaNac().toString().equals("") && !vista.getTxtTelefono().getText().equals("") && !vista.getjComboBoxSexo().getSelectedItem().equals("") && !vista.getTxtSueldo().getText().equals("") && !vista.getTxtCupo().getText().equals("");
    }

    //Recupera los datos para ser modificados o creados
    private ModeloPersona recuperarDatos(ModeloPersona persona) {
        //INSERT
        String identificacion = vista.getTxtDni().getText();
        String nombres = vista.getTxtNombre().getText();
        String apellidos = vista.getTxtApellido().getText();
        Date fechaNac = vista.getJdcFechaNac().getDate();
        String telefono = vista.getTxtTelefono().getText();
        String sexo = vista.getjComboBoxSexo().getSelectedItem().toString();
        int sueldo = Integer.parseInt(vista.getTxtSueldo().getText());
        int cupo = Integer.parseInt(vista.getTxtCupo().getText());

        try {
            FileInputStream img
                    = new FileInputStream(jfc.getSelectedFile());
            int largo = (int) jfc.getSelectedFile().length();
            persona.setImageFile(img);
            persona.setLength(largo);

        } catch (IOException ex) {
            Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        persona.setIdPersona(identificacion);
        persona.setNombre(nombres);
        persona.setApellido(apellidos);
        persona.setFechanacimiento(fechaNac);
        persona.setTelefono(telefono);
        persona.setSexo(sexo);
        persona.setSueldo(sueldo);
        persona.setCupo(cupo);

        return persona;
    }

    private void buscar() {
        criterio = vista.getTxtBuscar().getText().trim();

        if (!criterio.equals("")) {
            llenarTablaBusqueda();
        } else {
            vista.getLblAlerta1().setVisible(false);
            CargarPersonas();
        }
    }

    private void llenarTablaBusqueda() {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vista.getTblPersonas().getModel();
        estructuraTabla.setNumRows(0);
        List<Persona> listap = modelo.getPersonasBuscar(criterio);
        i = 0;

        if (!listap.isEmpty()) {

            vista.getLblAlerta1().setVisible(false);

            listap.stream().forEach(persona -> {
                estructuraTabla.addRow(new Object[3]);
                vista.getTblPersonas()
                        .setValueAt(persona.getIdPersona(),
                                i, 0);
                vista.getTblPersonas()
                        .setValueAt(persona.getNombre(),
                                i, 1);
                vista.getTblPersonas()
                        .setValueAt(persona.getApellido(),
                                i, 2);
                vista.getTblPersonas()
                        .setValueAt(persona.getFechanacimiento(),
                                i, 3);
                vista.getTblPersonas()
                        .setValueAt(persona.getTelefono(),
                                i, 4);
                vista.getTblPersonas()
                        .setValueAt(persona.getSexo(),
                                i, 5);
                vista.getTblPersonas()
                        .setValueAt(persona.getSueldo(),
                                i, 6);
                vista.getTblPersonas()
                        .setValueAt(persona.getCupo(),
                                i, 7);
                //Llenar imagen
                Image foto = persona.getFoto();
                if (foto != null) {
                    foto = foto.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
                    ImageIcon icono = new ImageIcon(foto);
                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                    dtcr.setIcon(icono);
                    vista.getTblPersonas().setValueAt(new JLabel(icono), i, 8);

                } else {
                    vista.getTblPersonas().setValueAt(null, i, 8);
                }
                i = i + 1;
            });
        } else {
            vista.getLblAlerta1().setVisible(true);
        }
    }

    private void activarJdialog(String titulo) {
        vista.getDlgPersona().setTitle(titulo);
        vista.getDlgPersona().setSize(680, 330);
        vista.getDlgPersona().setLocationRelativeTo(vista);
        vista.getDlgPersona().setVisible(true);
    }

    private void limpiarDatos() {
        vista.getTxtDni().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtTelefono().setText("");
        vista.getjComboBoxSexo().setSelectedItem(1);
        vista.getTxtSueldo().setText("");
        vista.getTxtCupo().setText("");
    }
}
