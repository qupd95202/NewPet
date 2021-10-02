package Game;

import Animal.*;
import Item.*;

import java.util.ArrayList;


public class Player {
    private ArrayList<Item> bag;
    private ArrayList<Animal> animalRoom;
    private int bagMax;
    private int animalRoomMax;
    private int money;

    public enum Status {
        SUCCESSFUL,
        NO_MONEY,
        NO_SPACE,
        NO_ITEM,
        NO_AMOUNT;
    }

    public enum basicAction {
        WALK,
        FEED,
        CLEAN,
        CONNECT,
        DECORATE,
        DISCONNECT,
        NEXT;
    }

    public Player() {
        money = Global.INITIAL_MONEY;
        bag = new ArrayList<Item>();
        animalRoom = new ArrayList<>();
        bagMax = 10;
        animalRoomMax = 10;
    }

    //////BUY////////

    /**
     * 購買道具
     *
     * @param item
     * @param amount
     * @return
     */
    public Status buyItem(Item item, int amount) {
        if (!isBagEnough(item, amount)) {
            return Status.NO_SPACE;
        }
        if (!isMoneyEnough(money, item, amount)) {
            return Status.NO_MONEY;
        }
        addItem(item, amount);
        costMoney(howMuch(item, amount));
        return Status.SUCCESSFUL;
    }

    /**
     * 檢查是否有重複的道具
     *
     * @param addingItem
     * @return 有就回傳，沒有就傳null(滿了一樣算null)
     */
    private Item theSameItem(Item addingItem) {
        for (Item item : bag) {
            if (item.getType() == addingItem.getType()) {
                if (item.getAmount() < Global.ITEM_MAX_AMOUNT) { //如有且還可堆疊，就把重複的拿出來，沒有就回傳參數
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * 檢查是否夠放道具
     *
     * @return
     */
    public boolean isBagEnough(Item addingItem, int amount) {
        Item theSameItem = theSameItem(addingItem);
        if (theSameItem == null) { //新物品
            if (bag.size() + 1 <= bagMax) {
                return true;
            }
        } else { //舊有物品
            if (theSameItem.getAmount() + amount > 20) {
                if (bag.size() + 1 <= bagMax) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 檢查錢是否足夠購買的總金額
     *
     * @param money  player持有的錢
     * @param item   購買的物品
     * @param amount 購買數量
     * @return
     */
    public boolean isMoneyEnough(int money, Item item, int amount) {
        if (money - (item.getBuyPrice() * amount) < 0) {
            return false;
        }
        return true;
    }

    /**
     * 放入物品
     *
     * @param addingItem
     * @param amount
     */
    public void addItem(Item addingItem, int amount) {
        Item theSameItem = theSameItem(addingItem);
        if (!isBagEnough(addingItem, amount)) {
            return;
        }
        if (theSameItem == null) {
            addingItem.addAmount(amount);
            bag.add(addingItem);
        } else {
            if (theSameItem.getAmount() + amount <= Global.ITEM_MAX_AMOUNT) {
                theSameItem.addAmount(amount);
            } else {
                int remaining = amount - (Global.ITEM_MAX_AMOUNT - theSameItem.getAmount());
                theSameItem.setAmount(Global.ITEM_MAX_AMOUNT);
                addingItem.addAmount(remaining);
                bag.add(addingItem);
            }
        }
    }

    /**
     * 購買寵物
     *
     * @param animal
     */
    public Status buyAnimal(Animal animal) {
        if (money < animal.getBuyInPrice()) {
            return Status.NO_MONEY;
        }
        if (addAnimal(animal)) {
            costMoney(animal.getBuyInPrice());
            return Status.SUCCESSFUL;
        }
        return Status.NO_SPACE;
    }

    /**
     * 放入寵物
     *
     * @return
     */
    public boolean addAnimal(Animal animal) {
        if (animalRoom.size() + 1 <= animalRoomMax) {
            animalRoom.add(animal);
            return true;
        }
        return false;
    }

    /**
     * 購買加成道具
     */
    public Status buyBuffItem(BufferItem buffItem) {
        if (money < buffItem.getBuyPrice()) {
            return Status.NO_MONEY;
        }
        if (buffItem.getType() == Item.Type.ANIMALROOMADDING) {
            animalRoomMax++;
        }
        if (buffItem.getType() == Item.Type.BAGADDING) {
            bagMax++;
        }
        costMoney(buffItem.getBuyPrice());
        return Status.SUCCESSFUL;
    }


    //////SELL//////

    /**
     * 賣出物品
     *
     * @param item   要賣的商品
     * @param amount 要賣得數量
     */
    public Status sell(Item item, int amount) {
        //是否擁有此物品
        if (theSameItem(item) == null) {
            return Status.NO_ITEM;
        } else {
            Item itemForSell = theSameItem(item);
            //擁有此物品得數量是否足夠
            if (amount > itemForSell.getAmount()) {
                return Status.NO_AMOUNT;
            } else {
                //獲得販售的錢
                addMoney(howMuch(item, amount));
                //扣除擁有的物品
                itemAmountMinus(itemForSell, amount);
                return Status.SUCCESSFUL;
            }
        }
    }


    /**
     * 選擇寵物房裡的一個寵物
     *
     * @param index
     * @return
     */
    public Animal chooseAnimal(int index) {
        if (index > animalRoom.size()) {
            return null;
        }
        return animalRoom.get(index - 1);
    }

    /**
     * 選擇背包裡的一個道具
     *
     * @param index
     * @return
     */
    public Item chooseItem(int index) {
        if (index > bag.size()) {
            return null;
        }
        return bag.get(index - 1);
    }

    /**
     * 帶寵物散步
     *
     * @param animal
     */
    public boolean walk(Animal animal) {
        return animal.walk();
    }

    /**
     * 餵寵物吃東西
     *
     * @param animal
     * @param food
     * @return
     */
    public boolean feed(Animal animal, Food food) {
        if (animal.eat(food)) {
            itemAmountMinus(food);
            return true;
        }
        return false;
    }

    /**
     * 選擇兩隻寵物連結
     *
     * @param animal
     * @param animal2
     * @return
     */
    public boolean connect(Animal animal, Animal animal2) {
        return animal.connect(animal2);
    }

    /**
     * 選擇一隻寵物取消連結
     *
     * @param animal
     * @return
     */
    public boolean disconnect(Animal animal) {
        return animal.disConnect();
    }

    /**
     * 裝飾寵物房間
     */
    public boolean decorate(Animal animal, Item item) {
        if (animal.getDecoration() != null) {
            return false;
        }
        animal.setDecoration(item);
        itemAmountMinus(item);
        return true;
    }

    /**
     * 清潔房間
     *
     * @return
     */
    public void clean(Animal animal) {
        animal.clean();
    }

    /**
     * 遊戲結束(判斷是否寵物死光，或沒寵物)
     *
     * @return
     */
    public boolean isGameOver() {
        if (animalRoom.size() == 0) { //沒寵物
            return true;
        }
        for (Animal animal : animalRoom) {
            if (animal.getStatus() == Animal.Status.ALIVE) {  //有無死光
                return false;
            }
        }
        return true;
    }

    /**
     * 印出所有道具
     *
     * @return
     */
    public boolean printAllItem() {
        if (bag.size() == 0) {
            return false;
        }
        for (Item item : bag) {
            System.out.println(item.itemInformation());
        }
        return true;
    }

    /**
     * 印出所有寵物
     *
     * @return
     */
    public void printAllAnimal() {
        animalRoom.forEach(animal -> System.out.println(animal));
    }

    /**
     * 使用物品減少
     *
     * @param item
     */
    public void itemAmountMinus(Item item) {
        item.addAmount(-1);
        if (item.getAmount() == 0) {
            bag.remove(item);
        }
    }

    /**
     * 使用物品減少(大量)
     *
     * @param item
     * @param amount
     */
    public void itemAmountMinus(Item item, int amount) {
        item.addAmount(-amount);
        if (item.getAmount() == 0) {
            bag.remove(item);
        }
    }

    /**
     * 擁有的錢
     *
     * @return
     */
    public int getMoney() {
        return money;
    }

    /**
     * 減少錢包的錢
     *
     * @param price
     */
    public void costMoney(int price) {
        money -= price;
    }

    /**
     * 增加錢包的錢
     */
    public void addMoney(int price) {
        money += price;
    }

    /**
     * 計算多少錢
     *
     * @param item
     * @param amount
     * @return
     */
    public int howMuch(Item item, int amount) {
        return item.getBuyPrice() * amount;
    }

    /**
     * 批量選擇寵物
     *
     * @return
     */
    private ArrayList chooseNumerousAnimal() {
        ArrayList<Animal> animals = new ArrayList<>();
        int index = -1;
        while (true) {
            index = Input.genNumber(0, animalRoom.size());
            if (index <= 0) {
                break;
            }
            Animal animal = animalRoom.get(index - 1);
            if (!animals.contains(animal)) {
                animals.add(animalRoom.get(index - 1));
            }
        }
        return animals;
    }

    /**
     * 進行一個動作
     */
    public void next() {
        animalRoom.forEach(animal ->
                animal.update());
    }

    //    public void addItem(Items addingItem, int amount) {
//        for (Items items : bag) { //遍歷整個背包
//            if (items.getName().equals(addingItem.getName())) { //如果背包裡有跟即將要增加的物品相同時
//                if (items.getCount() + amount <= Items.MAX_COUNT) { //又數量沒有超過
//                    items.addCount(amount); //直接增加持有數
//                    return true;
//                } else { //如果數量有超過
//                    amount -= (Items.MAX_COUNT - items.getCount()); //超過的量
//                    items.setCount(Items.MAX_COUNT); //補滿
//                    addingItem.addCount(amount); //額外新增的item量
//                    if (bag.size() < bagMax) { //背包欄位格夠
//                        bag.add(addingItem);
//                        return true;
//                    }
//                }
//            }
//        }
//        if (amount <= Items.MAX_COUNT) { //又數量沒有超過
//            addingItem.addCount(amount);//直接增加持有數
//            bag.add(addingItem);
//            return true;
//        } else { //如果數量有超過
//            amount -= Items.MAX_COUNT; //超過的量
//            Items item = new
//                    addingItem.addCount(Items.MAX_COUNT); //額外新增的item量
//            if (bag.size() < bagMax) { //背包欄位格夠
//                bag.add(addingItem);
//                return true;
//            }
//        }
//        if (bag.size() < bagMax) {
//            addingItem.addCount(amount);
//            bag.add(addingItem);
//            return true;
//        }
//        return false;
//    }
}