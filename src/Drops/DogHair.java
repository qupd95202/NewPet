package Drops;

import Game.Global;
import Game.Item ;
public class DogHair extends Item {

    public DogHair() {
        super.setName("狗毛");
        super.setUsage("可至商店變賣");
        super.setType(Global.ItemType.DOGHAIR);
    }

    @Override
    public int getSellOutPrice() {
        return 0;
    }

    @Override
    public int getBuyInPrice() {
        return 2;
    }
}
