package ua.kpi.fict.acts.it03;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUnit implements ITextUnit
{

    private StringBuilder loadedText;
    int[] piArray;

    public TextUnit(String file) throws IOException
    {
        loadText(file);
    }

    @Override
    public int findFirst(String file, String findingText) throws IOException
    {
//        loadText(file);
        createPiArr(findingText);
        return findNext(file, findingText, 0);
    }

    @Override
    public Integer[] findAll(String file, String findingText) throws IOException {
//        loadText(file);
        createPiArr(findingText);
        List<Integer> result = new ArrayList<>();
        int point = findNext(file, findingText,0);
        while(point != -1)
        {
            result.add(point);
            point = findNext(file, findingText, point+1);
        }
        Integer[] arr = result.toArray(new Integer[0]);
        return arr;
    }

    @Override
    public void changeFirst(String file, String findingText, String changedText) throws IOException {
//        loadText(file);
        createPiArr(findingText);
        StringBuilder inMemoryText = loadedText;
        int changePoint = findNext(file, findingText, 0);
        inMemoryText.delete(changePoint, changePoint+findingText.length());
        inMemoryText.insert(changePoint,changedText);

//        try(FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write(String.valueOf(inMemoryText));
//        }
    }

    @Override
    public void changeAll(String file, String findingText, String changedText) throws IOException {
        createPiArr(findingText);
        Integer[] allPoints = findAll(file, findingText);
        StringBuilder inMemoryText = loadedText;
        for(int i = allPoints.length-1;i >= 0 ;i--)
        {
            inMemoryText.delete(allPoints[i], allPoints[i]+findingText.length());
            inMemoryText.insert(allPoints[i], changedText);
        }
//        try(FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write(String.valueOf(inMemoryText));
//        }
    }

    private void loadText(String file) throws IOException
    {
        StringBuilder inMemoryText = new StringBuilder("");
        try(FileReader fileReader = new FileReader(file))
        {
            Scanner scan = new Scanner(fileReader);
            while(scan.hasNextLine())
            {
                inMemoryText.append(scan.nextLine()+"\n");
            }

        } catch (IOException e)
        {
            throw new IOException(e.getMessage());
        }
        loadedText = inMemoryText;
    }


    private void createPiArr(String findingText)
    {
        int[] piArr = new int[findingText.length()];
        int j = 0;
        int i = 1;
        while( i < findingText.length() )
        {

            if(findingText.charAt(i) != findingText.charAt(j))
            {
                if(j!=0)
                {
                    j=piArr[j-1];
                }
                else
                {
                    piArr[i] = 0;
                    i++;
                }
            }
            else
            {
                piArr[i]=j+1;
                i++;
                j++;

            }
        }
        piArray = piArr;
    }

    private int findNext(String file, String findingText, int lastPoint) throws IOException
    {
        int k = lastPoint;
        int l = 0;
        while(k < loadedText.length())
        {
            Boolean isSame = loadedText.charAt(k) == findingText.charAt(l);
            if(isSame)
            {
                k++;
                l++;
                if(l == findingText.length())
                {
                    return k - findingText.length();
                }
            }
            else
            {
                k++;
                if(l != 0)
                {
                    l = piArray[l-1];
                }
            }
        }


        return -1;
    }

}
