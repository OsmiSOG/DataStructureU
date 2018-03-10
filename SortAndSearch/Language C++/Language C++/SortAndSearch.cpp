#include <iostream>
#include <conio.h>
#include <cstdlib>
#include <vector>
#include <string>

using namespace std;
int Option();//initialize function Option
int* BubbleSort(int*, int);//Initialize function BubbleSort
int* InsertionSort(int*, int);//Initialize function InsertionSort
int LinealSearch(int*, int, int);//Initialize function LinealSearch

/*
This method main is the read the numbers and separate by comma and run the functions
@ author Santiago
*/
int main()
{
	string NumString;//The string read for the user
	vector<string> StrNumbers;//
	vector<int> Numbers;

	cout << "Enter please numbers separated for comma" << endl;
	cin >> NumString;//The string read for the user

	//This process for separate the string for commas
	size_t pos1 = 0;
	size_t pos2 = 0;
	while (pos2 != NumString.npos)
	{
		pos2 = NumString.find(",", pos1);
		if (pos2 != NumString.npos)
		{
			if (pos2 > pos1)
				StrNumbers.push_back(NumString.substr(pos1, pos2 - pos1));
			pos1 = pos2 + 1;
		}
	}
	StrNumbers.push_back(NumString.substr(pos1, NumString.size() - pos1));

	//This for convert of String vector to Integer vector
	for (int i = 0; i < StrNumbers.size(); i++)
	{
		int num = atoi(StrNumbers.at(i).c_str());
		Numbers.push_back(num);
	}

	/*-----------------------------------------------------------------------------*/
	//This for passes the vector to a pointer array
	int* ANumbers = new int[Numbers.size()];
	for (int i = 0; i < Numbers.size(); i++)
	{
		ANumbers[i] = Numbers[i];
	}

	
	int option = Option();//The funcition option request a option of sort or search and return a option
	while (option != 0)//if option is equal to 0 Exit
	{
		int* Sort = new int[Numbers.size()];//In this array store the sort array that return the sort function
		int search;//this store the index that return lineal search function 
		switch (option)
		{
			case 1:// Bubble Sort 
			{
				Sort = BubbleSort(ANumbers, Numbers.size());//Function bubbleSort Parameters(Array, Array size)
				for (int i = 0; i < Numbers.size(); i++)//print sort array
				{
					cout << Sort[i]<<" ";
				}
			}
			break;
			case 2:// Insertion Sort
			{
				Sort = InsertionSort(ANumbers, Numbers.size());//Function InsertionSort Parameters(Array, Array size)
				for (int i = 0; i < Numbers.size(); i++)//print sort array
				{
					cout << Sort[i] << " ";
				}
			}
			break;
			case 3://Lineal Search
			{
				int data;//number to search
				cout << "Enter please one number for search in your array original" << endl;
				cin >> data;//User write a number a search
				search = LinealSearch(ANumbers, data, Numbers.size());//Funtion Lineal search
				cout << "Your number starting account in 0 is in the index: "<<search << endl;//print index of number searched
			}
			break;
		}
		option = Option();//Again reques a option
	}

	//cout << sizeof(ANumbers) / sizeof(int) << endl;
	system("PAUSE");
	return 0;
}

/*
In this function request user a chose option for run. 
Return the number of the option
*/
int Option()
{
	int option;
	cout << "\nChose a option of ordering or search" << endl;
	cout << "0. Exit" << endl << "1. Bubble Sort" << endl << "2. Isertions Sort" << endl << "3. Lineal Search" << endl;
	cin >> option;

	return option;
}

/*
In this function sort the array of the parameter 
This fuction makes comparasions between pairs adjacent
@ param Array - Unsorted array
@ param Size  - Array size
*/
int* BubbleSort(int* Array, int size)
{
	bool swapped;
	int swap;
	for (int i = 0; i < size-1; i++){
		swapped = false;
		for (int j = 0; j < size-1; j++)
		{
			/*Compare to adjacent elements*/
			if (Array[j] > Array[j + 1])
			{
				/*Swap them*/
				swap = Array[j];
				Array[j] = Array[j + 1];
				Array[j + 1] = swap;
				swapped = true;
 			}
		}
		//If no number was swapped, the array is sorted now
		if (swapped == false)
			break;
	}
	return Array;//retunr sorted Array
}

/*
In this function sort the array of the parameter
In this function the array is worked with sub-arrays 
@ param Array  - Unsorted array 
@ param size  - Array size
*/
int* InsertionSort(int* Array, int size)
{
	int x; //Value to insert
	int index; //Hole position 
	for (int i = 1; i<size; i++)
	{
		/*select value to be moved */
		x = Array[i];
		index = i;
		/*locate hole position for the value to be inserted*/
		while (index > 0 && Array[index - 1]>x)
		{
			Array[index] = Array[index - 1];
			index = index - 1;
		}

		Array[index] = x;// insert the values at hole position
	}
	return Array;
}

/*
This function it is search the index of anumber of the array
sequntial search makeing comparasion one by one of the number to search 
@ param Array - unsorted array 
@ param data  - number to search
@ param size  - Array size
*/
int LinealSearch(int* Array, int data, int size)
{
	int index = -1;
	/*compare with all tehe elements of the array*/
	for (int i = 0; i < size; i++)
	{
		if (Array[i] == data)
		{
			index = i;
			break;
		}
	}
	return index;
}