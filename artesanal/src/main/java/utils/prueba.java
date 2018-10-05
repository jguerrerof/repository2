package main.java.utils;
 

public class prueba {
 
    public static void main(String[] args) {
        try {
          
        	System.out.println("el main****");
        	
        	double a[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
            double b[][] = new double [3][3];
            int i, j;
         
            for(i=0; i< 3; i++)
              for(j=0; j<3; j++)
                b[i][j] = a[i][j] * a[i][j];
         
         
            for(i=0; i< 3; i++)
            {
              for(j=0; j<3; j++)
                System.out.print(b[i][j] + " ");
              System.out.println("");
            }
        	
            ////
            
            double q[] = { 10, 23.5, 15, 7, 8.9 }; 
            double total = 0; 
            int r;

            for (r=0; r<5; r++) 
              total += q[r];

            System.out.println( "La media es:" ); 
            System.out.println( total / 5 ); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	}
