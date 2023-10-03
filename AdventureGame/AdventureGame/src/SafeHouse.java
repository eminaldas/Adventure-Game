public class SafeHouse extends NormalLoc{
    SafeHouse(Player player)
    {
        super(player,"Güvenli Ev");
    }
    public boolean getLocation()
    {
   //     player.setHealthy(player.getrHealty());
        System.out.println("Canınız Yenilendi !");
        System.out.println("Şu an güvenli evdesiniz !");
        return true;
    }

}
