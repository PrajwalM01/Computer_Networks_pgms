import java.util.*;

public class LB {
    static void solution(int ptsize, int output, int bucketcap, int currentBucket) {
        if (currentBucket + ptsize > bucketcap) {
            System.out.println("Bucket Overflow !! Dropping packet of size " + ptsize);
            return;
        }

        currentBucket += ptsize;
        System.out.println("Packet added. Current bucket size: " + currentBucket);

        while (currentBucket > 0) {
            int send = Math.min(output, currentBucket);
            System.out.println(send + " Bytes outputted");
            currentBucket -= send;
        }
    }

    public static void main(String[] args) {
        int pts, buckcap, n, output, currentBucket = 0;

        try (Scanner sc = new Scanner(System.in)) {
            Random rand = new Random();
            System.out.println("Enter the number of data packets ");
            n = sc.nextInt();
            System.out.println("Enter the bucket capacity");
            buckcap = sc.nextInt();
            System.out.println("Enter the output rate");
            output = sc.nextInt();

            for (int i = 0; i < n; i++) {
                pts = rand.nextInt(1000);
                System.out.println("Packet no " + (i + 1) + " | Packet Size " + pts);
                solution(pts, output, buckcap, currentBucket);
            }
        }
    }
}
