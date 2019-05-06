import java.util.Random;



public class Dining {

        private int farkId;
        philo[] philosophers;
        frk[] forks;
        Thread[] threads;



        public static void main(String args[]){

            Dining obj=new Dining();
            obj.init();
            obj.s_t_e();

        }
        public void init(){


            philosophers =new philo[5];
            forks =new frk[5];
            threads=new Thread[5];

            for(int i=0;i<5;i++){
                philosophers[i]=new philo(i+1);
                forks[i]=new frk(i+1);
            }

        }
        public void s_t_e(){

            for(int i=0;i<5;i++){
                final int index=i;
                threads[i]=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            philosophers[index].start(forks[index], (index-1>0) ?forks[index-1]:forks[5-1]);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                });
                threads[i].start();
            }

        }
    }


