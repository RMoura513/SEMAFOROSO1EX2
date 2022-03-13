package view;

import java.util.concurrent.Semaphore;

import controller.Cozinha;

public class Main {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int id = 1; id < 6; id++) {
			Cozinha cozinha = new Cozinha(id, semaforo);
			cozinha.start();		
		}

	}

}
