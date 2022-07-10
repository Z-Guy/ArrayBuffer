public class BufferArrayTestDriver2
{

public static void main(String[] args)
{

BufferArray a = new BufferArray(10);
a.insert(10);
a.insert(30);
a.insert(40);
a.insert(45);
a.insert(55);
a.insert(60);

a.display();
a.fastRemove(30);
System.out.print("Array After remove 30 using remove method");
System.out.print("\n");
a.display();
Boolean out = a.find(55);
System.out.print("Find 55: ");
System.out.print(out);
System.out.print("\n");
a.stableRemove(30);
System.out.print("Array After remove 30 using stableremove method");
System.out.print("\n");
a.display();


System.out.print("\n");
System.out.print("\n");
System.out.print("No duplicate buffer operations: ");
System.out.print("\n");

BufferArrayNoDups noDupBuffer = new BufferArrayNoDups(10);

for (int i = 10;i <= 60;i = i + 10)
{
noDupBuffer.insert(i);
}
noDupBuffer.display();
System.out.printf( "Insert duplicate 30: ");
System.out.printf("%b", noDupBuffer.insert(30));
System.out.printf( "\n");
noDupBuffer.display();
System.out.printf( "Fast Remove 30: ");
System.out.printf("%b", noDupBuffer.fastRemove(30));
System.out.printf( "\n");
noDupBuffer.display();
System.out.printf( "Stable Remove 40: ");
System.out.printf("%b", noDupBuffer.stableRemove(40));
System.out.printf( "\n");
noDupBuffer.display();

System.out.printf( "\n");
System.out.printf( "\n");
System.out.printf( "Duplicate buffer operations: ");
System.out.printf( "\n");

BufferArrayWithDups dupBuffer = new BufferArrayWithDups(10);
for (int i = 10;i <= 60;i = i + 10)
{
dupBuffer.insert(i);
}
dupBuffer.display();
System.out.printf( "Insert duplicate 30: ");
System.out.printf("%b", dupBuffer.insert(30));
System.out.printf( "\n");
dupBuffer.display();
System.out.printf( "Fast Remove 40: ");
System.out.printf("%b", dupBuffer.fastRemove(40));
System.out.printf( "\n");
dupBuffer.display();
System.out.printf( "Stable Remove 45: ");
System.out.printf("%b", dupBuffer.stableRemove(45));
System.out.printf( "\n");
dupBuffer.display();

System.out.printf( "Fast Remove all 30: ");
System.out.printf("%b", dupBuffer.fastRemoveAll(30));
System.out.printf( "\n");
dupBuffer.display();

}
}