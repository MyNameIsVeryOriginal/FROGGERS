package environment;

import java.awt.Color;

import gameCommons.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {

	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)

	public Car (Game game, Case leftPosition ,boolean leftToRight){
		this.game = game;
		this.leftToRight = leftToRight;
		this.length = (int) ((Math.random()*((3-1)+1))+1); //g�n�re un int entre 1 et 3
		this.leftPosition = new Case(leftToRight ? leftPosition.absc - this.length : leftPosition.absc, leftPosition.ord);
	}

	//TODO : ajout de methodes

public void move(boolean b) {
	if (b) {
		this.leftPosition = new Case(this.leftPosition.absc + (this.leftToRight ? 1 : -1), this.leftPosition.ord);
	}
	this.addToGraphics();
}

	public Case getLeftPosition(Case pos){
		return this.leftPosition = pos;
	}

	public boolean caseVide (Case pos) {
		if (pos.ord != this.leftPosition.ord) {
		return false;
		} else {
		return pos.absc >= this.leftPosition.absc && pos.absc < this.leftPosition.absc + this.length;
		}
	}

	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/

	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic().add(new Element(leftPosition.absc + i, leftPosition.ord - this.game.score, color));
		}
	}

	public boolean appearsInBounds() {
		return this.leftPosition.absc + this.length > 0 || this.leftPosition.absc < this.game.width;
	}

}
