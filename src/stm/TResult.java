package stm;

public class TResult<A>{
	
	A result;
	Trans newTrans;
	Trans.Status state;
	
	public TResult(A r, Trans t, Trans.Status s){
		result = r;
		newTrans = t;
		state = s;
	}
	
}
