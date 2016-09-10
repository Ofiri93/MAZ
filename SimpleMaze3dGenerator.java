package algorithm.mazeGenerators;

import java.util.Random;
//import java.util.ArrayList;

public class SimpleMaze3dGenerator extends Maze3dGeneratorBase {

	public static final int FREE = 0;
	public static final int WALL = 1;
	private Random rand = new Random();
	
	public Maze3d generate (int floor,int row,int cols)
	{		
		Maze3d maze3d = new Maze3d (floor,row,cols);
		initalize(maze3d);
		// Choose a random entrance on the bottom level, first row
		maze3d.setStart(getRandomPosition(maze3d));
		// Choose a random exit on the top level, last row
		//Position goalPos = getRandomPosition(maze3d);
		maze3d.setGoal(setSimpleMaze(maze3d));	
		return maze3d;	
	}
	private Position setSimpleMaze(Maze3d maze3d){
		Position p =maze3d.getStart();
		int [][][] temp = maze3d.getMaze3d();
		int i;
		//temp[p.z][p.y][p.x] =0;
		for (i =p.z ; i<maze3d.getFloor();i++){
			temp [i][p.y][p.x+1]=0;
		}
		
		return new Position (i-1,p.y,p.x+1);
	}
	
	private void initalize(Maze3d maze3d)
	{
		int [][][] temp = maze3d.getMaze3d();
		for(int i=0;i<maze3d.getFloor();i++)
			for(int j=0;j<maze3d.getRow();j++)
				for(int k=0;k<maze3d.getCols();k++){
					//p= new Position (i,j,k);
					//maze3d.setWall(p);
					temp[i][j][k] = 1;
					}
	}
	private Position getRandomPosition(Maze3d maze3d) {
		
		int z = rand.nextInt(maze3d.getFloor()-2)+1;
		while(z % 2 == 0) {
			z =rand.nextInt(maze3d.getFloor()-2)+1;
		}
		int y = rand.nextInt(maze3d.getRow()-2)+1;
		while(y % 2 == 0) {
			y =  rand.nextInt(maze3d.getRow()-2)+1;
		}
			
		int x =   rand.nextInt(maze3d.getCols()-2)+1;
		while(x % 2 == 0) {
			x =  rand.nextInt(maze3d.getCols()-2)+1;
		}
		return new Position (z,y,x);
	}
}