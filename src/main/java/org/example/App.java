package org.example;

import java.io.*;

public class App {

    private static String filePath = "C:\\Users\\Robi\\Desktop\\input_many_seconds_show.in";
    private static String filepathOut = "C:\\Users\\Robi\\Desktop\\input_many_seconds_show.out";
    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(filepathOut));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public App() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        init();
        writer.close();
    }

    public static void init() throws IOException {
        int c = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int n = Integer.parseInt(reader.readLine());
        int counter = 0;
        int s = 0;
        while ((line = reader.readLine()) != null) {
            counter++;
            if (counter % 2 != 0)
                s = Integer.parseInt(line);

            else {
                c++;
                double a[] = new double[s];
                for (int j = 0; j < a.length; j++) {
                    String[] b = line.split(" ");
                    a[j] = Double.parseDouble(b[j]);
                }
                peakMoments(c, a);
            }

            System.out.println();
        }
        reader.close();
    }

    private static void peakMoments(int k, double a[]) throws IOException {
        double max = a[0];
        double secondMax=a[0];
        int maxIndex = 0;
        int minIndex = 0;
        int secondmaxIndex = 0;
        int secondminIndex = 0;
        double s = 0;
        double min = a[0];
        double secondMin=a[0];
        int p=(secondmaxIndex + secondminIndex)/2;
        int q=(minIndex+maxIndex)+1;
        for (int i = 0; i <a.length; i++) {
                if (a[i] > max) {
                    secondMax = max;
                    max = a[i];
                    secondmaxIndex=maxIndex;
                    maxIndex = i;
                }
                if (min > a[i]) {
                    secondMax = min;
                    min = a[i];
                    secondminIndex=minIndex;
                    minIndex = i;
                }
            }
            if (maxIndex > minIndex)
                s = ((min - max)+(secondMin-secondMax) )* (-1);
            else
                s = (max - min)+(secondMax-secondMin);
        String fileContent = ("SHOW #" + k + ": " + (int) s);
        writer.write(fileContent);
        writer.newLine();

    }
}