package Inf;
import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Direction;
import java.awt.*;

public class FrogInf implements IFrog {

    private Game game;
    private Case pos;
    private Direction dir;

    public FrogInf (Game game){
        this.pos = new Case(game.width/2,1);
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
            final Game game = this.game;
            ++game.score;
            if (this.game.maxScore < this.game.score){
                this.game.maxScore = this.game.score;
                this.game.addLane();
            }
            System.out.println("up");
        }

        if (key == Direction.down && this.pos.ord > 1 ) {
            this.dir = Direction.down;
            this.pos = new Case(pos.absc,pos.ord-1);
            final Game game2 = this.game;
            --game2.score;
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

        this.game.getGraphic().add(new Element(this.pos.absc,1, Color.GREEN));
        this.game.testLose();
        this.game.testWin();
        System.out.println(this.pos.absc + " " + this.pos.ord + " score : " + this.game.score);

    }

}