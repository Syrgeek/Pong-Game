import java.awt.MouseInfo;
import java.awt.event.MouseEvent;

import javax.xml.ws.Service.Mode;

public class Controller{
	Model model;
	View view;
	
	void start(){
		model.ballx = 286;
		model.bally = 328;
		model.paddle = 228;	
	}
	
	void play(){
		start();
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		int initPosX = x;
		System.out.println(x + " " + y);
		int difx = 1;
		int dify = -1;
		
		
	
		while(true){
			x = MouseInfo.getPointerInfo().getLocation().x;
			y = MouseInfo.getPointerInfo().getLocation().y;
			
			//System.out.println(model.paddle + " " + x + " " + y);
			//System.out.print("ss");
			
			if( model.ballx == 0 ){
				difx = 1;
			}
			if( model.ballx == 600 ){
				difx = -1;
			}
			if(model.bally == 34){
				if(model.ballx < model.paddle || model.ballx > model.paddle+150){
					model.misses++;
					start();
					difx = 1;
					dify = -1;
				}else{
					dify = 1;
					model.hits++;
				}
			}
			if(model.bally == 382){
				dify = -1;
			}
			
			int difm = x - initPosX;
			if(difm >= 0){
				model.paddle = Math.min(460, model.paddle + difm);
			}else{
				model.paddle = Math.max(0, model.paddle + difm);
			}
			initPosX = x;
			model.ballx += difx;
			model.bally += dify;
			
			view.update(model);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}