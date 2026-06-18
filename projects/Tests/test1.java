import java.util.Scanner;

public class test1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isrunning = true;

    // take number of participant  
        System.out.print("Enter number of participant: ");
        int nwar = scanner.nextInt();
        scanner.nextLine(); //for next string input
        String[] warnames = new String[nwar];
        int[] warscores = new int[nwar];

    //takes warrior name and score from user
        for(int i = 0; i < nwar; i++ ){ 
                System.out.printf("Enter %d warrior Name: ",i+1);
                warnames[i] = scanner.nextLine();
                System.out.printf("Enter %d warrior Score: ",i+1);
                warscores[i] = scanner.nextInt();
                scanner.nextLine(); //for next string input
        }
    
    // main menu

    while(isrunning){

        System.out.println("-------------------------------------------------");
        System.out.println("     Welcome to World Warrior Championship");
        System.out.println("-------------------------------------------------");
        System.out.println("1 : Star list");
        System.out.println("2 : Warrior Rank Classification");
        System.out.println("3 : Search a warrior");
        System.out.println("4 : Guess the champion game");
        System.out.println("5 : Exit");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter Your Choice: ");
        int useres1 = scanner.nextInt();



        if(useres1 == 1){
            starlist(warnames,warscores,nwar);
        }
        else if(useres1 == 2){
            ranklist(warnames,warscores,nwar);
        }
        else if(useres1 == 3){
            searchsys(warnames,warscores,nwar);
        }
        else if(useres1 == 4){
            guessgame(warnames,warscores,nwar);
        }
        else if(useres1 == 5){
            isrunning = false;
        }

    }
        
        

        
        scanner.close();
    }

// displays champion ,weakest and avf score
    static void starlist(String[] wnames,int[] wscores, int nwar){ 
        int cscore = 0;
        int lscore = 9999;
        double addwscores= 0;
        double avgsc;
        String cname = "";
        String lname= "";


        for(int i = 0; i < nwar ; i++){
            if(nwar <= 0){
                System.out.println("no list available");
                break;
            }
            else{
                if(wscores[i] >= cscore ){
                    cscore = wscores[i];
                    cname = wnames[i];
                }
                else if(wscores[i] <= lscore){
                    lscore = wscores[i];
                    lname = wnames[i];
                }
                addwscores += wscores[i];
           }
        }
        avgsc = addwscores/nwar;
        
        if(!(cname.isEmpty())){
                System.out.printf("Champion Name(s): %s and Score is %d\n",cname,cscore);
        }
        else{
                System.out.println("list not avaiblable");

        }
        
        if(!(lname.isEmpty())){
                System.out.printf("Weakest warrior Name(s): %s and Score is %d\n",lname,lscore);
        }
        else{
                System.out.println("list not avaiblable");

        }
        
                System.out.printf("Average Score is %.2f\n",avgsc);
    }
// display rank
    static void ranklist(String[] wnames,int[] wscores, int nwar){
        String[] rank = new String[nwar];
        for(int i = 0;i < nwar ; i++){
            if(wscores[i] >= 90){
                System.out.printf("%s --> S rank\n",wnames[i]);
                rank[i] = "S";
            }
            else if(wscores[i] < 90 && wscores[i]>= 80){
                System.out.printf("%s --> A rank\n",wnames[i]);
                rank[i] = "A";

            }
            else if(wscores[i] < 80 && wscores[i]>= 70){
                System.out.printf("%s --> B rank\n",wnames[i]);
                rank[i] = "B";

            }
            else if(wscores[i] < 70 && wscores[i]>= 60){
                System.out.printf("%s --> C rank\n",wnames[i]);
                rank[i] = "C";

            }
            else if(wscores[i] < 60){
                System.out.printf("%s --> D rank\n",wnames[i]);
                rank[i] = "D";
            }


        }
    }
    

//search
    static void searchsys(String[] wnames,int[] wscores, int nwar){ //i count able to figure out how i can take rank array from ranklist method
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter the warrior name you want to search for: ");
        String usearch = scanner.nextLine().toUpperCase();
        boolean isFound = false;

        //this what i didnt when i cant figure out how can i create rank list
        String[] rank = new String[nwar];
        for(int i = 0;i < nwar ; i++){
            if(wscores[i] >= 90){
                rank[i] = "S";
            }
            else if(wscores[i] < 90 && wscores[i]>= 80){
                rank[i] = "A";
            }
            else if(wscores[i] < 80 && wscores[i]>= 70){
                rank[i] = "B";

            }
            else if(wscores[i] < 70 && wscores[i]>= 60){
                rank[i] = "C";
            }
            else if(wscores[i] < 60){
                rank[i] = "D";
            }
        }

        for(int j = 0; j < nwar ; j++){
            if(usearch.equals(wnames[j].toUpperCase())){
                System.out.println("Warrior found! ");
                System.out.printf("Name: %s", wnames[j]);
                System.out.printf("Score: %d",wscores[j]);
                System.out.printf("Rank: %s",rank[j]);
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Warrior not Found!");
        }
        scanner.close();
    }

//guess game
    static void guessgame(String[] wnames,int[] wscores, int nwar){
        Scanner scanner = new Scanner(System.in);

        int cscore = 0;
        
        String cname = "";
        


        for(int i = 0; i < nwar ; i++){
            if(nwar <= 0){
                System.out.println("no list available");
                break;
            }
            else{
                if(wscores[i] >= cscore ){
                    cscore = wscores[i];
                    cname = wnames[i];
                }
           }
        }
        
        System.out.println("Welcome to guess game");
        System.out.println("Please Guess a warrior name: ");
        String userg = scanner.nextLine().toUpperCase();

        if(userg.equals(cname.toUpperCase())){
            System.out.println("Your guess was corect");
        }
        else{
            System.out.println("Your guess was incorect");

        }
        
        
        
        scanner.close();
    }
}
// for(String name : warnames){
        //     for(int score : warscores){
        //         System.out.printf("warrior name: %s  score: %d\n",name,score);
        //         break;
        //     }
        // }