package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread {
	
	private int id;
	private Semaphore semaforo;
	private int Tempo;
	private String prato;
	
	public Cozinha (int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
	int pi;
	pi = (id % 2);
	
	if (pi == 0) {
		prato = "Prato #" + id + " Lasanha a bolonhesa";
		this.Tempo = (int) ((Math.random() * 601) + 600);
	}
	else {
		prato = "Prato #" + id + " Sopa de cebola";
		this.Tempo = (int) ((Math.random() * 301) + 500);
	}
	System.out.println("Preparando a " + prato + "...");
	
	PrepPrato();
	
	try {
		semaforo.acquire();
		EntregaPrato();
	} catch (InterruptedException e) {
		e.printStackTrace();
	} finally {
		semaforo.release();
	}
	
}
		
	
	public void PrepPrato() {
		
		int tempo = 0;
		int porc = 0;
		
		while (tempo < Tempo) {
			tempo += 100;
			porc = (int) (((double) tempo/Tempo) * 100);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println((porc >= 100)? "=====" + prato + " está pronto=====":
				prato + " cozinhou " + porc + "%.") ; 
			
		}
	}
	
	private void EntregaPrato() {
		
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----" + prato + " entregue.-----");
	}
	
	
	}


