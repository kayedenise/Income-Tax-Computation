import java.util.*;

public class Salary 
{
   public static void main(String[] args)
   {
      Scanner c = new Scanner(System.in);
      
      double taxable = 0;
      double totalded = 0;
 
      System.out.print("Enter your monthly salary: ");
      double sal = c.nextDouble();
      
      System.out.println("Net Monthly Income: P " + String.format ("%.2f",netmonthly(sal, taxable, totalded)));
   }
   
   public static double netmonthly (double sal, double taxable, double totalded)
   {
      double sss = 0;
      double ph = 0;
      double pi = 0 ;
      double wh = 0;
      double netmonthly; 
       
      //sss
      if (sal >= 16000)
      {
         sss = 581.30;
      }
      
      else if (sal < 16000)
      {
         sss = sal * 0.0363;
      }
      ///ph
      if (sal <= 10000)
      {
         ph = 137.50;
      }
      
      else if (sal > 10000 && sal < 40000) 
      {
         ph = sal * 0.0275 / 2;
      }
      
      else if (sal > 40000)
      {
         ph = 550;
      }
      //pag ibig
      if (sal >= 5000)
      {
         pi = 100;
      }
      
      else if (sal < 5000)
      {
         pi = sal * 0.02;
      }
      //total deduction
      totalded = sss + ph + pi;
      taxable = sal - totalded;
      
      //taxable monthly salary
      if (sal > 90000) 
      {
         double ex = (sal - 90000) / 12;
         taxable = ex + taxable; 
      }
      
      //withholding
      if (taxable == 20833)
      {
      	wh = taxable;
      }

      else if ((taxable > 20833 && taxable < 33333) || taxable == 33333)
      {
      	wh = (taxable - 20833.33) * 0.20;
      }

      else if ((taxable > 33333 && taxable < 66667) || taxable == 66667)
      {
      	wh = (taxable - 33333.33) * 0.25 + 2500;
      }

      else if ((taxable > 66667 && taxable < 166667) || taxable == 166667)
      {
      	wh = (taxable - 66666.67) * 0.30 + 10833.33;
      }

      else if ((taxable > 166667 && taxable < 666667) || taxable == 666667) 
      {
      	wh = (taxable - 166666.67) * 0.32 + 40833.33;
      }

      else if (taxable > 666667)
      {
      	wh = (taxable - 666666.67) * 0.35 + 200833.33;
      }
      
      System.out.println("Taxable Monthly Salary: P " + String.format ("%.2f", taxable));
      System.out.println("Total Deductions: P " + String.format ("%.2f",totalded));
      System.out.println("Withholding Tax: P " + String.format ("%.2f", wh));
      
      netmonthly = taxable - wh;
      return netmonthly;
   }
}