package bg.alexander;

public class Tree extends YardObject{

	@Override
	public void visualize() {
		System.out.print("|T|");
	}

	@Override
	public boolean move(MoveAction action) {
		throw new UnsupportedOperationException("Trees cannot move. Unless Tree is Ent");
	}
}
