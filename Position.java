package algorithm.mazeGenerators;

public class Position {
	public int x;//cols
	public int y;//row
	public int z;//floor
	
	public Position(int z,int y,int x)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		
	}
	
	public String toString() {
		return "(" + z + "," + y + "," + x + ")";
	}
	
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		return (this.z == pos.z && this.y == pos.y && this.x == pos.x);
	}
}