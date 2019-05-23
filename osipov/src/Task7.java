
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import task7.RotatingComponent;

/*
 * Изобразить на форме отрезок, который вращается вокруг своей концевой точки. 
 * Вокруг произвольной своей точки. 
 * Вокруг произвольной точки плоскости. 
 */
public class Task7 extends javax.swing.JFrame {
    private final int MODE_POINT = 1; 
    private final int MODE_SEGMENT = 2; 
    private final int MODE_FREE = 3; 

    int mode = MODE_FREE;
    int x = 50, y = 50;
    RotatingComponent rotatingSegment;
    
    public Task7() {
        initComponents();
        setLocationRelativeTo(null);
        canvas.add(rotatingSegment = new RotatingComponent(canvas, new Point(x, y)));
        radioPoint.addActionListener((ActionEvent e) -> {
            mode = MODE_POINT;
        });
        radioSegment.addActionListener((ActionEvent e) -> {
            mode = MODE_SEGMENT;
        });
        radioFreePlace.addActionListener((ActionEvent e) -> {
            mode = MODE_FREE;
        });
        startPointLabel.setText("X: "+rotatingSegment.leftVertex.x + " Y: "+rotatingSegment.leftVertex.y);
        endPointLabel.setText("X: "+rotatingSegment.rightVertex.x + " Y: "+rotatingSegment.rightVertex.y);
        
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            rotatingSegment.setCenterOfRotation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPreferrencesGroup = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        canvas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        radioPoint = new javax.swing.JRadioButton();
        radioSegment = new javax.swing.JRadioButton();
        radioFreePlace = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        xField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        yField = new javax.swing.JTextField();
        accept = new javax.swing.JButton();
        startPointLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        endPointLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(512, 256));
        setResizable(false);

        canvas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Центр вращения"));

        centerPreferrencesGroup.add(radioPoint);
        radioPoint.setText("На одном из концов");

        centerPreferrencesGroup.add(radioSegment);
        radioSegment.setText("На отрезке");

        centerPreferrencesGroup.add(radioFreePlace);
        radioFreePlace.setText("В произвольном месте");

        jLabel1.setText("X:");

        xField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        xField.setText("50");

        jLabel2.setText("Y:");

        yField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        yField.setText("50");

        accept.setText("Принять");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        startPointLabel.setText("X: 0 Y: 0");

        jLabel3.setText("Начало отрезка:");

        jLabel5.setText("Конец отрезка:");

        endPointLabel.setText("X: 0 Y: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(accept))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radioPoint)
                            .addComponent(radioSegment)
                            .addComponent(radioFreePlace)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startPointLabel)
                                    .addComponent(endPointLabel))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioPoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioSegment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioFreePlace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(startPointLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(endPointLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(accept))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        if(ensureValid()){
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            rotatingSegment.setCenterOfRotation(x, y);
        }
    }//GEN-LAST:event_acceptActionPerformed

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
            java.util.logging.Logger.getLogger(Task7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task7().setVisible(true);
            }
        });
    }
    
    private boolean ensureValid(){
        boolean decision;
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        
        Point first = rotatingSegment.leftVertex;
        Point second = rotatingSegment.rightVertex;
        switch(mode){
            case MODE_POINT:
                boolean isFirstPoint = (x == first.x && y == first.y);
                boolean isSecondPoint = (x == second.x && y == second.y);
                
                System.out.println("x: "+x+" y: "+y);
                System.out.println("first.x: "+first.x+" first.y: "+first.y);
                System.out.println("second.x: "+second.x+" second.y: "+second.y);
                System.out.println("isFirstPoint: "+ isFirstPoint);
                System.out.println("isSecondPoint: "+ isSecondPoint);
                if(isFirstPoint || isSecondPoint) decision = true;
                else {
                    decision = false;
                    JOptionPane.showMessageDialog(null, "Указанная точка не совпадает ни с одним из концов отрезка");
                }
                break;
            case MODE_SEGMENT:   
                if((x > first.x && x < second.x) && y == first.y)  decision = true;                
                else {
                    decision = false;
                    JOptionPane.showMessageDialog(null, "Указанная точка не лежит на отрезке");
                }
                break;
            case MODE_FREE:
                decision = true;
                break;
            default:
                decision = false;                
        }
        return decision;
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JPanel canvas;
    private javax.swing.ButtonGroup centerPreferrencesGroup;
    private javax.swing.JLabel endPointLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton radioFreePlace;
    private javax.swing.JRadioButton radioPoint;
    private javax.swing.JRadioButton radioSegment;
    private javax.swing.JLabel startPointLabel;
    private javax.swing.JTextField xField;
    private javax.swing.JTextField yField;
    // End of variables declaration//GEN-END:variables
}
