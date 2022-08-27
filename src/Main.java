import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Stack processStack = new Stack();
    static Queue transferQueue = new Queue();
    static String[] messages;

    private static void enterMessage(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        messages = input.split(",");
    }

    private static void transfer() throws IOException {

        for(int i = 0; i <= messages.length - 1; i++){
            if(messages[i].length() > 250 ){
                throw new IndexOutOfBoundsException();
            }
            if(messages[i].equals("")){
                throw new IOException();
            }
            transferQueue.enQueue(messages[i]);
        }
    }

    private static void process(){
        while (!transferQueue.isEmpty()){
            String x = (String) transferQueue.deQueue();
            processStack.push(x);
            System.out.println("Messages send: " + x + " ");
        }
    }

    private static void printMessage(){
        System.out.println("Processing");
        while (!processStack.isEmpty()){
            System.out.println("Messages received: " + processStack.pop());
        }
    }

    public static void main(String[] args) {
        try{
            enterMessage();
            long startTime = System.currentTimeMillis();
            transfer();
            process();
            printMessage();
            long stopTime  = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("The time it takes to print message: " + elapsedTime + "ms");
        }catch (IndexOutOfBoundsException ex){
            System.out.println("You can't input more than 250 characters.");
        }catch (IOException e){
            System.out.println("Message can't be empty.");
        }
    }
}
