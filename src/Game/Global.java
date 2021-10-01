package Game;

import Animal.Animal;
import BuffItem.AnimalRoomAdding;
import BuffItem.BagAdding;
import Decoration.Carton;
import Decoration.Seaweed;
import Decoration.WoodHouse;
import Drops.CatHair;
import Drops.DogHair;
import Drops.FishScale;
import Food.CannedFood;
import Food.Fishfood;
import Food.InsectFood;

public class Global {
    public final static int INITIAL_FOOD_AMOUNT = 5;
    public final static int BUYING_MAX_AMOUNT = 20;
    public static final int ITEM_MAX_AMOUNT = 20;
    public final static int NAME_LIMIT = 8;

    public enum AnimalType {
        CAT,
        DOG,
        FISH,
        Insect;
    }

    public static Item genItem(Item.ItemType itemType) {
        if (itemType == Item.ItemType.BAGADDING) {
            return new BagAdding();
        }
        if (itemType == Item.ItemType.ANIMALROOMADDING) {
            return new AnimalRoomAdding();
        }
        if (itemType == Item.ItemType.CARTON) {
            return new Carton();
        }
        if (itemType == Item.ItemType.SEAWEED) {
            return new Seaweed();
        }
        if (itemType == Item.ItemType.WOODHOUSE) {
            return new WoodHouse();
        }
        if (itemType == Item.ItemType.CATHAIR) {
            return new CatHair();
        }
        if (itemType == Item.ItemType.DOGHAIR) {
            return new DogHair();
        }
        if (itemType == Item.ItemType.FISHSCALE) {
            return new FishScale();
        }
        if (itemType == Item.ItemType.SAWDUST) {
            return new Seaweed();
        }
        if (itemType == Item.ItemType.CANNEDFOOD) {
            return new CannedFood();
        }
        if (itemType == Item.ItemType.FISHFOOD) {
            return new Fishfood();
        }
        if (itemType == Item.ItemType.INSECTFOOD) {
            return new InsectFood();
        }
        return null;
    }

    public static Animal genAnimal() {
        return null;
    }


}
