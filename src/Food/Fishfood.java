package Food;

import Game.Global;
import Game.Item;

public class Fishfood extends Item {
    public Fishfood() {
        super.setName("魚飼料");
        super.setUsage("只能給魚吃");
        super.setType(Global.ItemType.FISHFOOD);
    }

    @Override
    public int getSellOutPrice() {
        return 1;
    }

    @Override
    public int getBuyInPrice() {
        return 4;
    }
}
