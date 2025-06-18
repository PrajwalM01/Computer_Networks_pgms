import java.util.Scanner;

public class crc {

    // CRC-CCITT polynomial (x^16 + x^12 + x^5 + 1)
    private static final int POLYNOMIAL = 0x11021;

    // Function to compute CRC16-CCITT for a given string
    public static int computeCRC16(String data) {
        int crc = 0xFFFF;  // Initial value for CRC-CCITT
        byte[] bytes = data.getBytes();  // Convert string to byte array

        for (byte b : bytes) {
            crc ^= (b << 8);  // XOR the byte into the CRC (shifted 8 bits)
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {  // Check if the most significant bit is 1
                    crc = (crc << 1) ^ POLYNOMIAL;  // Shift left and XOR with the polynomial
                } else {
                    crc = crc << 1;  // Just shift left if MSB is 0
                }
            }
        }

        return crc & 0xFFFF;  // Return the final 16-bit CRC value
    }

    // Main function to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input data from the user
        System.out.print("Enter data to transmit: ");
        String data = scanner.nextLine();

        // Compute CRC for the entered data
        int crc = computeCRC16(data);

        // Output the computed CRC
        System.out.println("Computed CRC: " + Integer.toHexString(crc).toUpperCase());

        // Simulate data transmission (adding CRC to the transmitted data)
        System.out.print("Enter received data: ");
        String receivedData = scanner.nextLine();

        // Check if the received data has an error by comparing the computed CRC
        int receivedCRC = computeCRC16(receivedData);

        if (crc == receivedCRC) {
            System.out.println("No error detected in the received data.");
        } else {
            System.out.println("Error detected in the received data.");
        }

        scanner.close();
    }
}

