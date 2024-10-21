package Assignment8;

public class Baby 
{
    String name;
    char sex;
    int numOfName;

    public Baby(String name, char sex, int numOfName)
    {
        this.name = name;
        this.sex = sex;
        this.numOfName = numOfName;
    }

    public String getName()
    {
        return this.name;
    }
    
    public char getSex()
    {
        return this.sex;
    }

    public int getNumOfName()
    {
        return this.numOfName;
    }

}
