public class Main {
    public static void main(String[] args) {

         Pakistanis p1 = new Pakistanis("");
         p1.skinColor();
         p1.favoriteFood();
    }
}

class Human {
    private String name;
    public void favoriteFood() {
        System.out.println("Humans love all kinds of foods.");
    }
    public void skinColor(){
        System.out.println("All humans can have a shade of brown to white");
    }
    Human (String name){
        this.name = name;
    }
    Human(){

    }
}
class Pakistanis extends Human {
    Pakistanis(String name){
        super(name);
    }
    public void favoriteFood() {
        super.favoriteFood();
        System.out.println("Pakistanis love spicy food.");
    }
}

