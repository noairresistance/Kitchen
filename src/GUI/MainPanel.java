/*
 * CSCE 4444
 * 
 * 
 */

package GUI;

import Food.Order;
import Listeners.Navigator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import kitchen.Kitchen;

public class MainPanel extends javax.swing.JPanel 
{
    ArrayList<Order> orders;
    Kitchen kitchen;
    
    Navigator navigator = new Navigator()
    {
        void swapPanel(JPanel newPanel)
        {
            infoPanel.add(newPanel);
            infoPanel.repaint();
            infoPanel.revalidate();
        }
        
        @Override
        public void goToOrdersList()
        {
            
        }

        @Override
        public void goToOrderDetails()
        {
            
        }
    };

    
    
    /** Creates new form MainPanel */
    public MainPanel(Kitchen kitchen) 
    {
        initComponents();
        setSize(400, 520);
        this.kitchen = kitchen;
     
        //Creates a separate thread to wait for orders to be added
        Thread ordersListThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                infoPanel.add(new OrdersList(kitchen, navigator));
            }
        });
        
        ordersListThread.start();
        

        
    }
    
    public void updateOrders(ArrayList<Order> orders)
    {
        this.orders = orders;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        orderList = new javax.swing.JButton();
        callWaiter = new javax.swing.JButton();
        orderUp = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 0, 0));
        setMaximumSize(new java.awt.Dimension(400, 520));
        setPreferredSize(new java.awt.Dimension(400, 520));
        setSize(new java.awt.Dimension(400, 520));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDERS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        infoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        infoPanel.setMaximumSize(new java.awt.Dimension(388, 400));
        infoPanel.setMinimumSize(new java.awt.Dimension(388, 400));
        infoPanel.setOpaque(false);
        infoPanel.setPreferredSize(new java.awt.Dimension(388, 400));
        infoPanel.setSize(new java.awt.Dimension(388, 400));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        orderList.setText("Order List");

        callWaiter.setText("Call Waiter");

        orderUp.setText("Order Up");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(orderList, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(callWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderUp, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(orderUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(callWaiter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton callWaiter;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton orderList;
    private javax.swing.JButton orderUp;
    // End of variables declaration//GEN-END:variables

}