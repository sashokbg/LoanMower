package bg.alexander;

public class GrassTile extends YardObject{
	private YardObject object = null; 
	private boolean isCutDown;

	public GrassTile() {
		setCutDown(false);
	}
	
	public boolean isEmpty() {
		return object == null ? true : false;
	}

	public void set(YardObject object){
		this.object = object;
	}
	
	/**
	 * Visualize an empty grass tile, or if any yard object is place on top - visualize it instead
	 */
	@Override
	public void visualize() {
		if(isEmpty()){
			System.out.print("|*|");
		}
		else{
			object.visualize();
		}
	}

	@Override
	public boolean move(MoveAction action) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCutDown() {
		return isCutDown;
	}

	public void setCutDown(boolean isCutDown) {
		this.isCutDown = isCutDown;
	}
}
