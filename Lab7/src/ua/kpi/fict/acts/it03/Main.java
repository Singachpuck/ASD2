package ua.kpi.fict.acts.it03;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String file = "D://ASD2//Lab7//src//ua//kpi//fict//acts//it03//for_3.3_test.txt";
        long time;
        try {
            ITextUnit tu = new TextUnit(file);
            for(int i = 0; i<1000; i++) {
                tu.findFirst(file, "whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou");
            }

            System.out.println("-----FindAllTest-----");

            time = System.nanoTime();
            for(int i = 0; i<1000; i++)
            {
                tu.findAll(file,"whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou");
            }
            time = System.nanoTime() - time;
            System.out.println("Time for 1000: "+time/1000000+" ms");

            System.out.println("----FindFirstTest----");

            time = System.nanoTime();
            for(int i = 0; i<1000; i++)
            {
                tu.findFirst(file,"whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou");
            }
            time = System.nanoTime() - time;
            System.out.println("Time for 1000: "+time/1000000+" ms");

            System.out.println("----ChangeAllTest----");

            time = System.nanoTime();
            for(int i = 0; i<1000; i++)
            {
                tu.changeAll(file,"whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou",
                        "whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou");
            }
            time = System.nanoTime() - time;
            System.out.println("Time for 1000: "+time/1000000+" ms");

            System.out.println("---ChangeFirstTest---");

            time = System.nanoTime();
            for(int i = 0; i<1000; i++)
            {
                tu.changeFirst(file,"whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou",
                        "whyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyouwhyareyou");

            }
            time = System.nanoTime() - time;
            System.out.println("Time for 1000: "+time/1000000+" ms");


            //tu.findAll(file, "wow");
        }catch (IOException err)
        {
            System.out.println(err.getMessage());
        }

    }

}
