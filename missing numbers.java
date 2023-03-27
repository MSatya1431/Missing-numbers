import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) 
    {
    // Write your code here
        Map<Integer, Integer> arrMap=new HashMap<>();
        Map<Integer, Integer> brrMap=new HashMap<>();
        for(int num:arr)
        {
            arrMap.put(num, arrMap.getOrDefault(num, 0)+1);
        }
        for(int num:brr)
        {
            brrMap.put(num, brrMap.getOrDefault(num, 0)+1);
        }
        List<Integer> missing=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: brrMap.entrySet())
        {
            int num=entry.getKey();
            int count=entry.getValue();
            if(!arrMap.containsKey(num)||arrMap.get(num)<count)
            {
                missing.add(num);
            }
        }
        Collections.sort(missing);
        return missing;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(sc.nextInt());
        }
        int m=sc.nextInt();
        List<Integer> brr=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            brr.add(sc.nextInt());
        }
        List<Integer> result=missingNumbers(arr, brr);
        for(int num:result)
        {
            System.out.print(num+" ");
        }
        sc.close();
    }

}
