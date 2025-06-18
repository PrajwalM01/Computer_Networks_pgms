import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA 
{
    public static BigInteger[] generatekey()
    {
       BigInteger p = BigInteger.probablePrime(512, new Random());
       BigInteger q = BigInteger.probablePrime(512, new Random());
       BigInteger n= p.multiply(q);
       BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
       BigInteger e = BigInteger.valueOf(65537);
       BigInteger d= e.modInverse(phi);
       return new BigInteger[] {e,d,n};
      
    }

    public static BigInteger encrypt(BigInteger message , BigInteger e,BigInteger n)
      {
        return message.modPow(e, n);
      }
      public static BigInteger decrypt(BigInteger ciphertext , BigInteger d,BigInteger n)
      {
        return ciphertext.modPow(d, n);
      }

      public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BigInteger[] keys = generatekey();
              BigInteger e =keys[0];
              BigInteger d = keys[1];
              BigInteger n = keys[2];
              System.out.println(" Enter the message ");
              BigInteger message = new BigInteger(scanner.nextLine().getBytes());
            System.out.println("public key "+e+" "+ n);
            System.out.println("private key "+d+" "+n);

            System.out.println("Encrypted message is:   "+encrypt(message, e, n));
            BigInteger enmsg = encrypt(message, e, n);
            System.out.println("Decrypted message is:    "+decrypt(enmsg, d, n));
            BigInteger demsg = decrypt(enmsg, d, n);

            String deypttext = new String(demsg.toByteArray());
            System.out.println("  "+deypttext);

        }
      }
}