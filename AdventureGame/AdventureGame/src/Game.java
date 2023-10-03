import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    public void login()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Oyuna başlamadan önce isminizi giriniz ");
        String playerName = scan.nextLine();
         player = new Player(playerName);
        player.selectChar();
        start();
    }
    public void start()
    {
       while (true)
       {

           System.out.println();
           System.out.println("===========================");
           System.out.println();
           System.out.println("eylem gerçekleştirmek için seçim yapınız !");
           System.out.println("1 - Güvenli Ev => Can    yenileme ");
           System.out.println("2 - Mağara     => Zombi  çıkabilir");
           System.out.println("3 - Orman      => Vampir çıkabilir");
           System.out.println("4 - Nehir      => Ayı    çıkabilir");
           System.out.println("5 - Mağaza     => Silah Almak için");
           System.out.print("\n \t secim : ");
           int selLo = scan.nextInt();
           while (selLo<1 || selLo>5)
           {
               System.out.println("Lütfen geçerli değer giriniz !!");
               selLo = scan.nextInt();
           }

          switch (selLo)
           {
               case 1:
                   location = new SafeHouse(player);
                   break;
               case 2:
                   location = new Cave(player);
                   break;
               case 3:
                   location = new Forest(player);
                   break;
               case 4:
                   location = new River(player);
                   break;
               case 5:
                   location = new ToolStore(player);

                   break;
               default:
                   location = new SafeHouse(player);
                   break;
           }

            if (location.getClass().getName().equals("SafeHouse")){
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                    System.out.println("Tebrikler Oyunu kazandınız !!");
                }
            }
            if (!location.getLocation()){
                System.out.println("Oyun bitti");
                break;
            }



       }
    }
}
