package Food;

import Game.Global;
import Game.Item;

public class InsectFood extends Item {
    public InsectFood() {
        super.setName("昆蟲飼料");
        super.setUsage("只能給昆蟲吃");
        super.setType(Global.ItemType.INSECTFOOD);
    }

    @Override
    public int getSellOutPrice() {
        return 1;
    }

    @Override
    public int getBuyInPrice() {
        return 3;
    }
}
