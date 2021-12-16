package Questions;

import java.util.ArrayList;

public class q3
{
    ArrayList<String> states = new ArrayList<>();

    void setState(String state)
    {
        if (states.contains(state));
        {
            states.add(state);
        }
    }
}
