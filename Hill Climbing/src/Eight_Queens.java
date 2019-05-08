
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Eight_Queens {

    private static final int RUNTEST = 500;

    public Eight_Queens() {

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

            System.out.println("Enter the value for N in this n-Queen problem: ");
            int NODE_SIZE= scan.nextInt();
            //Take the input size for the n queen problem




            Node.setSize(NODE_SIZE);

            Eight_Queens board = new Eight_Queens();

            System.out.println("Test for " + NODE_SIZE + " Queens problem : ");


            //Initializing all the variables

            double SM_SUM_Successes = 0, SM_AVE_Successes = 0, SM_Success_Steps=0,
                    SM_Avg_Success_Steps=0, SM_Fail_Steps = 0, SM_Avg_Fail_Steps = 0 ;
            double SA_Sum_Successes = 0, SA_AVE_Success = 0, SA_Success_Steps = 0,
                    SA_Avg_Success_Steps = 0, SA_Fail_Steps = 0, SA_Avg_Fail_Steps = 0;
            double RR_Sum_Successes = 0, RR_AVE_Successes = 0, RR_Success_Steps = 0,
                     RR_Avg_Success_Steps=0, RandomRestart_Count=0;
            double RRS_Sum_Successes = 0, RRS_Ave_Successes = 0,
                    RRS_Success_Steps = 0, RRS_Avg_Success_Steps=0,
                    RandomRestartSideways_Count=0;



            for (int currentTest = 1; currentTest <= RUNTEST; currentTest++) {


                Queen[] initialBoard = board.generateChessBoard();


                RandomRestart randomRestart
                        = new RandomRestart(initialBoard);

                SteepestAscent steepestAscent
                        = new SteepestAscent(initialBoard);

                SidewaysMove sidewaysMove
                        = new SidewaysMove(initialBoard);

                RandomRestartSideways randomRestartSideways
                        = new RandomRestartSideways(initialBoard);


                Node randomRestartNode = randomRestart.climbingAlgo();
                Node steepestAscentNode = steepestAscent.climbingAlgo();
                Node sidewaysMoveNode = sidewaysMove.climbingAlgo();
                Node randomRestartSidewaysNode = randomRestartSideways.climbingAlgo();


                //Random Restart without sideways move
                if (randomRestartNode.getH() == 0) {
                    RR_Sum_Successes++;

                    RR_Success_Steps=randomRestart.getStepCount();
                    RR_Avg_Success_Steps=RR_Avg_Success_Steps+
                            RR_Success_Steps;
                    RandomRestart_Count=RandomRestart_Count+(randomRestart.getRandomRestartUsed());
                }


                //Random Restart with sideways move
                if (randomRestartSidewaysNode.getH() == 0) {
                    RRS_Sum_Successes++;

                    RRS_Success_Steps=randomRestartSideways.getStepCount();
                    RRS_Avg_Success_Steps=RRS_Avg_Success_Steps+
                            RRS_Success_Steps;
                    RandomRestartSideways_Count=RandomRestartSideways_Count+randomRestartSideways.getRandomRestartSidewaysUsed();
                }



                //Steepest Ascent
                if (steepestAscentNode.getH() == 0) {



                    SA_Sum_Successes++;
                    SA_Success_Steps=steepestAscent.getSteps();
                    SA_Avg_Success_Steps=SA_Avg_Success_Steps+SA_Success_Steps;



                }
                else
                {
                    SA_Fail_Steps=steepestAscent.getSteps();
                    SA_Avg_Fail_Steps=SA_Avg_Fail_Steps+SA_Fail_Steps;

                }

                if(currentTest==33)
                {
                    System.out.println("First Path for Steepest Ascent" );
                    ArrayList<Node> x =steepestAscent.listToPrint();
                    steepestAscent.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }

                if(currentTest==97){
                    System.out.println("Second Path for Steepest Ascent" );
                    ArrayList<Node> x =steepestAscent.listToPrint();
                    steepestAscent.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }


                if(currentTest==139) {
                    System.out.println("Second Path for Steepest Ascent");
                    ArrayList<Node> x = steepestAscent.listToPrint();
                    steepestAscent.printPath(x);
                    System.out.println("Path cost: " + x.size());


                }







                if (sidewaysMoveNode.getH() == 0) {
                    SM_SUM_Successes++;
                    SM_Success_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Success_Steps=SM_Avg_Success_Steps+SM_Success_Steps;

                }
                else{
                    SM_Fail_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Fail_Steps=SM_Avg_Fail_Steps+SM_Fail_Steps;




                }



                if(currentTest==376) {
                    System.out.println("Third Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());

                }

                if(currentTest==181)  {
                    System.out.println("First Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());


                }
                if(currentTest==214) {
                    System.out.println("Second Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());

                }











            }



            //Calculating Average
            SA_AVE_Success =
                    SA_Sum_Successes / RUNTEST;

            SM_AVE_Successes =
                    SM_SUM_Successes / RUNTEST;

            RR_AVE_Successes =
                    RR_Sum_Successes / RUNTEST;

            RRS_Ave_Successes =
                RRS_Sum_Successes / RUNTEST;






            System.out.println("Steepest Ascent :"

                    + " Success Count = " + SA_Sum_Successes
                    + " Success rate = " + SA_AVE_Success
                    + " Fail count = " + (500.0 - SA_Sum_Successes)
                    + " Failure rate = " + (1 - SA_AVE_Success)
                    + " Avg Success Steps : " + ((SA_Avg_Success_Steps)/(SA_Sum_Successes))
                    + " Avg Fail Steps : " + ((SA_Avg_Fail_Steps)/(500-SA_Sum_Successes)));



            System.out.println("Sideways Move :"

                    + " Success Count = " + SM_SUM_Successes
                    + " Success rate = " + SM_AVE_Successes
                    + " Fail count  = " + (500.0 - SM_SUM_Successes)
                    + " Failure rate = " + (1 - SM_AVE_Successes)
                    + " Avg Success Steps = " + (SM_Avg_Success_Steps/SM_SUM_Successes)
                    + " Avg Fail Steps = " + ((SM_Avg_Fail_Steps)/(500-SM_SUM_Successes)));



            System.out.println("Random Restart No Sideways:"

                    + " Success Count = " + RR_Sum_Successes
                    + " Success rate = " + RR_AVE_Successes
                    + " Fail Count = " + (500.0 - RR_Sum_Successes)
                    + " Failure rate = " + (1 - RR_AVE_Successes)
                    + " Avg Success Steps = " + ((RR_Avg_Success_Steps)/500)
                    + " Avg Random Restart =" + (RandomRestart_Count/500));

        System.out.println("Random Restart Sideways :"

                + " Success Count = " + RRS_Sum_Successes
                + " Success rate = " + RRS_Ave_Successes
                + " Fail Count = " + (500.0 - RRS_Sum_Successes)
                + " Failure rate = " + (1 - RRS_Ave_Successes)
                + " Avg Success Steps = " + ((RRS_Avg_Success_Steps)/500)
                + " Avg Random Restart = " + (RandomRestartSideways_Count)/500);

        }


        //Generate a Chess Board with randomly placing the Queens on the Board
    public Queen[] generateChessBoard(){
        Queen[] start = new Queen[Node.getSize()];
        Random gen = new Random();

        for (int i = 0; i < Node.getSize(); i++) {
            start[i] = new Queen(gen.nextInt(Node.getSize()), i);
        }
        return start;
    }

}
