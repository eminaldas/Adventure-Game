public class ToolStore extends NormalLoc{
    ToolStore(Player player)
    {
        super(player,"Mağaza");
    }
    public boolean getLocation(){

        System.out.println(player.getMoney());
        System.out.println("para : ");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış");
        System.out.print("seçiminiz : ");
        int selTool = scan.nextInt();
        int selItemID;

        switch (selTool)
        {
            case 1:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
            default:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;

        }
        return true;
    }
    public int armorMenu()
    {
        System.out.println("1 - Hafif     : 15€ - Engelleme : 1");
        System.out.println("2 - Orta      : 25€ - Engelleme : 3");
        System.out.println("3 - Ağır      : 40€ - Engelleme : 5");
        System.out.print("Tercihiniz : ");
        int selArmor = scan.nextInt();
        return selArmor;
    }
    public void buyArmor(int armorID){
        int price=0,damageArmor=0;
        String aName=null;
        switch (armorID)
        {
            case 1:
                price = 15;
                damageArmor=1;
                aName="Hafif";
                break;
            case 2:
                price = 25;
                damageArmor=3;
                aName="Orta";
                break;
            case 3:
                price = 40;
                damageArmor=5;
                aName="Ağır";
                break;
            case 4:
                System.out.println("Çıkış yapılıyor !!");
                break;
            default:
                System.out.println("geçersiz işlem !!");
                break;
        }
        if(price > 0)
        {
            if (player.getMoney()>0)
            {
                player.getInv().setArmor(damageArmor);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println(aName+"Silah satın alındı, engellenen hasar : "+ player.getInv().getArmor());
                System.out.println("kalan para : "+player.getMoney());
            }else{
                System.out.println("Bakiye yetersizdir !!");
            }
        }
    }
    public  int weaponMenu()
    {
        System.out.println("1 - Tabanca   : 25€ - Hasar : 2");
        System.out.println("2 - kılıç     : 35€ - Hasar : 3");
        System.out.println("3 - tüfek     : 45€ - Hasar : 7");
        System.out.print("Tercihiniz : ");
        int selWeapon = scan.nextInt();
        return selWeapon;
    }

    public void buyWeapon(int itemID)
    {
        int damage = 0,price = 0;String wName=null;
        switch (itemID){
            case 1:
                damage = 2;
                wName="tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName="kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName="tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("çıkış yapılıyor !!");
                break;
            default:
                System.out.println("geçersiz işlem !");
                break;
        }
     if (price > 0){
         if(player.getMoney()> price)
         {
             player.getInv().setDamage(damage);
             player.getInv().setwName(wName);
             player.setMoney(player.money-price);
             System.out.println(wName+"Silah satın alındı, önceki hasar : "+player.getDamage()
                     +", yeni Hasar  : "+player.totalDamage());
             System.out.println("kalan para : "+player.getMoney());
         }else {
             System.out.println("Bakiye yetersizdir");
         }


     }


    }
}
