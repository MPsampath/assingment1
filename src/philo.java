import java.util.Random;

public class philo {
    private int philId;
    private frk left,right;

    public philo(int philId){
        this.philId=philId;
    }

    public void start(frk left,frk right) throws InterruptedException{

        this.left=left;
        this.right=right;

        while(true){
            if(new Random().nextBoolean()){
                eat();
            }else{
                think();
            }
        }
    }

    public void think() throws InterruptedException{

        System.out.println("The Philosopher: "+philId +" is now thinking");
        Thread.sleep(new Random().nextInt(1000)+100);
        System.out.println("The Philosopher : "+philId +" has stopped thinking.");
    }

    public void eat() throws InterruptedException{

        boolean rightPick=false;
        boolean leftPick=false;

        System.out.println(philId +" philosoper is now humgry and want to eat.");

        System.out.println(philId +" philosoper is now picking up the Fork: "+left.forkId);
        leftPick =left.pick(philId);

        if(!leftPick){
            return;
        }
        System.out.println(philId+"philosoper is now picking up the fork: "+right.forkId);
        rightPick =left.pick(philId);

        if(!rightPick){
            left.free();
            return;
        }

        System.out.println(+philId +"philosoper is now eating");

        Thread.sleep(new Random().nextInt(1000)+100);

        left.free();
        right.free();

        System.out.println(philId+"philosoper hasa stopped eating and freed the Forks.");
    }

}
