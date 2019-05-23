/*
 * Конвертер валют. Пользователь вводит сумму, выбирает две валюты и получает эквивалент во второй валюте. 
 */
public class Task1 extends javax.swing.JFrame {
    
    String[] currencyNameTable = {"USD", "EUR", "YEN", "RUB"};
    float[][] currencyRelationsTable = 
    {{1, 0.5f, 1, 60},
     {2, 1, 2, 120},
     {1, 2, 1, 60},
     {60, 120, 60, 1}
    };

    public Task1() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputTextField = new javax.swing.JTextField();
        comboBoxFirstCurrency = new javax.swing.JComboBox<String>();
        comboBoxSecondCurrency = new javax.swing.JComboBox<String>();
        outputTextField = new javax.swing.JTextField();
        applyButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Конвертер валют");
        setBounds(new java.awt.Rectangle(0, 0, 256, 256));
        setMinimumSize(new java.awt.Dimension(256, 256));
        setResizable(false);

        inputTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputTextField.setText("2000");

        comboBoxFirstCurrency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "EUR", "YEN", "RUB" }));

        comboBoxSecondCurrency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "EUR", "YEN", "RUB" }));

        outputTextField.setEditable(false);
        outputTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outputTextField.setText("2000");

        applyButton.setText("Применить");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Очистить");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputTextField)
                    .addComponent(inputTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxFirstCurrency, 0, 98, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(comboBoxSecondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFirstCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSecondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(clearButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        int firstSelected = comboBoxFirstCurrency.getSelectedIndex();
        int secondSelected = comboBoxSecondCurrency.getSelectedIndex();
        float value = Float.parseFloat(inputTextField.getText());
        
        float sum = value * currencyRelationsTable[firstSelected][secondSelected];
        outputTextField.setText(sum+"");
    }//GEN-LAST:event_applyButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        inputTextField.setText("");
        outputTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> comboBoxFirstCurrency;
    private javax.swing.JComboBox<String> comboBoxSecondCurrency;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JTextField outputTextField;
    // End of variables declaration//GEN-END:variables
}
