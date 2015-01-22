package bg.alexander;

/**
 * 
 * @author Alexander KIRILOV
 *
 */
public enum Orientation {
	N,E,S,W;
	
	private static Orientation[] vals = values();
	
    public Orientation next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
    
    public Orientation previous()
    {
    	int ordinal = this.ordinal()-1;
    	if(ordinal<0){
    		ordinal = vals.length + ordinal;
    	}
    	
        return vals[ordinal];
    }
    
    @Override
    public String toString(){
    	switch(this){
		case N: return "N";
		case E: return "E";
		case S: return "S";
		case W: return "W";
		}
    	
		return this.toString();
    }
}
