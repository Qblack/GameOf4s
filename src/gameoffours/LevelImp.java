/**
 * 
 */
package gameoffours;
/**
 * @author Q
 *
 */
public class LevelImp implements Level {
	
	
	public float levelValue;
	public boolean solved = false;
	public int difficulty;
	
	public LevelImp(int solutionValue){
		this.levelValue=solutionValue;
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Level#IsSolved()
	 */
	public boolean IsSolved(){
		return this.solved;
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Level#GetValue()
	 */
	public float GetValue(){
		return this.levelValue;
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Level#GetDifficulty()
	 */
	public int GetDifficulty(){
		return this.difficulty;
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Level#SetSolved(boolean)
	 */
	public void SetSolved(boolean solved){
		this.solved = solved;
	}
}
