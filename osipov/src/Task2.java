
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * Бег. Пользователь указывает количество км за каждый день в течение некоторого периода времени. 
 * Программа находит общий пробег, среднее значение в день, наименьшее и наибольшее значения. 
 */
public class Task2 extends javax.swing.JFrame {
            
    public Task2() {
        initComponents();
        distanceList.setModel(new DefaultListModel());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        distanceList = new javax.swing.JList<String>();
        generalLabel = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        maxLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        generalDistance = new javax.swing.JLabel();
        averageDistance = new javax.swing.JLabel();
        minDistance = new javax.swing.JLabel();
        maxDistance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(256, 256));
        setResizable(false);
        setSize(new java.awt.Dimension(256, 256));

        distanceList.setModel(distanceList.getModel());
        distanceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(distanceList);

        generalLabel.setText("Общий пробег:");

        averageLabel.setText("Средний пробег:");

        minLabel.setText("Наименьший:");

        maxLabel.setText("Наибольший:");

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

        generalDistance.setText("0");

        averageDistance.setText("0");

        minDistance.setText("0");

        maxDistance.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxLabel)
                            .addComponent(minLabel)
                            .addComponent(generalLabel)
                            .addComponent(averageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generalDistance)
                            .addComponent(averageDistance)
                            .addComponent(minDistance)
                            .addComponent(maxDistance)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generalLabel)
                            .addComponent(generalDistance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(averageLabel)
                            .addComponent(averageDistance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minLabel)
                            .addComponent(minDistance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxLabel)
                            .addComponent(maxDistance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(removeButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String distanceString = JOptionPane.showInputDialog(this, "Введите пробег:");
        try {   
            float distance = Float.parseFloat(distanceString);
            DefaultListModel dataset = (DefaultListModel)distanceList.getModel(); 
            dataset.addElement(distance);
            this.repaint();
            recalculateAnalytics();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка ввода!");
        }    
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selected = -1;
        if((selected = distanceList.getSelectedIndex()) != -1){
            DefaultListModel dataset = (DefaultListModel)distanceList.getModel(); 
            dataset.remove(selected);
        } else{
            JOptionPane.showMessageDialog(null, "Выберите расстояние, которое вы хотите исключить!");
        }
        recalculateAnalytics();
    }//GEN-LAST:event_removeButtonActionPerformed

    private float general, average, min, max;
    
    private void recalculateAnalytics(){
        general = 0; average = 0; min = Integer.MAX_VALUE; max = 0;
        
        DefaultListModel dataset = (DefaultListModel)distanceList.getModel();
        ArrayList<Float> data = new ArrayList();
        for(int i = 0; i < dataset.size(); i++) data.add((Float)dataset.get(i));
        data.forEach((arg)->{
            general += arg;
            if(arg < min) min = arg;
            if(arg > max) max = arg;
        });
        average = general / data.size();
        
        generalDistance.setText(general+"");
        averageDistance.setText(average+"");
        minDistance.setText(min+"");
        maxDistance.setText(max+"");
    }
    
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
            java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel averageDistance;
    private javax.swing.JLabel averageLabel;
    private javax.swing.JList<String> distanceList;
    private javax.swing.JLabel generalDistance;
    private javax.swing.JLabel generalLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maxDistance;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JLabel minDistance;
    private javax.swing.JLabel minLabel;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
