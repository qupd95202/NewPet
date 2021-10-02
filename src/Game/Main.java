package Game;
import Animal.Animal;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Shop shop = new Shop();
        System.out.println("請選擇你的第一隻動物～(1)狗勾 (2)貓貓 (3)魚兒 (4)昆蟲 ");
        int animalChoice = Input.genNumber(1, 4);
        System.out.println("請幫他命名：");
        String name = Input.namingWord();

        Animal initialAnimal = shop.genBuyingAnimal(animalChoice,name);
        initialAnimal.setGender(Animal.Gender.MALE);
        System.out.println(initialAnimal.getName() + " 是" + initialAnimal.getGender().getDescription() + "喔!");
        player.addAnimal(initialAnimal);


//        while (player.isGameOver()) {
//            System.out.println("\n\n請選擇：(1)對動物做動作 (2)顯示所有動物狀態 (3)顯示所有連結狀態 (4)顯示目前所有物品 (5)進入商店");
//            int action = Input.genNumber(1, 5);
//            switch (action) {
//                case 1:
//                    System.out.println("請輸入執行動作: (1)直接過一天 (2)餵食 (3)清潔房間 (4)散步 (5)連結 (6)解除連結 (7)裝飾寵物房 (8)回上一頁");
//                    int movement = Input.genNumber(1,8);
//                    while (movement > 8 || movement < 1) {
//                        System.out.println("請輸入執行動作: (1)直接過一天 (2)餵食 (3)清潔房間 (4)散步 (5)連結 (6)解除連結 (7)裝飾寵物房 (8)回上一頁");
//                        movement = sc.nextInt();
//                    }
//                    newPlayer = makeCommand.startCommand(newPlayer, movement);
//                    break;
//                case 2:
//                    newPlayer.checkAnimalAmount(); //顯示所有動物陣列中的動物狀態
//                    break;
//                case 3:
//                    newPlayer.checkAnimalBinding(); //印出所有有配對的動物
//                    break;
//                case 4:
//                    newPlayer.printOutAllItem(); //印出所有包包中物品
//                    break;
//                case 5:
//                    enterShop.intoShop(newPlayer);
//                    break;
//            }
//        }   //寵物全死提示+結束遊戲
//        System.out.println("你的寶貝們都死掉了T.T");
//    }
//}

//    public static void buyItem () {
//        Player player = new Player();
//        Shop shop = new Shop();
//        shop.showShopList();
//        System.out.println("\n請選擇要購買的物品:");
//        Item item = Shop.genBuyingItem();
//        System.out.println("\n請輸入購買數量");
//        int amount = Input.buyAmount();
//        if (!shop.buyItem(player.getMoney(), item, amount)) {
//            System.out.println("金錢不足");
//            return;
//        }
//        if (!player.isBagEnough(item, amount)) {
//            System.out.println("背包不夠");
//            return;
//        }
//        player.addItem(item,amount);
//        System.out.println("購買成功");
//    }
    }
}
