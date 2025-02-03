package srcCode;

import java.io.RandomAccessFile;

public class MyGraph {
    int[][] a;
    int size;

    public MyGraph() {
        try{
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\NITRO\\Desktop\\CSD_PE\\Graph\\src\\srcCode\\input.txt", "r");
            size = Integer.parseInt(raf.readLine());
            a = new int[size][size];
            String s1 = "";
            int k = 0;
            while((s1= raf.readLine())!=null){
                String[] s = s1.split("\\s+");
                for(int i=0; i<size; i++) {
                    a[k][i] = Integer.parseInt(s[i]);
                }
                k++;
            }
            for(int i=0; i<size;i++){
                for(int j = i+1; j<size; j++){
                    a[j][i]=a[i][j];
                }
            }
        }catch (Exception e){
            System.out.println("error");
        }
    }
    public void display(){
        for(int i=0; i < size; i++){
            for(int j=0; j<size; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
