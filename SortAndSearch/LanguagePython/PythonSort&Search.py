"""

 Documentar

"""

def Quick_Sort(Array):

    less_subarray = []
    greather_subarray = []
    result = []
    if len(Array)<=1:
        return Array
    else:
        pivot=Array[0]
        for i in range(1,len(Array)):
            if Array[i]<pivot:
                less_subarray.append(Array[i])
            else:
                greather_subarray.append(Array[i])

        result.extend(Quick_Sort(less_subarray))
        result.append(pivot)
        result.extend(Quick_Sort(greather_subarray))
        return result

def BinarySearch(Array, x):
    lowerBound = 0
    upperBound = len(Array)-1
    index = -1

    while lowerBound < upperBound:
        middlePoint = int((lowerBound+upperBound)/2)
        if x==Array[middlePoint]:
            index = middlePoint
            break
        else:
            if x < Array[middlePoint]:
                upperBound = middlePoint-1
            else:
                lowerBound = middlePoint+1
    if lowerBound == upperBound and Array[lowerBound]==x:
        index = lowerBound
    return index

def BinarySearch_Recursive(Array, x, lB, uB):
    middlePoint = int((lB+uB)/2)

    if lB == uB:
        if x==Array[middlePoint]:
            return middlePoint
        else:
            return -1
    else:
        if x==Array[middlePoint]:
            return middlePoint
        else:
            if x < Array[middlePoint]:
                return BinarySearch_Recursive(Array, x , lB, middlePoint)
            else:
                return BinarySearch_Recursive(Array, x, middlePoint+1, uB)


ArrayS= (input("Enter please numbers separated for comma: ")).split(",")
ArrayInt = []
for i in range(len(ArrayS)):
    ArrayInt.append(int(ArrayS[i]))

Sort = Quick_Sort(ArrayInt)
print(Sort)

search = int((input("Enter a number to search of your sort array")))
index = BinarySearch(Sort, search)
indexRecursive = BinarySearch_Recursive(Sort, search, 0, len(ArrayInt))
print("Startin count in 0 ",index)
print("Startin count in 0 ",indexRecursive)
