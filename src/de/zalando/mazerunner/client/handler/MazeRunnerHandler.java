package de.zalando.mazerunner.client.handler;

import java.awt.Point;

import de.zalando.mazerunner.client.api.RestClientApi;
import de.zalando.mazerunner.client.execption.MazeNotFoundException;
import de.zalando.mazerunner.client.execption.MoveNotValidException;
import de.zalando.mazerunner.client.main.MazeRunnerClient;
import de.zalando.mazerunner.client.main.MazeRunnerClient.DIRECTION;

import org.json.simple.JSONObject;


public class MazeRunnerHandler {
	

	/**
	 * Return the start position of a given maze
	 * @param mazeCode
	 * @return
	 */
	public static Point getStartPosition(String mazeCode) throws MazeNotFoundException {
		
		String response = RestClientApi.executeGetRequest( MazeRunnerHandler.buildStartPositionRequest(mazeCode) );
		if(response== String.valueOf(404)){
			throw new MazeNotFoundException("the maze is not found");
		}
	
		return MazeRunnerHandler.getStartPositionResponse( response);
	}
	
	
	
	/**
	 * Build the get start position response
	 * @param response
	 * @return
	 */
	private static  Point getStartPositionResponse(String response){
		
		//here decode the json response and return the point coordinates
	
		return new Point(0,1);
	}
	
	/**
	 * Build the get start position request
	 * @param mazeCode
	 * @return
	 */
	private static  String buildStartPositionRequest(String mazeCode){
		
		StringBuffer request = new StringBuffer();
		request.append("/mazes/");
		request.append(mazeCode);
		request.append("/position/start");
		return request.toString();
	}
	
	
	/**
	 * Return the next move position of a given maze
	 * @param mazeCode
	 * @return
	 */
	public static Point getNextMovePosition(String mazeCode, Point currentLocation, MazeRunnerClient.DIRECTION direction) throws MazeNotFoundException, MoveNotValidException {
		
		 JSONObject jsonData = new JSONObject();
		 jsonData.put("from", currentLocation);
		 jsonData.put("direction", direction);
		String response = RestClientApi.executePostRequest( MazeRunnerHandler.buildNextMovePositionRequest(mazeCode), jsonData.toString() );
		
		
		if(response== String.valueOf(404)){
			throw new MazeNotFoundException("the maze is not found");
		}
		
		if(response== String.valueOf(418)){
			throw new MoveNotValidException("The move is not valid");
		}
		return MazeRunnerHandler.getNextMovePositionResponse( response);
	}
	
	
	
	/**
	 * Build the get next move position response
	 * @param response
	 * @return
	 */
	private static  Point getNextMovePositionResponse(String response){
		
		//here decode the json response and return the point coordinates
	
		return new Point(0,1);
	}
	
	/**
	 * Build the get next move position request
	 * @param mazeCode
	 * @return
	 */
	private static  String buildNextMovePositionRequest(String mazeCode ){
		
		StringBuffer request = new StringBuffer();
		request.append("/mazes/");
		request.append(mazeCode);
		request.append("/position/start");
		return request.toString();
	}

}
