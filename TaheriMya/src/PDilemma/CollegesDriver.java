package PDilemma;

import java.util.ArrayList;

public class CollegesDriver 
{
    public static void main (String[] args)
    {
        ArrayList<Colleges> collegeList = new ArrayList<>();
        collegeList.add(new Colleges("NYU", 43));
        collegeList.add(new Colleges("Farm", 3));
        collegeList.add(new Colleges());

        //remove all colleges that are "farm"
        for (int k = 0; k < collegeList.size(); k++)
        {
            if(collegeList.get(k).getLocation().equalsIgnoreCase("farm"))
            {
                collegeList.remove(k);
                k--;
            }
            System.out.println(collegeList.get(k).getLocation());
        }

    }
}
