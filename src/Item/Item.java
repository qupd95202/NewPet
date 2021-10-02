package Item;

public class Item {
    private int amount;
    private final String name;
    private final String usage;
    private final Type type;
    private final int buyPrice;
    private final int sellPrice;

    public enum Type {
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

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Builder {
        private int amount;
        private String name;
        private String usage;
        private Type type;
        private int buyPrice;
        private int sellPrice;


        public Builder setBuyPrice(int buyPrice) {
            this.buyPrice = buyPrice;
            return this;
        }

        public Builder setSellPrice(int sellPrice) {
            this.sellPrice = sellPrice;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setUsage(String usage) {
            this.usage = usage;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Item gen() {
            Item newItem = new Item(this);
            return newItem;
        }
    }

    public Item(Builder builder) {
        amount = 0;
        name = builder.name;
        usage = builder.usage;
        type = builder.type;
        buyPrice = builder.buyPrice;
        sellPrice = builder.sellPrice;
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

    public Type getType() {
        return type;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void addAmount(int value) {
        amount += value;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String itemInformation() {
        return name + ": " + amount + "個    用途:" + usage;
    }

}
