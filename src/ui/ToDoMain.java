package ui;

import model.ToDoManager;

/**
 * The main class for the ToDoList application.
 *
 * @version 1.0 2023-10-08
 */

public class ToDoMain {

    /**
     * sc is the name given to the object that allows the program to read the user's input
     */
    private static java.util.Scanner sc;
    /**
     * con is the association relationship between the
     * MainPipeMania class and the PipeManiaController class
     */
    private static ToDoManager con;

    /**
     * Colors for the console
     */
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE

    public static final String PURPLE = "\u001B[35m"; // Magenta

    /**
     * ToDoMain class constructor
     * Method in charge of initializing the objects
     */
    public ToDoMain() {
        sc = new java.util.Scanner(System.in);
        con = new ToDoManager();
    }

    public static void main(String[] args) {
        // Creating an object of the class
        ToDoMain obPpal = new ToDoMain();
        // Variable to store the option chosen by the user
        int option= 0;

        //Loop to show the menu until the user
        // Exit option is 0
        do {
            option =obPpal.menu();
            obPpal.answerOption(option);
        }while (option !=0);

    }


    public int menu(){
        int input;
        System.out.println(PURPLE + "\t~~*~~*~~*~~*~~*~~*~~\n"+ RESET +
                                    "\t\t  WELCOME\n"+ PURPLE +
                                  "\t~~*~~*~~*~~*~~*~~*~~\n\n"+ PURPLE_BOLD +

                                 "\tPlease choose an option: \n\n"+ RESET+
                                 "\t(1) Add task / reminder\n" +
                                 "\t(2) Modify task / reminder\n" +
                                 "\t(3) Delete task / reminder\n\n" +

                "\t(0) To exit"
        );
        input = sc.nextInt();
        if(input<0 || input>2){
            System.out.println(CYAN + "Please enter a valid option" + RESET);
            input=sc.nextInt();
        }

        sc.nextLine();
        return input;

    }

    /**
     * Method that shows the general menu and gets the option chosen by the user
     * @param userOption, int is the option chosen by the user
     */
    public void answerOption(int userOption) {
        switch(userOption) {
            case 0:
                //System.out.println(BLUE + "Thanks for playing, see you soon!" + BLUE + RESET);
                break;
            case 1:

                break;
            case 2:
                //seeScores();
                break;
        }

    }



}
