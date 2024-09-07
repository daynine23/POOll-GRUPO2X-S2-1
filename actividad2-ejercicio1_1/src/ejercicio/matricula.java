package ejercicio;


import ejercicio.Alumno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.DefaultListModel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofía
 */
public class matricula extends javax.swing.JFrame {

    /**
     * Creates new form matricula
     */
    
    DefaultListModel<String> listaCursoPorCod;
    boolean flag;
    boolean listaCargada;
    
    public matricula() {
        initComponents();
        listaCursoPorCod = new DefaultListModel<>();
        Lista_Cursos.setModel(llenarJListCursos());
        flag = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_Cursos = new javax.swing.JList<>();
        BtnCargarDatos = new javax.swing.JButton();
        Obtener_Codigo_Alumno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlumnoName = new javax.swing.JTextPane();

        jLabel3.setText("jLabel3");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cursos Disponibles");

        jScrollPane1.setViewportView(Lista_Cursos);

        BtnCargarDatos.setText("Cargar datos");
        BtnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarDatosActionPerformed(evt);
            }
        });

        Obtener_Codigo_Alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Obtener_Codigo_AlumnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Código alumno");

        jLabel4.setText("Nombre de alumno");

        txtAlumnoName.setEditable(false);
        jScrollPane2.setViewportView(txtAlumnoName);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(Obtener_Codigo_Alumno, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(BtnCargarDatos)
                                .addGap(68, 68, 68)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Obtener_Codigo_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultListModel<String> llenarJListCursos(){
        
        List<String> fileLineList = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader("./src/ejercicio/cursosAlumnos.txt");
            BufferedReader br = new BufferedReader(fr);
         
            String d;
            while((d=br.readLine())!= null){
                    fileLineList.add(d);
            }
            br.close();
            
            
            for(int i=0; i < fileLineList.size(); i++){
                boolean duplicado = false;
                String line = fileLineList.get(i);
                String[] parts = new String[0];
                parts = line.split(",");
                
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = parts[2];
                
                
                if(listaCursoPorCod.isEmpty()){
                listaCursoPorCod.addElement(part1);
                } 
                else{
                for( int j=0; j < listaCursoPorCod.size(); j++){
                    if(Objects.equals(part1, listaCursoPorCod.getElementAt(j))){
                        duplicado = true;
                        break;
                    }
                }
                    if(!duplicado){
                    listaCursoPorCod.addElement(part1);
                    }
                }
            }
            
            
            }catch(Exception e){
            e.printStackTrace();
        }
        return listaCursoPorCod;
    }
    
    
    private void BtnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarDatosActionPerformed
        
        listaCursoPorCod.removeAllElements();
        Lista_Cursos.setModel(listaCursoPorCod);
        List<String> fileList = new ArrayList<>();
        String nombreAlumno = "";
        if(Obtener_Codigo_Alumno.getText().isEmpty()){
            showMessageDialog(null, "Porfavor ingrese el codigo de alumno!");
            return;
        }
        
        //if(!listaCargada){
        try{
            FileReader fr = new FileReader("./src/ejercicio/cursosAlumnos.txt");
            BufferedReader br = new BufferedReader(fr);
         
            String d;
            while((d=br.readLine())!= null){
                    fileList.add(d);
            }
            br.close();
            
            
            for(int i=0; i < fileList.size(); i++){
                String txtLine = fileList.get(i);
                String[] parts = new String[0];
                parts = txtLine.split(",");
                
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = parts[2];
                if(part2.equals(Obtener_Codigo_Alumno.getText())){
                    listaCursoPorCod.addElement(part1);
                    nombreAlumno = part3;
                }
            }
            
            if(listaCursoPorCod.size() == 0){
                listaCursoPorCod.addElement("Alumno no tiene cursos registrados!");
            }
            Lista_Cursos.setModel(listaCursoPorCod);
            txtAlumnoName.setText(nombreAlumno);
            //listaCargada = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
        //}
        
        
    }//GEN-LAST:event_BtnCargarDatosActionPerformed

    private void Obtener_Codigo_AlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Obtener_Codigo_AlumnoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Obtener_Codigo_AlumnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new matricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargarDatos;
    private javax.swing.JList<String> Lista_Cursos;
    private javax.swing.JTextField Obtener_Codigo_Alumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtAlumnoName;
    // End of variables declaration//GEN-END:variables
}
