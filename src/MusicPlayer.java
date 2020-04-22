public class MusicPlayer{

    public static void main(String[] args) {
        Thread firstpart = new Thread(new MainPart(),"t1");
        Thread secondpart = new Thread(new BassPart(),"t2");
        Thread thirdpart = new Thread(new DrumPart(),"t3");
        Thread fourthpart = new Thread(new DrumPart2(),"t2");
        firstpart.start();
        secondpart.start();
        //thirdpart.start();
        //fourthpart.start();
    }

}
