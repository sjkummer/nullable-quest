# Solution

The answer to this problem lies in the class initialization hierarchy and constructor chaining in Java.

The initialization hierarchy when creating a new instance is as follows:
1. Constructor of Superclass
2. Instance variables of own class
3. Constructor of own class

Here comes the trick:
* The constructor of 'SuperClass' calls an abstract method.
* This abstract method is implemented in 'SubClass'
* As a result of the initialization hierarchy, the 'abstractMethod' in 'SubClass' can be __executed before this class has been initialized completely__.

This is the expected behavior "by design" in Java. Nevertheless, typical code inspectors will not detect this probable bug.


## Conclusion

Even with great tools as Annotations and Code Inspectors, there may still remain some hard to find bugs in the code.

On the pro side: Seems like there is a continuous need for human developers which cannot be easily replaced by robots and algorithms.

Happy coding!