package gameoffours;

public interface Level {

	public abstract boolean IsSolved();

	public abstract float GetValue();

	public abstract int GetDifficulty();

	public abstract void SetSolved(boolean solved);

}