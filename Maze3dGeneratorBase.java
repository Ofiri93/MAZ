package algorithm.mazeGenerators;

public abstract class Maze3dGeneratorBase implements Maze3dGenerator {

    public String measureAlgorithmTime(int floor,int row,int cols) {
		
		long time;
		long newtime;
		time= System.currentTimeMillis();
		this.generate(floor,row,cols);
		newtime = System.currentTimeMillis() - time ;
		return String.valueOf(newtime);
	}

}
