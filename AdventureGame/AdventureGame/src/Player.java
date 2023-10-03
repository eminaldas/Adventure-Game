import java.util.Scanner;

public class Player {
    protected int damage,healthy,money,rHealty;
    protected String name,cName;
    Inventory inv;
    Scanner scan = new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inv= new Inventory();
    }
    public int totalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public void selectChar()
    {
       switch ( charMenu())
       {
           case 1:
               initPlayer("Samuray",5,21,15);


               break;
           case 2:
               initPlayer("okçu",7,18,20);

               break;
           case 3:
               initPlayer("Şovalye",8,24,25);
               break;
           default:
               initPlayer("Samuray",5,21,15);

               break;
       }
       System.out.println("Karakter : "+getcName() + "\tHasar : "+getDamage()+"\t "
                           +"Sağlık : "+getHealthy()+ "\tPara : "+getMoney());

    System.out.println(getMoney());
    }
    public void initPlayer(String _cName, int _dmg,int hlthy,int _money)
    {
        setcName(_cName);
        setDamage(_dmg);
        setHealthy(hlthy);
        setMoney(_money);

        setrHealty(18);
    }
    public int charMenu()
    {
        System.out.println("Merhaba "+name);
        System.out.println("Lütfen karakter seçiniz : ");
        System.out.println("  1 - Türü : Samuray \t Hasar : 5 \tSağlık : 21 \tPara : 15");
        System.out.println("  2 - Türü : Okçu    \t Hasar : 7 \tSağlık : 18 \tPara : 20");
        System.out.println("  3 - Türü : Şovalye \t Hasar : 8 \tSağlık : 24 \tPara : 25 ");
        System.out.println("\n \t Seçiminiz : ");
        int sec;
        while(true)
        {
            sec = scan.nextInt();
            if (sec<1 || sec>3)
            {
                System.out.println("lütfen geçerli karakter seçiniz .");
            }else{
                break;
            }
        }
        return sec;

    }

    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getcName() {
        return cName;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public void setMoney(int _money) {
        this.money = _money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getrHealty() {
        return rHealty;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setrHealty(int rHealty) {
        this.rHealty = rHealty;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
