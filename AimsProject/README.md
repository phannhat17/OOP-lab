## Answer for questions in the lab

The answer can be found in [answers.txt](./answers.txt)

1. Is JAVA a Pass by Value or a Pass by Reference programming language?  
Java is a passed by value programming language.

2. After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two objects still remain?  
Because the swap() method is exchanging the values of the title fields between the two objects, but it's not changing the object references themselves. So the jungleDVD and cinderellaDVD object references still point to the same objects in memory as before the swap() method call.

3. After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is the title of the JungleDVD changed?  
Because the changeTitle() method is modifying the title field of the jungleDVD object directly using the setter method.

4. Write a toString() method for the DigitalVideoDisc class. What should be the return type of this method?  
The return type should be String
