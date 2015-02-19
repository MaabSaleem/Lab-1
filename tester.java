import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tester {   //main tester class

	ArrayList<matrix> myList = new ArrayList<matrix>();
	int rows, columns;
	public void GetMatrix(String filename) throws IOException //function to retrieve all the matrices
	{
		FileReader Fr= new FileReader(filename);
		BufferedReader hello = new BufferedReader(Fr);
		String temp;
		String[] sizes;
		String[] row_elements;
		String[] column_elements;
		int number=0;
		while( (temp=hello.readLine()) != null)
			
		{
			
			if(temp.equals(";")) //this tells us that what follows is a new matrix and its info
			{

				temp=hello.readLine(); //the first line has matrix size

				sizes= temp.split(" ");
				rows = Integer.parseInt(sizes[0]);
				
				columns=Integer.parseInt(sizes[1]);

				int hii[][]= new int[rows][columns];
				for(int i=0; i<rows; i++) //loop to get matrix elements and save them
				{
					temp=hello.readLine();

					for(int j=0; j<columns; j++)
					{
						column_elements = temp.split(" ");
						
						
						hii[i][j]=Integer.parseInt(column_elements[j]);

					}
				}
				myList.add(new matrix(hii, rows,columns)); //adding matrix to the arraylist
				
				
				
			}
		}

		}
		
	
	public int test_addition()
	{
		
		matrix sum= myList.get(0).AddMatrix(myList.get(1));
		sum= myList.get(1).AddMatrix(myList.get(0));
		
		if (sum == null) //if order is not same
		{
			
			return 0;
		}
		
		for(int i=0; i<sum.rows; i++)
		{
			System.out.print("\n");
			for(int j=0; j<sum.columns; j++)
			{
				
				System.out.print(sum.arrayy[i][j]);
				System.out.print("\t");
			}
		}
		return 1;
	}
	public int test_sub()
	{
		matrix sub= myList.get(0).SubMatrix(myList.get(1));
		sub= myList.get(1).SubMatrix(myList.get(0));
		
		if (sub == null) //if order is not same
		{
			
			return 0;
		}
		
		for(int i=0; i<sub.rows; i++)
		{
			System.out.print("\n");
			for(int j=0; j<sub.columns; j++)
			{
				
				System.out.print(sub.arrayy[i][j]);
				System.out.print("\t");
			}
		}
		return 1;
	}
	public int test_mul()
	{
		matrix mul= myList.get(0).Multiply(myList.get(1));
		mul= myList.get(1).Multiply(myList.get(0));
		
		if (mul == null)
		{
			
			return 0;
		}
		
		for(int i=0; i<mul.rows; i++)
		{
			System.out.print("\n");
			for(int j=0; j<mul.columns; j++)
			{
				
				System.out.print(mul.arrayy[i][j]);
				System.out.print("\t");
			}
		}
		return 1;
	}

	public int test_muladd()
	{
		matrix mul= myList.get(0).Multiply(myList.get(1));
		mul= myList.get(1).Multiply(myList.get(0));
		
		if (mul == null)
		{
			
			return 0;
		}
		
	
		matrix sum= myList.get(0).AddMatrix(mul);
		for(int i=0; i<sum.rows; i++)
		{
			System.out.print("\n");
			for(int j=0; j<sum.columns; j++)
			{
				
				System.out.print(sum.arrayy[i][j]);
				System.out.print("\t");
			}
		}
		return 1;
		
	}
	public static void main(String[] args) throws IOException {
		
		Tester t = new Tester();
		Scanner scan = new Scanner(System.in);
	
		
	
		System.out.println("Please enter the name of the file");
		String name = scan.next();
		t.GetMatrix(name);

		System.out.println("Please enter the operation (Note: Enter *+ for multipling and then adding");
		String i = scan.next();
		if(i.equals("+"))
		{
			t.test_addition();
		}
		if(i.equals("-"))
		{
			t.test_sub();
		}
		if(i.equals("*"))
		{
			t.test_mul();
		}
		if(i.equals("*+"))
		{
			t.test_muladd();
		}
		
		
	}

}
