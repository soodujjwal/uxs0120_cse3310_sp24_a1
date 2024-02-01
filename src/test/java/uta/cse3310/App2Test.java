package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Unit test for simple App.
 */
public class App2Test 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public App2Test( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( App2Test.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        // this tests just shows one move...
        // remember, this is "code", you can use functions
        // and loops in the test code

        Game G = new Game ();
        UserEvent U = new UserEvent ();
        ServerEvent E = new ServerEvent ();
        G.GameId = 1;
        G.Players = uta.cse3310.PlayerType.OPLAYER;
        G.StartGame();


        // send an event 
        U.GameId = 1;
        U.Button = 1;
        U.PlayerIdx =  uta.cse3310.PlayerType.XPLAYER;
        G.Update (U);

        assertTrue ( G.Button[1] == uta.cse3310.PlayerType.XPLAYER);



        //String jsonString;
        //Gson gson = new Gson();
        //jsonString = gson.toJson(G);
        //System.out.println(jsonString);
    }
}
