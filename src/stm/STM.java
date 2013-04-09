package stm;

public class STM<A>{
	
	{Trans => TResult} stm;
	
	public STM({Trans => TResult} stm){
		this.stm = stm;
	}
}
