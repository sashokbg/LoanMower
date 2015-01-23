package bg.alexander;

/**
 * Enum d'orientation
 * 
 * Implément next() et previous() méthodes pour facilité les opérations de tournage
 * 
 * @author Alexander KIRILOV
 *
 */
public enum Orientation {
	N,E,S,W;
	
	private static Orientation[] vals = values();
	
	/**
	 * Exemple: le next() de N est E
	 * 
	 * @return La position suivante sur la boussole dans le sens des aiguilles d'une montre
	 */
    public Orientation next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
    
    /**
     * Exemple: le previous() de N est W
     * 
     * @return La position précédente sur la boussole dans le sens en sens inverse des aiguilles d'une montre
     */
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
