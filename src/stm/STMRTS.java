package stm;

public class STMRTS {

	public static <A,B> STM<B> bind(STM<A> t, {A => STM<B>} f){
		
		return new STM<B> ( {Trans t1 => 
			TResult<A> r1 = t.stm.invoke(t1);
			TResult<B> r2;
			if (r1.state == Trans.Status.ACTIVE) {
				STM<B> r3 = f.invoke(r1.result);
				r2 = r3.stm.invoke(r1.newTrans);
			} else {
				r2 = new TResult(null, r1.newTrans, r1.state);
			}
			r2
		});
	}
	
	
	public static <A,B> STM<B> then(STM<A> a, STM<B> b){
			
		return new STM<B> ( {Trans t1 => 
			TResult<A> r1 = a.stm.invoke(t1);
			TResult<B> r2;
			if (r1.state == Trans.Status.ACTIVE) {
				r2 = b.stm.invoke(r1.newTrans);
			} else {
				r2 = new TResult(null, r1.newTrans, r1.state);
			}
			r2
		});
	}
	
	
	public static STM<Void> retry(){
    	
    	return new STM<Void>( {Trans t1 => new TResult(new Void(), t1, Trans.Status.RETRY)});
    }
	
	public static <A> STM<A> stmReturn(A a){
		
		return new STM<A>({ Trans t1 => new TResult(a, t1, Trans.Status.ACTIVE)});
	}

	public static <A> A atomic(STM<A> a){

		while(true){

			try{
				Trans t = new Trans();    
				TResult<A> r = a.stm.invoke(t);
				switch(r.state){
					case RETRY:{						
						t.retry();	 	
						break;
					} 
					case ACTIVE:{
						if (t.commit()) {							
							return r.result;
						}
						break;
					}
					case ABORTED:{
						t.rollback();
						break;
					}
					default: break;
				}
			}catch(Exception e) {
				System.out.println(Thread.currentThread().getId() + " Exception "+e);
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
