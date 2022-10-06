import java.util.Arrays;

class multi_thread extends Thread{

    public static int average=0, Minimum=0,Maximum=0,Medium=0;
    public static int arraylen= 7;
    public static  int[] array = new int[]{90,81,78,95,79,72,85};
    
    public multi_thread(int computeAverage) {
    }
    public static void main(String[] args) {
            multi_thread MTH1 = new multi_thread(computeAverage(array.length));
            multi_thread MTH2 = new multi_thread(computeMin(array.length));
            multi_thread MTH3 = new multi_thread(computeMax(array.length));
            multi_thread MTH4 = new multi_thread(computeMedium(array.length));
            Thread T1 = new Thread(MTH1);
            Thread T2 = new Thread(MTH2);
            Thread T3 = new Thread(MTH3);
            Thread T4 = new Thread(MTH4);


            T1.start();
            T2.start();
            T3.start();
            T4.start();
       
    }
    public void run(){
        System.out.println("Thread "+ Thread.currentThread().getId()+" - The average value is  "+computeAverage(array.length));
        System.out.println("Thread "+ Thread.currentThread().getId()+" - The minimum value is  "+computeMin(array.length));
        System.out.println("Thread "+ Thread.currentThread().getId()+" - The maximum value is  "+computeMax(array.length));
        System.out.println("Thread "+ Thread.currentThread().getId()+" - The medium value is  "+computeMedium(array.length));

      
    }
   
  
    
    private static int computeMedium(int n) {
        Arrays.sort(array);
 
        // check for even case
        if (array.length % 2 != 0)
             return (int)array[arraylen / 2];
 
        return (int) ((int)(array[(array.length - 1) / 2] + array[array.length/ 2]) / 2.0);
        //System.out.println("Medium is" + );
    }

    private static int computeAverage(int n) {
        int total = 0;

        for(int i=0; i<array.length; i++){
        	total = total + array[i];
        }
        return average = total / array.length;
        ///System.out.println("The average is "+ average);
    }
    private static int computeMin(int n) {
        int res = array[0];
        for (int i = 1; i < array.length; i++)
            res = Math.min(res, array[i]);
           // System.out.println("Minimum is " + res);
        return res;
    
    }
    private static int computeMax(int n) {
        int res = array[0];
        for (int i = 1; i < array.length; i++)
           res = Math.max(res, array[i]);
            //System.out.println("Maximum is " + res);
        return res;
    }
    

    }