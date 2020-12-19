<h1 align="center">TestPrettier </h1>
<p align="center">
<a href="https://search.maven.org/artifact/com.github.amitrei/testPrettier/1.0.3/jar"><img src="https://img.shields.io/maven-central/v/com.github.amitrei/testPrettier"></a>
</p>

## About the project
<p>Make your java console prints prettier and organized inside tables with just one annotation. <br/>
</p>
<img alt="JAVA"  src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
<img src="https://amit-rei.io/assets/prettierExample.jpg">

## How to use
1.First include the TestPrettier in your project by visiting <a href="https://search.maven.org/artifact/com.github.amitrei/testPrettier/1.0.3/jar">this link</a>. <br/>
For example if your using Maven you should include the dependency in the pom.xml file like so:
```
<dependency>
  <groupId>com.github.amitrei</groupId>
  <artifactId>testPrettier</artifactId>
  <version>1.0.3</version>
</dependency>
```
2. Next step is to annotate the desire class that you want to create template to with the "@TableTemplate" annotation. <br/>
Example:
```
@TableTemplate
public class Dog {

    private String name;
    private int age;
    private String type;

    public Dog(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getType() {
        return type;
    }
}
```
3. Call the TableManager to populate your table with your desired objects like so:
```
        Dog d1 = new Dog("Woofy",9,"Bulldog");
        Dog d2 = new Dog("Ziper",2,"Golden retriever");
        Dog d3 = new Dog("Paloty",5,"German shepherd");
        
       TableManager.getInstance(Main.class).getTemplate("Dog",30)
                .createRow(d1)
                .createRow(d2)
                .createRow(d3)
                .initTable();
```
   ***Make sure to include inside the "getInstance()" parenthesis your current class, in the example above as you can see we are initiating the table inside the Main class***
```
TableManager.getInstance(Main.class)
```
***

4. Getting the template for the annotated class , for that you need to include inside the "getTemplate" parenthesis the annotated class name and on the second argument enter the table width you desire.
```
TableManager.getInstance(Main.class).getTemplate("Dog",30)
```
As you can see in the exmaple we are using the Dog class we annotated with "@TableTemplate" and we set the width of the table to 30.

5. Populate the table with your objects, you do that by calling the "createRow" method and include the object inside the parenthesis. You can have as much rows as you want
```
        Dog d1 = new Dog("Woofy",9,"Bulldog");
        Dog d2 = new Dog("Ziper",2,"Golden retriever");
        Dog d3 = new Dog("Paloty",5,"German shepherd");
        
               TableManager.getInstance(Main.class).getTemplate("Dog",30)
                .createRow(d1)
                .createRow(d2)
                .createRow(d3)
                 .initTable();

```
6. Final step is to call the "initTable" method at the end.

## How its work
By annotating the class with "@TableTemplate" all the class fields are scanned in order to create the table headers , all the getters are also scanned and compared to the fields to
make sure that we get only the right getters to invoke when initiating the table.<br/>
***IMPORTANT NOTE : if your getter name does not start with "get" and followed by the fields name it wont be scanned.*** 
