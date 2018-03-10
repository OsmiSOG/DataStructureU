""" This code i make a matrix of random numbers and print the inside rombhus"""
import random

M = int(input("Enter please one number for matrix size\n"))#Var whit size matrix

#Make Matrix
Matrix = []
for i in range(M):
    Matrix.append([0]*M)

# whit random numbers
for i in range(M):
    for j in range(M):
        Matrix[i][j]=random.randint(0,50)

print(Matrix)#print Matrix

# Matrix rhomb inside
SizeL=0#moves only between the center and the left
SizeR=0#moves only between the center and the right
if M%2==0:#if the matrix size is even
    SizeL = (M/2)-1#SizeL is the half of the Matrix size minus one
    SizeR = M/2#SizeR is the half of the matrix size
else:# if the matrix size doesn't is even, SizeL and SizeR are half matrix size
    SizeL = int(M/2)
    SizeR = int(M/2)

#To travel the Matrix
for i in range(M):
    for j in range(M):
        if j <= SizeL or j>= SizeR:# if the matrix is between SizeL and SizeR print the Matrix
            print (Matrix[i][j], end=' ')
        else:
            print(end='  ')
    if M%2 == 0:#Inside first 'for' conditional if Matrix is even or Odd
        if i<(M/2)-1:#if i is between the half upward
            SizeL -= 1#SizeL moves toward left
            SizeR += 1#SizeR moves toward Right
        else:# if i is between the half downward
            if i>=M/2:
                SizeL += 1#SizeL moves towad Right
                SizeR -= 1#SizeR moves toward left
    else:# is the matrix is Odd
        if i<int(M/2):#if i is between the half upward
            SizeL -= 1#SizeL moves toward left
            SizeR += 1#SizeR moves toward Right
        else:# if i is between the half downward
            SizeL += 1#SizeL moves towad Right
            SizeR -= 1#SizeR moves toward left
    print()
