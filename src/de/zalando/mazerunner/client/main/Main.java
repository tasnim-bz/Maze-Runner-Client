package de.zalando.mazerunner.client.main;

import de.zalando.mazerunner.client.handler.MazeRunnerHandler;

public class Main {

	public static void main(String[] args) {
		
		try{
			String mazeCode = "maze-1" ;
			MazeRunnerHandler.getStartPosition(mazeCode);
		}

	}

}
