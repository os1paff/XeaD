
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/*
 * Средняя температура.  
 * Пользователь вводит данные о температуре за некоторый период времени. 
 * Программа находит среднее значение. 
 */
public class Task3 extends javax.swing.JFrame {

    public Task3() {        
        initComponents();
        temperatureList.setModel(new DefaultListModel());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        temperatureList = new javax.swing.JList<String>();
        averageLabel = new javax.swing.JLabel();
        averageTemperature = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(256, 256));
        setResizable(false);

        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("-");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        temperatureList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(temperatureList);

        averageLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        averageLabel.setText("Средняя:");

        averageTemperature.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(averageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(averageTemperature)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(3, 3, 3)
                        .addComponent(removeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(averageLabel)
                    .addComponent(averageTemperature))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String temperatureString = JOptionPane.showInputDialog(this, "Введите пробег:");
        try {
            float distance = Float.parseFloat(temperatureString);
            DefaultListModel dataset = (DefaultListModel)temperatureList.getModel();
            dataset.addElement(distance);
            recalculateAnalytics();
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка ввода!");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selected = -1;
        if((selected = temperatureList.getSelectedIndex()) != -1){
            DefaultListModel dataset = (DefaultListModel)temperatureList.getModel();
            dataset.remove(selected);
            recalculateAnalytics();
        } else{
            JOptionPane.showMessageDialog(null, "Выберите температуру, которую нужно исключить!");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

        private float averageTemperatureFloat;
        private float generalTemperature;
        private void recalculateAnalytics(){
            averageTemperatureFloat = 0; generalTemperature = 0;
            DefaultListModel dataset = (DefaultListModel)temperatureList.getModel();
            ArrayList<Float> data = new ArrayList();
            for(int i = 0; i < dataset.size(); i++) data.add((Float)dataset.get(i));
            data.forEach((arg)->{generalTemperature += arg;});
            averageTemperatureFloat = generalTemperature / dataset.getSize();
            averageTemperature.setText(averageTemperatureFloat+"");
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Task3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel averageLabel;
    private javax.swing.JLabel averageTemperature;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JList<String> temperatureList;
    // End of variables declaration//GEN-END:variables
}
