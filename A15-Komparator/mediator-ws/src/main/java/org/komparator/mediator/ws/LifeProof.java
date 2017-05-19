package org.komparator.mediator.ws;

import java.util.Timer;
import java.util.TimerTask;

import org.komparator.mediator.ws.cli.MediatorClient;
import org.komparator.mediator.ws.cli.MediatorClientException;

public class LifeProof extends TimerTask{
	public static final int period = 5000;
	Boolean isPrimary;
	MediatorClient mediaCPrimary;
	MediatorClient mediaCSecondary;
	MediatorPortImpl i;
	private boolean swapped=false;
	Timer timer;
	public void swapped(){this.swapped=true;}
	public LifeProof(MediatorPortImpl impl) throws MediatorClientException{
		this.i = impl;
		this.isPrimary = i.getPrimary();
		timer = new Timer(true);
		mediaCSecondary= new MediatorClient("http://localhost:8072/mediator-ws/endpoint");
		mediaCPrimary= new MediatorClient("http://localhost:8071/mediator-ws/endpoint");

		timer.schedule(this, 1*1000,period);

		
	}
	public void run(){
			this.isPrimary = i.getPrimary();
         if(isPrimary){  
        	 
        	//System.out.println(this.getClass() + " running...");
       	   System.out.println("\n\nRunning as Primary Mediator\n\n");
       	   
       	   if(!swapped){
	       	   try{
	           	   System.out.println("Calling Im alive");
	       		   mediaCSecondary.imAlive();
	
	       	   }catch(Exception e){
	       		   System.out.println("Couldnt call imAlive method");
	       	   }
       	   }
       	   
    	   
  	 
       } 
         else{
        	 try{
        		// System.out.println("Secondary server updating shopping history and carts\n\n\n\n");
        		// mediaCPrimary.ping("tou?");
         		 mediaCSecondary.updateShoppingHistory(mediaCPrimary.shopHistory());
           		 mediaCSecondary.updateCart(mediaCPrimary.listCarts());
        		}catch(Exception e){
        			  System.out.println("Couldnt reach primary server, taking over.\n\n\n\n\n\n");
        		      mediaCSecondary.goPrimary();	
        		      i.getMediatorEndpointManager().setWsURL("http://localhost:8071/mediator-ws/endpoint");
        		      try {
  						i.getMediatorEndpointManager().start();

						//i.getMediatorEndpointManager().publishToUDDI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

        		      this.swapped();
        		}
        	 System.out.println("Running as secondary mediator");
        	 
         }
	}
	public void kill(){
		timer.cancel();
		timer.purge();
		
	}
}
