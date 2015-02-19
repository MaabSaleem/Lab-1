import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;



public class matrix {
int number_matrices;
int rows;
int columns;
int arrayy[][]= new int[10][10];

public matrix(int[][] initialArray,int rowss,int columnss){
    arrayy = initialArray;
    rows=rowss;
    columns=columnss;
}



public matrix AddMatrix(matrix temp)
{
	
	if(temp.rows != this.rows || temp.columns != this.columns)
	{
		System.out.println("Error. The rows and columns of matrices don't match.");
		return null;
	}
	
	int sum [][]=new int[rows][columns];
	
	
	

	for(int i=0; i<rows; i++)
	{
		for(int j=0; j<columns; j++)
		{
			sum[i][j]=temp.arrayy[i][j]+arrayy[i][j];
		}
	}
	matrix summ= new matrix(sum,rows,columns);
	return summ;
	
}

public matrix SubMatrix(matrix temp)
{
	
	if(temp.rows != this.rows || temp.columns != this.columns)
	{
		System.out.println("Error. The rows and columns of matrices don't match.");
		return null;
	}
int diff [][]=new int[rows][columns];
	

	for(int i=0; i<rows; i++)
	{
		for(int j=0; j<columns; j++)
		{
			diff[i][j]=temp.arrayy[i][j]- arrayy[i][j];
		}
	}
	matrix difff= new matrix(diff,rows,columns);
	return difff;
	
}

public matrix Multiply(matrix temp)
{
	int sum=0;
	int product [][]=new int[rows][columns];
	
	if(columns != temp.rows)
	{
		System.out.println("Can't multiply");
		return null;
	}
	

    for (int c = 0; c < rows; c++)
    {
      for ( int d = 0; d <temp.columns; d++)
      {
        for ( int k = 0; k <temp.rows; k++)
        {
          sum = sum + arrayy[c][k]*temp.arrayy[k][d];
        }
 
       product[c][d] = sum;
        sum = 0;
      }
    }
    matrix mul= new matrix(product,rows,columns);
	return mul;
	
}



public static void main(String[] args)
{

}
}
