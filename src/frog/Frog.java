package frog;

import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IFrog;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case pos;
	private Direction dir;

	public Frog (Game game){
		this.pos = new Case(game.width/2,0);
		this.dir = Direction.up;
		this.game = game;
	}

	@Override
	public Case getPosition(){
		return this.pos;
	}

	@Override
	public Direction getDirection(){
		return this.dir;
	}

	@Override
	public void move(Direction key){

		System.out.println("move");

		if (key == Direction.up) {
			this.dir = Direction.up;
			this.pos = new Case(pos.absc,pos.ord+1);
			System.out.println("up");
		}

		if (key == Direction.down && this.pos.ord > 0 ) {
			this.dir = Direction.down;
			this.pos = new Case(pos.absc,pos.ord-1);
			System.out.println("down");
		}

		if (key == Direction.right && this.pos.absc < game.width-1 ) {
			this.dir = Direction.right;
			this.pos = new Case(pos.absc+1,pos.ord);
			System.out.println("right");
		}

		if (key == Direction.left && this.pos.absc > 0 ) {
			this.dir = Direction.left;
			this.pos = new Case(pos.absc-1,pos.ord);
			System.out.println("left");
		}

	}

}
