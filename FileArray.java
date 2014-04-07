import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;

public class FileArray {

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int[] intArray = {2, 5, 66, 89, 2, 34, 99, 111};
        
        try {
            writeArray("BinaryFile",intArray);
            readArray("BinaryFile", intArray);
        } catch (IOException e) {
            out.print(e);
        }
    }

    public static void writeArray(String fileName, int[] array) throws FileNotFoundException, IOException {
       
        DataOutputStream outputFile = new DataOutputStream(new FileOutputStream(fileName, true));
	System.out.print("Writing numbers to binary file\n");
        for (int i = 0; i < array.length; i++) {
            outputFile.writeInt(array[i]);
	    System.out.print(array[i] + "\n");
        }
        outputFile.close();
    }

    public static void readArray(String fileName, int[] array) throws FileNotFoundException, IOException {
        DataInputStream inputFile = new DataInputStream(new FileInputStream(fileName));
        System.out.print("Reading numbers from binary file\n");
        for(int i = 0; i < array.length;i++){
            array[i] = inputFile.readInt();
	    System.out.print(array[i] + "\n");
        }
        inputFile.close();

}

}
