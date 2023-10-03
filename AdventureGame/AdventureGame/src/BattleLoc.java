public abstract class BattleLoc extends Location {
   protected Obstacle obsc;
   protected String award;
    BattleLoc(Player player,String name,Obstacle obsx,String award)
    {
        super(player);
        obsc=obsx;
        this.name = name;
        this.award = award;

    }
    public boolean getLocation()
    {
        int obsCount =obsc.obstacleCount();
        System.out.println("şu an  "+ this.getName()+"de bulunuyorsunuz !!");
        System.out.println("Dikkat "+obsCount+" tane "+obsc.getName()+" bulunuyor !!");
        System.out.println("Savaş [S] ya da Kaç [K] : ");
        String selCase = scan.nextLine();
        if(selCase.equals("s")){
           boolean sonuc = combat(obsCount);
            if (sonuc)
            {
                System.out.println(this.getName()+" bölgesindeki tüm düşmanlar temizlendi !!");
                if (this.award.equals("yiyecek") && player.getInv().isFood()==false){
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setFood(true);
                } else if (this.award.equals("su") && player.getInv().isWater()==false) {
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setWater(true);
                }else if(this.award.equals("odun") && player.getInv().isFirewood()==false) {
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setFirewood(true);
                }
                return true;
            }

            if (player.getHealthy() <= 0){
                    System.out.println("öldünüz ");
            }

        }

       return true;
    }
    public boolean combat (int obsCount){
        int number = obsCount;
        System.out.println(number);
        for (int i =0 ;i < number ;i++)
        {


            int defObsHealth = obsc.getHealth();
            playerSats();
            enemyStats();
            while(player.getHealthy() > 0 && obsc.getHealth() > 0){
                System.out.println("Vur [V] veya Kaç [K]");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    obsc.setHealth(obsc.getHealth()-player.totalDamage());
                    afterHit();
                    if (obsc.getHealth() > 0){
                        System.out.println();
                        System.out.println("Düşman size vurdu !");
                        player.setHealthy(player.getHealthy()-(obsc.getDamage()-player.getInv().getArmor()));
                        afterHit();
                    }

                }else{
                    return false;
                }
            }
            if (obsc.getHealth() < player.getHealthy()) {
                System.out.println();
                System.out.println(" düşmanı yendniz !");
                player.setMoney(player.getMoney()+obsc.getAward());
                System.out.println("Güncel Paranız "+player.getMoney());
                obsc.setHealth(defObsHealth);
                System.out.println();
            }else {
                return false;
            }
            System.out.println("-------------------------------------------");



        }
        return true;
    }
    public void playerSats(){
        System.out.println("Oyuncu değerleri \n ============");
        System.out.println("Can   : "+player.getHealthy());
        System.out.println("Hasar : "+player.totalDamage());
        System.out.println("Para  : "+player.getMoney());
        if(player.getInv().getDamage()>0){
            System.out.println("Silah : "+player.getInv().getwName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Zırh  : "+player.getInv().getaName());
        }
    }

    public void enemyStats(){
        System.out.println("\n\n"+obsc.getName()+" değerleri \n ============");
        System.out.println("Can   : "+obsc.getHealth());
        System.out.println("Hasar : "+obsc.getDamage());
        System.out.println("Ödül  : "+obsc.getAward());
    }
    public void afterHit(){
        System.out.println("Oyuncunun sağllığı : "+player.getHealthy());
        System.out.println(obsc.getName()+" sağllığı : "+obsc.getHealth());
        System.out.println();

    }

    public Obstacle getObsc() {
        return obsc;
    }

    public void setObsc(Obstacle obsc) {
        this.obsc = obsc;
    }
}
