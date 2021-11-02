package Inf;

import java.util.ArrayList;
import environment.Lane;
import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;
import java.util.Iterator;

public class EnvInf implements IEnvironment {

    private ArrayList<Lane> lanes;
    private Game game;

    public EnvInf(Game game) {
        this.game = game;
        this.lanes = new ArrayList();
        this.lanes.add(new Lane(game, 0, 0.0D));
        this.lanes.add(new Lane(game, 1, 0.0D));

        for(int i = 2; i < game.height; ++i) {
           addLane(i);
        }
    }

    public void addLane (int i){
        this.lanes.add(new Lane(this.game,i));
    }

    public void addLane (){
        this.addLane(this.lanes.size());
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
