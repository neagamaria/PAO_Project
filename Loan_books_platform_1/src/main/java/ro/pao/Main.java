package ro.pao;
import ro.pao.application.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menu = Menu.getInstance();

        menu.intro();
    }
}