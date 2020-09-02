# UVtechProjX
_Write a java program to accept a variable x. x can be any number from 1 to 230-1. Generate a file with x number of lines and each line consist of a string that is unique with 100 characters long
Limitation: This java program needs to run with only 10M of ram.
Requirement:
You’re working in a team.
The code has "separation of concern"
The code is testable with Junit test_

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
###  This project has two different solutions for the given problem

1.  **MaskSubstring ( Scalable )**- Optimum solution under given conditions with "Base 10 logarithm" and "Substring" computations
2.  **PureMask ( Not scalable for large X value )**- Computationally Optimum solution avoiding "Base 10 logarithm" and "Substring" computations

_To ensure the uniqueness of a line we can use the value of X itself. Therefore both solution approach uses a mask string to concatenate with "X" value.
If not we will have to use unique key generation method with computing uniqueness in memory or we can use pre implemented  Hashing algorithm to generate charaters based on a seed value ( X can be use as a seed )_
 
### Max Heap Usage ( -Xmx10M  )
![image](https://user-images.githubusercontent.com/7715914/92024803-47875300-ed7c-11ea-86f1-c9fa6c0c6060.png)


### Unit Test Coverage
![image](https://user-images.githubusercontent.com/7715914/92023009-c202a380-ed79-11ea-94e9-a7dc81584d83.png)
