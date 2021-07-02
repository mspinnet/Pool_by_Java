package ex00;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str;
        int len = 0;
        Map<String, String> mapa = new HashMap<>();
        try(FileInputStream fin = new FileInputStream("./src/ex00/signatures.txt"))
        {
            byte[] buff = new byte[fin.available()];
            fin.read(buff, 0, fin.available());
            str = new String(buff);
            String[] arr1 = str.split("\\n");
            String[] arr2;
            for (int i = 0; i < arr1.length; i++)
            {
                arr2 = arr1[i].split(", ");
                mapa.put(arr2[1], arr2[0]);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        while ((str = in.nextLine()).equals("42") == false)
        {
            try(FileInputStream fin = new FileInputStream(str))
            {
                int i=-1;
                int b= 0;
                String str1;
                str1 = "";
                while((i=fin.read())!=-1 && b < 5){
                    str1 += Integer.toHexString(i).toUpperCase();
                    b++;
                }
                int flag = 0;
                for (Map.Entry<String, String> entry : mapa.entrySet())
                {
                    if (entry.getKey().regionMatches(0 , str1, 0, 4) == true)
                    {
                        flag = 1;
                        try(FileOutputStream fos = new FileOutputStream("./src/ex00/result.txt", true))
                        {
                            byte[] buff = (entry.getValue() + "\n").getBytes();
                            fos.write(buff, 0, buff.length);
                        }
                        catch(IOException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    }
                }
                if (flag == 1)
                    System.out.println("PROCESSED");
                else
                    System.out.println("UNDEFINED");
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
        in.close();
    }
}
