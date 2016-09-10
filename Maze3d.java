package algorithm.mazeGenerators;

import java.util.Arrays;

public class Maze3d {
	
	private int [] [] []  maze3d;
	private int floor;//z
	private int row;//y
	private int cols;//x
	private Position start;
	private Position goal;
	
	public static final int FREE = 0;
	public static final int WALL = 1;
	
	public Maze3d(int floor,int row,int cols) {
		this.floor = floor;
		this.row = row;
		this.cols = cols;
		maze3d = new int[floor][row][cols];
	}
	
	public int[][][] getMaze3d() {
		return maze3d;
	}
	
	public void setMaze3d(int[][][] maze3d) {
		this.maze3d = maze3d;
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public Position getStart() {
		return start;
	}
	public void setStart(Position start) {
		this.start = start;
	}
	public Position getGoal() {
		return goal;
	}
	public void setGoal(Position goal) {
		this.goal = goal;
	}
	public void setFree(Position p){
		maze3d[p.z][p.y][p.x]=0;
	}
	public void setWall(Position p){
		this.maze3d[p.z][p.y][p.x]=1;
	}
	public void print()
		{
			for(int i=0;i<getFloor();i++)
			{
				for(int j=0;j<getRow();j++)
				{
					for(int k=0;k<getCols();k++)
					{
						if( i == start.z && j == start.y && k == start.x)
							System.out.print("E");
						else if(i == goal.z && j == goal.y && k == goal.x)
							System.out.print("X");
						else{
						System.out.print(maze3d[i][j][k]);	
						}
					}
			System.out.print("\n");
				}
				System.out.print("\n");
			}
		}
	public String[] getPossibleMoves(Position p)
	{
		String [] moves=new String [6];
		int count=0;
		if (maze3d[p.z+1][p.y][p.x] == FREE){
			moves[count] = "Down";
			count++;}
		if (maze3d[p.z-1][p.y][p.x] == FREE){
			moves[count] = "Up";
			count++;}
		if (maze3d[p.z][p.y+1][p.x] == FREE){
			moves[count] = "Backward";
			count++;}
		if (maze3d[p.z][p.y-1][p.x] == FREE){
			moves[count] = "Forward";
			count++;}
		if (maze3d[p.z][p.y][p.x+1] == FREE){
			moves[count] = "Right";
			count++;}
		if (maze3d[p.z][p.y][p.x-1] == FREE){
			moves[count] = "Left";
			count++;}
		String [] posMoves = Arrays.copyOf(moves,count);
	
		return posMoves;
	}
	
	public int[][] getCrossSectionByY(int y)
	{
		int [][] temp = new int [floor][cols];
		int [][][] maze = this.getMaze3d();
		if(y>=0 && y<row){
		for(int i=0;i<floor;i++){
			for(int j=0;j<cols;j++)
				temp[i][j] =maze[i][y][j];
			}
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		return temp;
	}
	public int[][] getCrossSectionByX(int x)
	{
		int [][] temp = new int [floor][row];
		int [][][] maze = this.getMaze3d();
		if(x>=0 && x<cols){
		for(int i=0;i<floor;i++){
			for(int j=0;j<row;j++)
				temp[i][j] =maze[i][j][x];
			}
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		return temp;
	}
	public int[][] getCrossSectionByZ(int z)
	{
		int [][] temp = new int [row][cols];
		int [][][] maze = this.getMaze3d();
		if(z>=0 && z<floor){
		for(int i=0;i<row;i++){
			for(int j=0;j<cols;j++)
				temp[i][j] =maze[z][i][j];
			}
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		return temp;
	}
}