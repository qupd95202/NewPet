package Game;

public abstract class Item implements Tradable {
    private int amount = 0;
    private String name;
    private String usage;
    private ItemType type;

    public enum ItemType {
        DOGHAIR("狗毛"),
        CATHAIR("貓毛"),
        FISHSCALE("魚鱗"),
        SAWDUST("木屑"),
        CANNEDFOOD("罐頭食物"),
        FISHFOOD("魚飼料"),
        INSECTFOOD("昆蟲飼料"),
        CARTON("紙箱"),
        SEAWEED("海草"),
        WOODHOUSE("木屋"),
        BAGADDING("背包格擴充物件"),
        ANIMALROOMADDING("寵物格擴充物件");

        private String name;

        ItemType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getUsage() {
        return usage;
    }

    public ItemType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int value) {
        amount += value;
    }

    public String itemExplanation() {
        return getName() + "\t售價： " + getBuyInPrice() + "\t用途： " + getUsage();
    }

}
