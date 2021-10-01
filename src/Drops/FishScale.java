package Drops;

import Game.Global;
import Game.Item;

public class FishScale extends Item {
    public FishScale() {
        super.setName("魚鱗");
        super.setUsage("可至商店變賣");
        super.setType(Global.ItemType.FISHSCALE);
    }

    @Override
    public int getSellOutPrice() {
        return 3;
    }

    @Override
    public int getBuyInPrice() {
        return 0;
    }
}
