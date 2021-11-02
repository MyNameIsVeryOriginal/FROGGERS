/*
package environment;

import java.util.ArrayList;
import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;
import java.util.Iterator;

public class Environment implements IEnvironment {

    private ArrayList<Lane> lanes;
    private Game game;

    public Environment(Game game) {
        this.game = game;
        this.lanes = new ArrayList();
        this.lanes.add(new Lane(game, 0, 0.0D));

        for(int i = 1; i < game.height - 1; ++i) {
            this.lanes.add(new Lane(game, i));
        }

        this.lanes.add(new Lane(game, game.height - 1, 0.0D));
    }

    @Override
    public boolean isSafe(Case c) {
        return ((Lane)this.lanes.get(c.ord)).isSafe(c);
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    @Override
    public void update() {
        Iterator var2 = this.lanes.iterator();
        while(var2.hasNext()) {
            Lane lane = (Lane)var2.next();
            lane.update();
        }
    }

}

*/