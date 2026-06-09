import java.util.Scanner;
import java.util.Random;


public class GuessingGame{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Your have Started the guessing game please choose the options");
        System.out.println("1: to play default(1-100)");
        System.out.println("2: to change maxmium range");
        System.out.print("Please Chose a response(1 or 2): ");
        int userresponse = scanner.nextInt();
        
        int x = 100;
        int userinput = 0;
        int attempt = 1;
        int sdiff=10;
        int bdiff=25;
        

        if(userresponse == 2){
            System.out.print("Please Enter Your maximum range: ");
            x = scanner.nextInt();
            while(x <= 1){
                System.out.println("Please Enter Valid range(max range should be greater then 1)");
                System.out.print("Please Enter Your maximum range: ");
                x = scanner.nextInt();
            }
        }
        else if(userresponse != 1){
            System.out.print("Please Enter Valid option!!");
        }

        int rnum = random.nextInt(1,x);
        //System.out.println("DEVELOPER MODE: ANSWER IS "+ rnum ); //developer mode
         
        System.out.print("Enter ur guess: ");
        userinput = scanner.nextInt();
        

        while(userinput != rnum){
               System.out.println("Your guess is wrong");

            if(userinput > x || userinput < 1 ){
                System.out.println("Your entered guess is out of range. range : 1 - "+ x);
            }

            else if(userinput < rnum){
                if((rnum-userinput)<=sdiff){
                    System.out.println("you are very close from guess, GUESS HIGHER");
                }
                else if((rnum-userinput)<=bdiff && (rnum-userinput)>sdiff ){
                    System.out.println("you are far from guess, GUESS HIGHER");
                }
                else if((rnum-userinput)>bdiff){
                    System.out.println("you are too far from guess, GUESS HIGHER");     
                }
            }

            else if(userinput > rnum){
                if((userinput-rnum)<=sdiff){
                    System.out.println("you are close from guess, GUESS LOWER");        
                }
                else if((userinput-rnum)<=bdiff && (userinput-rnum)>=bdiff ){
                    System.out.println("you are far from guess, GUESS LOWER");     
                }
                else if((userinput - rnum)>bdiff){
                    System.out.println("you are too far from guess, GUESS LOWER"); 
                }
            }
            System.out.print("\nEnter ur guess: ");
            userinput = scanner.nextInt();
            attempt++;

        }
        System.out.printf("Entered guess is correct:%d\n",rnum);
        System.out.printf("Number of attempt it took: %d",attempt);

        scanner.close();
    }
}
