# include <iostream>
#include <conio.h>
#include <vector>
#include <string>
#include <cstdlib>

using namespace std;
int main()
{
	int M;//Size of the array
	int i, j;//counters of for
	string StrNumbers;//Read numbers separated for comma

	cout << "Enter please one number for matrix size" << endl;
	cin >> M;

	//Create matrix 
	string** Matrix = new string*[M];
	for (i = 0; i < M; i++)
	{
		Matrix[i] = new string[M];
	}

	cout << "Enter please " << M*M << " numbers for matrix" << endl;
	cin >> StrNumbers;//The users write your numbers
	vector<string>ANumbers;//To store the numbers separated for comma
	size_t pos1 = 0;
	size_t pos2 = 0;

	//process for separate the string
	while (pos2 != StrNumbers.npos)
	{
		pos2 = StrNumbers.find(",", pos1);//first position of the numbers separated
		if (pos2 != StrNumbers.npos)
		{
			if (pos2 > pos1)
				ANumbers.push_back(StrNumbers.substr(pos1, pos2 - pos1));//To store the number that is between the commas
			pos1 = pos2 + 1;
		}
	}
	ANumbers.push_back(StrNumbers.substr(pos1, StrNumbers.size() - pos1));

	int k=0;//Counter of the vector ANumbers
	for (i = 0; i < M; i++){
		for (j = 0; j < M; j++)
		{
			Matrix[i][j] = ANumbers[k];//To store the array in the matrix
			k++;//k not start 
		}
	}

	//Print the matrix  
	cout << "Your Matrix" << endl;
	for (i = 0; i < M; i++) {
		for (j = 0; j < M; j++)
		{
			cout<<Matrix[i][j]<<" ";
		}
		cout << endl;
	}cout << endl;

	//Print the matrix transferred
	cout << "Your matrix transfer" << endl;
	for (i = 0; i < M; i++) {
		for (j = 0; j < M; j++)
		{
			cout << Matrix[j][i] << " ";
		}
		cout << endl;
	}cout << endl;

	getch();
	return 0;
}