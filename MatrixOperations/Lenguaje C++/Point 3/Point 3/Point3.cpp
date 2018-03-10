#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include <vector>

using namespace std;
int main()
{
	int i, j;//counter of for
	int M;//Varibles whit size of the array

	cout << "Enter please one number for size of matrix" << endl;
	cin >> M;

	//Create the matrix
	int** Matrix = new int*[M];
	for (i = 0; i < M; i++)
	{
		Matrix[i] = new int[M];
	}
	
	vector<int>Even;//Array of size e store even numbers of the matrix 
	vector<int>Odd;//Array of size o store Odd numbers fo the matrix
	vector<int>Positive;//Array of size p store Positives numbers of the matrix
	vector<int>Negatives;//Array of size n store negatives numbers of matrix

	srand(time(NULL));//for random

	//To travel the matrix 	
	for (i = 0; i < M; i++){
		for (j = 0; j < M; j++)
		{
			Matrix[i][j] = -20 + rand() % (20 + 11);//Fill the matrix whit random numbers (-20, 20)
		}
	}

	//Print the matrix
	for (i = 0; i < M; i++) {
		for (j = 0; j < M; j++)
		{
			cout << Matrix[i][j] << " ";
		}
		cout << endl;
	}cout << endl;

	for (i = 0; i < M; i++) {
		for (j = 0; j < M; j++)
		{
			if (Matrix[i][j] % 2 == 0)//If the remainder of the number in the position i-j is equal to 0 it store in matrix even
			{
				Even.push_back(Matrix[i][j]);
			}
			else//If the remainder of the number position i-j is different to 0 it store in matrix Odd
			{
				Odd.push_back(Matrix[i][j]);
			}
			if (Matrix[i][j] >= 0)//If the number position i-j is greater to 0 the number store in matrix positive
			{
				Positive.push_back(Matrix[i][j]);
			}
			else////If the number position i-j is less to 0 the number store in matrix negatives
			{
				Negatives.push_back(Matrix[i][j]);
			}
		}
	}

	//print even numbers
	cout << "Even numbers: " << Even.size() << endl;
	for (i = 0; i < Even.size(); i++)
	{
		cout << Even[i] << " ";
	}cout << endl;

	//print Odd numbers
	cout << "Odd numbers: " << Odd.size() << endl;
	for (i = 0; i < Odd.size(); i++)
	{
		cout << Odd[i] << " ";
	}cout << endl;
	
	//print Positive numbers
	cout << "Positive numbers: " << Positive.size() << endl;
	for (i = 0; i < Positive.size(); i++)
	{
		cout << Positive[i] << " ";
	}cout << endl;

	//print Negative numbers
	cout << "Negative numbers: " << Negatives.size() << endl;
	for (i = 0; i < Negatives.size(); i++)
	{
		cout << Negatives[i] << " ";
	}cout << endl;

	getch();

	return 0;
}
