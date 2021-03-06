/*
 * CSCE 4444
 * 
 * 
 */
package GUI;

import Food.Food;
import Food.Order;
import Listeners.Navigator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import kitchen.Kitchen;

public class OrderDetails extends javax.swing.JPanel
{
    Kitchen kitchen;
    //Navigator navigator;

    /**
     * Creates new form OrderDetails
     */
    public OrderDetails(Kitchen kitchen)
    {
        initComponents();
        this.kitchen = kitchen;
        setSize(388, 400);
        
        //Print out ordered food items and their ingrediants
        //This only looks at the 0th index of Orders
        for(Food item : kitchen.getOrders().get(0).getFoodItem())
        {
            add(new JLabel("  " + item.GetName()));
            
            for(String i : item.getIngredientList())
            {
                add(new JLabel("  " + i));
            }
            add(new JLabel("                                    "));
            
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
