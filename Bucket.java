import java.util.*;

  public class Bucket {
   static void solution(int ptsize, int output,int bucketcap)
       {
          if(ptsize>bucketcap)
           {
            System.out.println("Bucket Overflow !!");
           }
           else {
            while(ptsize>output)
            {
         System.out.println(output + " Bytes outputted");
          ptsize -= output;
           }
            if(ptsize > 0)
             {
                 System.out.println(ptsize + " Bytes outputted");
             } 

           }
       }
     public static void main(Strings[] args)
      {
        int pts,buckcap,n,output;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the number of data packets ");
       n = sc.nextInt();
        System.out.println("Enter the bucket capacity");
        buckcap = sc.nextInt();
        System.out.println("Enter the ouput rate");
        ouput = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            pts = rand.nextInt(1000);
            System.out.println("Packet no "+i+" Packet Size"+pts);
            solution(pts,output,buckcap);
        }


      }


  }

