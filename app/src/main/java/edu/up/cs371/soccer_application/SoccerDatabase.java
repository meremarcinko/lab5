package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */

public class SoccerDatabase implements SoccerDB {

    HashMap<String, SoccerPlayer> theMap = new HashMap<>();

    public String name(String firstName, String lastName) {
        return firstName + " ## " + lastName;
    }

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            return false;
        } else {
            String key = name(firstName, lastName);
            SoccerPlayer newSoccer = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
            theMap.put(key, newSoccer);
            return true;
        }
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            theMap.remove(key);
            return true;
        } else {
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            return theMap.get(key);
        } else {
            return null;
        }
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpGoals();
            return true;
        } else {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpAssists();
            return true;
        } else {
            return false;
        }

    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpShots();
            return true;
        } else {
            return false;
        }

    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpSaves();
            return true;
        } else {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpFouls();
            return true;
        } else {
            return false;
        }

    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpYellowCards();
            return true;
        } else {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        if (theMap.containsKey(name(firstName, lastName))) {
            String key = name(firstName, lastName);
            SoccerPlayer one = theMap.get(key);
            one.bumpRedCards();
            return true;
        } else {
            return false;
        }

    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {
        if(teamName == null){
            //return theMap.size();
            return -1;
        } else {
            int totalPlayers = 0;


            for(SoccerPlayer s : theMap.values()){
                if (s.getTeamName().equals(teamName)){
                    totalPlayers++;
                }
            }

            return totalPlayers;
        }
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName) {

        int counter = -1; //keeps track of the right idx in the theMap
        for(SoccerPlayer s : theMap.values()){
            if(teamName == null) {
                counter++;
            } else if (s.getTeamName().equals(teamName)) {
                counter++;
            }

            if(counter == idx){
                return s;
            }

        }

        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {
        return false;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
