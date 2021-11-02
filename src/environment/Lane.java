package environment;

import java.util.ArrayList;
import gameCommons.Case;
import gameCommons.Game;
import java.util.Iterator;

public class Lane {

	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)

	public Lane (Game game, int ord, double density){
		this.game = game;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
		this.cars = new ArrayList<>();
		this.ord = ord;

		for (int i = 0; i < 40; ++i) {
			this.moveCars(true);
			this.mayAddCar();
		}
	}

	public Lane (Game game, int ord) {
		this(game, ord, game.defaultDensity);
	}

	public void moveCars (boolean c){
		Iterator var4 = this.cars.iterator();
		while(var4.hasNext()) {
			Car car = (Car) var4.next();
			car.move(c);
		}
		this.removeOldCars();
	}

	public void update() {

		// TODO

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

		++this.timer;
		if (timer <= this.speed ){
			moveCars(false);
			return;
		} else {
			moveCars(true);
			mayAddCar();
			timer = 0;
		}

	}

	// TODO : ajout de methodes

	public boolean isSafe(Case pos) {
		Iterator var3 = this.cars.iterator();
		while(var3.hasNext()) {
			Car car = (Car)var3.next();
			if (car.caseVide(pos)) {
				return false;
			}
		}
		return true;
	}

	private void removeOldCars() {
		ArrayList<Car> toBeRemoved = new ArrayList();
		Iterator var3 = this.cars.iterator();
		Car c;
		while(var3.hasNext()) {
			c = (Car)var3.next();
			if (!c.appearsInBounds()) {
				toBeRemoved.add(c);
			}
		}
		var3 = toBeRemoved.iterator();
		while(var3.hasNext()) {
			c = (Car)var3.next();
			this.cars.remove(c);
		}
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */

	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density/3) {
				cars.add(new Car(game , getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width -1 , ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
