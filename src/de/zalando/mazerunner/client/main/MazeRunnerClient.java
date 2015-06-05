package de.zalando.mazerunner.client.main;
import java.awt.Point;

import de.zalando.mazerunner.client.execption.MazeNotFoundException;
import de.zalando.mazerunner.client.execption.MoveNotValidException;
import de.zalando.mazerunner.client.handler.MazeRunnerHandler;


public class MazeRunnerClient {
	
	public enum DIRECTION {NORTH, WEST, SOUTH, EAST}

	/**
	 * Get the start position of the given Maze
	 * @param mazeCode
	 * @return
	 * @throws MazeNotFoundException
	 */
	public Point getStartPosition(String mazeCode) throws MazeNotFoundException{
		
		
		try {
			Point startMove= MazeRunnerHandler.getStartPosition(mazeCode);
			return startMove;
		} catch (MazeNotFoundException e) {
			throw e;
		}
		
	}
	
	/**
	 * Get the next move position  of the given Maze
	 * @param mazeCode
	 * @return
	 * @throws MazeNotFoundException
	 */
	public Point getNextMovePosition(String mazeCode,  Point currentLocation, DIRECTION direction) throws MazeNotFoundException, MoveNotValidException{
		
		
		try {
			Point nextMove=  MazeRunnerHandler.getNextMovePosition(mazeCode, currentLocation, direction);
			return nextMove;
		} catch (MazeNotFoundException e) {
			throw e;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
