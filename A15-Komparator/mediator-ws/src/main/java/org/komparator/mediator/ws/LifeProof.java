package org.komparator.mediator.ws;

import java.util.Timer;
import java.util.TimerTask;

import org.komparator.mediator.ws.cli.MediatorClient;
import org.komparator.mediator.ws.cli.MediatorClientException;

public class LifeProof extends TimerTask{
	Boolean isPrimary;
	MediatorClient mediaC;
	Timer timer;
	public LifeProof(MediatorPortImpl impl) throws MediatorClientException{
		this.isPrimary = impl.getPrimary();
		timer = new Timer(true);
		mediaC= new MediatorClient("http://localhost:8072/mediator-ws/endpoint");
		timer.schedule(this, 1*1000,5*1000);

		
	}
	public void run(){
         if(isPrimary){  
        	System.out.println(this.getClass() + " running...");
       	   System.out.println("Calling Im alive");
    	   mediaC.ping("Test");
       	   mediaC.imAlive();
    	   
  	 
       } 
         else{
        	 System.out.println("Running as secondary mediator");
        	 
         }
	}
	public void kill(){
		timer.cancel();
		timer.purge();
		
	}
}
