package Game;

import Animal.*;
import Item.*;


public class Global {
    public final static int INITIAL_FOOD_AMOUNT = 5;
    public final static int BUYING_MAX_AMOUNT = 20;
    public static final int ITEM_MAX_AMOUNT = 20;
    public final static int NAME_LIMIT = 8;
    public final static int INITIAL_MONEY = 100;

    public static Item genItem(Item.Type type) {

        if (type == Item.Type.BAGADDING) {
            return new BufferItem(new Item.Builder()
                    .setBuyPrice(10)
                    .setName("擴增背包格")
                    .setUsage("背包格+1")
                    .setType(Item.Type.BAGADDING), 1
            );
        }
        if (type == Item.Type.ANIMALROOMADDING) {
            return new BufferItem(new Item.Builder()
                    .setBuyPrice(10)
                    .setName("擴增寵物格")
                    .setUsage("寵物格+1")
                    .setType(Item.Type.ANIMALROOMADDING), 1
            );
        }
        if (type == Item.Type.CARTON) {
            return new Item.Builder()
                    .setBuyPrice(3)
                    .setSellPrice(1)
                    .setName("紙箱")
                    .setUsage("裝飾在寵物屋中，每個" +
                            "寵物屋限放一個")
                    .setType(Item.Type.CARTON)
                    .gen();
        }
        if (type == Item.Type.SEAWEED) {
            return new Item.Builder()
                    .setBuyPrice(3)
                    .setSellPrice(1)
                    .setName("海草")
                    .setUsage("裝飾在寵物屋中，每個" +
                            "寵物屋限放一個")
                    .setType(Item.Type.SEAWEED)
                    .gen();
        }
        if (type == Item.Type.WOODHOUSE) {
            return new Item.Builder()
                    .setBuyPrice(4)
                    .setSellPrice(2)
                    .setName("木屋")
                    .setUsage("裝飾在寵物屋中，每個" +
                            "寵物屋限放一個")
                    .setType(Item.Type.WOODHOUSE)
                    .gen();
        }
        if (type == Item.Type.CATHAIR) {
            return new Item.Builder()
                    .setSellPrice(1)
                    .setName("貓毛")
                    .setUsage("貓咪的毛，聽說可賣錢")
                    .setType(Item.Type.CATHAIR)
                    .gen();
        }
        if (type == Item.Type.DOGHAIR) {
            return new Item.Builder()
                    .setSellPrice(2)
                    .setName("狗毛")
                    .setUsage("狗狗的毛，聽說可賣錢")
                    .setType(Item.Type.DOGHAIR)
                    .gen();
        }
        if (type == Item.Type.FISHSCALE) {
            return new Item.Builder()
                    .setSellPrice(3)
                    .setName("魚鱗")
                    .setUsage("美麗的鱗片，頗為值錢")
                    .setType(Item.Type.FISHSCALE)
                    .gen();
        }
        if (type == Item.Type.SAWDUST) {
            return new Item.Builder()
                    .setSellPrice(1)
                    .setName("木屑")
                    .setUsage("蟲蟲吃剩的，可賣錢")
                    .setType(Item.Type.SAWDUST)
                    .gen();
        }
        if (type == Item.Type.CANNEDFOOD) {
            return new Food(new Item.Builder()
                    .setBuyPrice(5)
                    .setSellPrice(2)
                    .setName("罐頭飼料")
                    .setUsage("只能給貓及狗吃")
                    .setType(Item.Type.CANNEDFOOD)
            );
        }
        if (type == Item.Type.FISHFOOD) {
            return new Food(new Item.Builder()
                    .setBuyPrice(4)
                    .setSellPrice(1)
                    .setName("魚飼料")
                    .setUsage("只能給魚吃")
                    .setType(Item.Type.FISHFOOD)
            );
        }
        if (type == Item.Type.INSECTFOOD) {
            return new Food(new Item.Builder()
                    .setBuyPrice(4)
                    .setSellPrice(1)
                    .setName("昆蟲飼料")
                    .setUsage("只能給昆蟲吃")
                    .setType(Item.Type.INSECTFOOD)
            );
        }
        return null;
    }

    public static Animal genAnimal(Animal.Type type, String name) {
        if (type == Animal.Type.DOG) {
            return new Dog(name);
        }
        if (type == Animal.Type.CAT) {
            return new Cat(name);
        }
        if (type == Animal.Type.FISH) {
            return new Fish(name);
        }
        if (type == Animal.Type.INSECT) {
            return new Insect(name);
        }
        return null;
    }


}
