package kitchen;


import allclasses.*;

import java.net.SocketException;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Kitchen
{
    private Socket KitchenSkt = null; // the waiter's socket
    private ObjectInputStream ObjIn = null; // the waiter's input Stream
    private ObjectOutputStream ObjOut = null; // the waiter's ouput Stream
    private boolean Connected = false; //
    private ArrayList<Order> Orders = null;
    
    public Kitchen()
    {
        Orders = new ArrayList();   
    }
    
    // this function is used to connect the waiter to the server
    public void Handshake()
    {
        try
        {
            String Category = "Kitchen"; // a string used to tell the server what type of conncection was accepted
            KitchenSkt = new Socket("localHost", 5555); // connect to server
            System.out.println("Connected to server"); // test
            Connected  = true; // the waiter is connected to the server
            
            // create input and output stream so that the waiter can communicate with the server
            ObjOut = new ObjectOutputStream(KitchenSkt.getOutputStream());
            ObjOut.flush();
            ObjIn = new ObjectInputStream(KitchenSkt.getInputStream());
            
            // launch reading thread
            Thread Listening = new Thread(new ListeningThread());
            Listening.start();
            
            System.out.println("Sending Category"); // test
            ObjOut.writeUTF(Category);
            ObjOut.flush();
      
            Thread.sleep(100); // test
        }
        catch(Exception e)
        {
            System.out.println("Error connection to server");
        }
    }
    
    public void CloseConnection()
    {
        try
        {
            ObjOut.close();
            ObjIn.close();
            KitchenSkt.close();
        }
        catch(IOException e)
        {
            System.out.println("Error closing the connection.");
        }
    }
    
    public class ListeningThread implements Runnable
    {
        @Override
        public void run()
        {
            String Message;
            
            try
            {
                while((Message = ObjIn.readUTF())!= null)
                {
                    System.out.println(Message);
                    
                    if(Message.equals("Placed")) // an order was placed so prepare to recieve order
                    {
                        System.out.println("About to receive order.");
                        
                        // read the order 
                        Order tempOrder = (Order)ObjIn.readObject();
                        
                        //Orders[tempOrder.GetTableNum()-1] = tempOrder;
                        // test loop checking contents
                        for(int i = 0; i < tempOrder.GetOrderSize(); i++)
                        {
                            System.out.println(tempOrder.GetItem(i).GetName());
                            System.out.println(((Food)tempOrder.GetItem(i)).GetIngredients(0));
                        }
                        // add order to list of orders
                    }
                    else if(Message.equals("Shutdown"))
                    {
                        break;
                    }
                }
                
                Connected = false;
            }
            catch(Exception e)
            {
                System.out.println("Failed to receive message from server.");
            }
        }
    }
      
    // test function used to prevent immediate execution of functions
    public void waittest()
    {
        try 
        {
            Thread.sleep(4000);
        } catch (InterruptedException ex) 
        {
            System.out.println("Error in test sleep thread" + ex);
        }
    }
    
    public void printOrders()
    {
        
    }
    
    public static void main(String argv[])
    {
        // test cases
        Kitchen newKitchen = new Kitchen();
        newKitchen.Handshake();
        
    }
}
