//package Game;
//
//public enum Items implements Tradable {
//    DOGHAIR("狗毛") {
//        @Override
//        public int getBuyInPrice() {
//            return 0;
//        }
//
//
//        @Override
//        public int getSellOutPrice() {
//            return 2;
//        }
//
//
//    },
//    CATHAIR("貓毛") {
//        @Override
//        public int getBuyInPrice() {
//            return 0;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 2;
//        }
//    },
//
//    FISHSCALE("魚鱗") {
//        @Override
//        public int getBuyInPrice() {
//            return 0;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 3;
//        }
//    },
//
//    SAWDUST("木屑") {
//        @Override
//        public int getBuyInPrice() {
//            return 0;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 1;
//        }
//    },
//
//    CANNEDFOOD("罐頭食物") {
//        @Override
//        public int getBuyInPrice() {
//            return 5;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 2;
//        }
//    },
//
//    FISHFOOD("魚飼料") {
//        @Override
//        public int getBuyInPrice() {
//            return 4;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 1;
//        }
//    },
//
//    INSECTFOOD("昆蟲飼料") {
//        @Override
//        public int getBuyInPrice() {
//            return 3;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 1;
//        }
//    },
//
//    CARTON("紙箱") {
//        @Override
//        public int getBuyInPrice() {
//            return 3;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 1;
//        }
//    },
//
//    SEAWEED("海草") {
//        @Override
//        public int getBuyInPrice() {
//            return 3;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 1;
//        }
//    },
//
//    WOODHOUSE("木屋") {
//        @Override
//        public int getBuyInPrice() {
//            return 4;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 2;
//        }
//    },
//
//    BAGADDING("背包格擴充物件") {
//        @Override
//        public int getBuyInPrice() {
//            return 10;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 0;
//        }
//    },
//
//    ANIMALROOMADDING("寵物格擴充物件") {
//        @Override
//        public int getBuyInPrice() {
//            return 10;
//        }
//
//        @Override
//        public int getSellOutPrice() {
//            return 0;
//        }
//    };
//
//    private String name;
//    private int count;
//    public static final int MAX_COUNT = 20;
//
//    Items(String name) {
//        this.name = name;
//        count = 0;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAmount() {
//        return count;
//    }
//
//    public void addCount(int value) {
//        count += value;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    @Override
//    public String toString() {
//        return name + ": " + getAmount() + "個";
//    }
//
//    public Items gen(String className) {
//        switch (className) {
//            case "Game.Items$1":
//                return Items.DOGHAIR;
//        }
//    }
//}
