import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        if (str.length() > 999 || str.length() == 0)
        {
            System.err.println("Illegal Argument");
            in.close();
            System.exit(-1);
        }
        int len = 0;
        int tmp = 0;
        int j = 0;
        int l = 0;
        int[] myArray = new int[65535];
        for (int i = 0; i < 65535; i++)
            myArray[i] = 0;
        for (char element : str.toCharArray())
        {
            myArray[(int)element]++;
        }
        for (int i = 0; i < 65535; i++) {
            if (myArray[i] != 0)
                len++;
        }
        int[] myArray2 = new int[len];
        for (int i = 0; i < 65535; i++)
        {
            if (myArray[i] != 0) {
                myArray2[j] = myArray[i];
                j++;
            }
        }
        j = 0;
        while (j + 1 < len)
        {
            if (myArray2[j + 1] > myArray2[j])
            {
                tmp = myArray2[j];
                myArray2[j] = myArray2[j + 1];
                myArray2[j + 1] = tmp;
                j = 0;
                continue;
            }
            else
                j++;
        }
        j = 0;
        if (len >= 10)
            l = 10;
        else
            l = len;
        str = "";
        for (int i = 0; i < l; i++)
        {
            while (j < 65535)
            {
                if (myArray[j] == myArray2[i])
                    break;
                j++;
            }
            str += "   " + (char)j;
            myArray[j] = 0;
            j = 0;
        }
        l++;
        String[] arr = new String[11];
        for (int i = 0; i < 10; i++)
            arr[i] = "";
        arr[10] = str;
        int i = 0;
        while (i < l - 1)
        {
            for (int k = (myArray2[i] * 10) / myArray2[0]; k > 0; k--)
                arr[10 - k] += "   #";
            i++;
        }
        i = 0;
        j = 1;
        if (myArray2[0] > 0 && myArray2[0] < 10)
            str = "   ";
        else if (myArray2[0] > 9 && myArray2[0] < 100)
            str = "  ";
        else if (myArray2[0] > 99 && myArray2[0] < 1000)
            str = " ";
        str += myArray2[0];
        if (myArray2[i] == myArray2[i + 1])
        {
            while (myArray2[i] == myArray2[i + 1] && i + 1 < l - 1)
            {
                if (myArray2[j] > 0 && myArray2[j] < 10)
                    str += "   ";
                else if (myArray2[j] > 9 && myArray2[j] < 100)
                    str += "  ";
                else if (myArray2[j] > 99 && myArray2[j] < 1000)
                    str += " ";
                str += myArray2[j];
                i++;
                j++;
            }
        }
        System.out.println(str);
        i = 0;
        while (i + 1 < 11 && j < l)
        {
            if (arr[i].length() < arr[i + 1].length())
            {
                if (myArray2[j] > 0 && myArray2[j] < 10)
                    arr[i] += "   ";
                else if (myArray2[j] > 9 && myArray2[j] < 100)
                    arr[i] += "  ";
                else if (myArray2[j] > 99 && myArray2[j] < 1000)
                    arr[i] += " ";
                arr[i] += myArray2[j];
                j++;
                if (arr[i].length() < arr[i + 1].length())
                    continue;
            }
            i++;
        }
        for (int k = 0; k < 11; k++)
            System.out.println(arr[k]);
    }
}
