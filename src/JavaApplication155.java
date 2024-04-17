import java.util.Scanner;

public class JavaApplication155 {

    public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
        System.out.println("Gaffud, Richard Earl & Mendoza, Kyran Xandre");
        System.out.println("Please Enter value for t:");
        int t = in.nextInt();
        switch (t) {
            case 1:
                System.out.println("Enter the number of syllables of the song:");
                int s = in.nextInt();
                System.out.println("Enter number of children who will play the game(n<=26):");
                int n = in.nextInt();
                Queue<String> nchildren = new Queue<>(n); // initialize queue with n children
                Stack<String> elimchildren = new Stack<>(n); // initialize stack with n children
                
                //Enter for loop to populate queues
                for (char letter = 'A'; letter < 'A' + n; letter++) {
                    nchildren.enqueue(String.valueOf(letter));
                }
                
                // Print children from first row to last row
                System.out.println("Children:");
                for (char letter = 'A'; letter < 'A' + n; letter++) {
                    System.out.print(letter + " ");
                }
                System.out.println(); // to provide one space after printing children names.
                
                // Start of the game
                int round = 1;
                while (!nchildren.isEmpty() ) {
                    System.out.println("after round " + round + ":");
                    for (int sa = 1; sa <= s; sa++) {
                        String CurrentChild = nchildren.dequeue(); // to dequeue the current child
                        // Condition to check if it is not the last syllable yet
                        if (sa!=s) {
                            nchildren.enqueue(CurrentChild); // enqueue back if not last child yet
                        } else {
                            elimchildren.push(CurrentChild); // push to stack if it is the last child
                        }
                    }
                    // Printing of queue contents; prints "Empty" when queue is empty
                    if (nchildren.isEmpty()) 
                        System.out.println("Empty");
                     else {
                        for(int i=0; i<nchildren.size();i++){
                           String child=nchildren.dequeue();
                           System.out.print(child+" ");
                           nchildren.enqueue(child);
                           
                        
                        }
                         System.out.println();
                    }
                    round++;
                }
                
                // Print the winning order
                System.out.print("\nWinning order: ");
                while (!elimchildren.isEmpty()) {
                    System.out.print(elimchildren.pop() + " ");
                                    
                }
                break;
                
            
        }
    }
}

    
    

