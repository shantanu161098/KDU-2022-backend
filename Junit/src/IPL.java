import java.util.*;
import java.io.*;
import java.util.stream.*;


class Player implements Comparable<Player>{

    String name;
    String team;
    String role;
    int matches;
    int runs;
    double average;
    double strike_rate;
    int wickets;

    Player(String name,String team,String role,int matches,int runs,double average,double strike_rate,int wickets){
        this.name = name;
        this.team = team;
        this.role = role;
        this.matches = matches;
        this.runs  =runs;
        this.average = average;
        this.strike_rate  = strike_rate;
        this.wickets = wickets;
    }



    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public int getWicket(){
        return wickets;
    }

    public String getTeam(){
        return team;
    }

    public int getRuns(){
        return runs;
    }

    public int compareTo(Player p){
        return 0;
    }

    // for all rounders
    public int cumulativeScore(){
        return wickets*40 + runs;
    }

    public int getMatches(){
        return matches;
    }
}


class WicketComparator implements Comparator<Player>{
    public int compare(Player p1,Player p2){
        if(p1.getWicket() < p2.getWicket()){
            return 1;
        }
        else if(p1.getWicket() > p2.getWicket()){
            return -1;
        }
        return 0;
    }
}

class RunComparator implements Comparator<Player>{
    public int compare(Player p1,Player p2){
        if(p1.getRuns() < p2.getRuns()){
            return 1;
        }
        else if(p1.getRuns() > p2.getRuns()){
            return -1;
        }
        return 0;
    }
}


class RunWicketComparator implements Comparator<Player>{
    public int compare(Player p1,Player p2){
        if(p1.cumulativeScore() < p2.cumulativeScore()){
            return 1;
        }
        else if(p1.cumulativeScore() > p2.cumulativeScore()){
            return -1;
        }
        return 0;
    }
}




class IPL{


    public static List<Player> putPlayers(){

        List<Player> listOfPlayers = new ArrayList<Player>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("/home/shantanu/IdeaProjects/Junit/src/IPL_2021_data.csv"));

            // for passing the header
            reader.readLine();
            String line = "";
            while((line = reader.readLine()) != null){
                String[] playerArray = line.split(",");
                listOfPlayers.add(new Player(playerArray[0],playerArray[1],playerArray[2],Integer.valueOf(playerArray[3]),Integer.valueOf(playerArray[4]),Double.valueOf(playerArray[5]),Double.valueOf(playerArray[6]),Integer.valueOf(playerArray[7])));
            }

            reader.close();
        }
        catch(Exception e){
            System.out.println("File not found "+ e);
        }

        return listOfPlayers;
    }

    public static void fixMatch(){
        final int totalTeams = 8;
        String[] listOfTeams = new String[totalTeams];
        String[] homeTeamPlace = new String[totalTeams];

        listOfTeams[0] =  "CSK";
        listOfTeams[1] =  "PBKS";
        listOfTeams[2] =  "RCB";
        listOfTeams[3] =  "SRH";
        listOfTeams[4] =  "MI";
        listOfTeams[5] =  "RR";
        listOfTeams[6] =  "DC";
        listOfTeams[7] =  "KKR";

        homeTeamPlace[0] = "HOME CSK";
        homeTeamPlace[1] = "HOME PBKS";
        homeTeamPlace[2] = "HOME RCB";
        homeTeamPlace[3] = "HOME SRH";
        homeTeamPlace[4] = "HOME MI";
        homeTeamPlace[5] = "HOME RR";
        homeTeamPlace[6] = "HOME DC";
        homeTeamPlace[7] = "HOME KKR";


        ArrayList<String> matchList = new ArrayList<String>();
        for(int i=0;i<totalTeams;i++){
            for(int j=i+1;j<totalTeams;j++){
                matchList.add(listOfTeams[i] + "," + listOfTeams[j] + "," + homeTeamPlace[i] + "\n");
                matchList.add(listOfTeams[i] + "," + listOfTeams[j] + "," + homeTeamPlace[j] + "\n");
            }
        }

        Collections.shuffle(matchList);



        try{
            FileWriter matchWriter = new FileWriter("match.csv");
            for (String s : matchList) {
                matchWriter.write(s);
            }
            matchWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    public static void SearchBowlerAtleastFortyWickets(List<Player> listOfPlayers, String team){

        for(Player p: listOfPlayers){
            if(p.getWicket() >= 40 && p.getTeam().equals(team) && p.getRole().equals("BOWLER")){
                System.out.println(p.getName());
            }
        }
    }

    public static void searchPlayer(List<Player> listOfPlayers,String query){
        List<Player> playerSearchList = listOfPlayers.stream().filter(p -> p.getName().equals(query) || p.getName().split(" ")[0].equals(query) || p.getName().split(" ")[1].equals(query)).collect(Collectors.toList());

        for (Player player : playerSearchList) {
            System.out.println(player.getName());
        }

    }

    public static void findHighest(List<Player> listOfPlayers,String team){
        int higestWicketByPlayer = 0;
        int highestRunScoredByPerson = 0;
        int maxNameSize = 20;
        char[] maxWicketPlayerName = new char[maxNameSize];
        char[] maxRunScorerName = new char[maxNameSize];

        for (Player player : listOfPlayers) {
            if(player.getTeam().equals(team)){

                if(higestWicketByPlayer < player.getWicket()){
                    higestWicketByPlayer = player.getWicket();
                    maxWicketPlayerName = player.getName().toCharArray();
                }

                if(highestRunScoredByPerson < player.getRuns()){
                    highestRunScoredByPerson = player.getRuns();
                    maxRunScorerName = player.getName().toCharArray();
                }
            }
        }
        System.out.println("Highest wicket taker is " +  String.valueOf(maxWicketPlayerName));
        System.out.print("Highest run scorer is " + String.valueOf(maxRunScorerName));
    }

    public static void findTopThree(List<Player> listOfPlayers){

        List<Player> battingList = listOfPlayers.stream().filter(p -> p.getRole().equals("BATSMAN")).collect(Collectors.toList());
        Collections.sort(battingList,new RunComparator());

        System.out.println("===================== Batsman ================");

        for(int i=0;i<3;i++){
            System.out.print(battingList.get(i).getName() + " " + battingList.get(i).getRuns() + "\n");
        }

        System.out.println("===================== Bowler ================");

        List<Player> bowlingList = listOfPlayers.stream().filter(p -> p.getRole().equals("BOWLER")).collect(Collectors.toList());
        Collections.sort(bowlingList,new WicketComparator());

        for(int i=0;i<3;i++){
            System.out.print(bowlingList.get(i).getName() + " " + bowlingList.get(i).getWicket() + "\n");
        }

        System.out.println("============= All Rounders ==================");


        List<Player> allRounderList = listOfPlayers.stream().filter(p -> p.getRole().equals("ALL ROUNDER")).collect(Collectors.toList());
        Collections.sort(allRounderList,new RunWicketComparator());

        for(int i=0;i<3;i++){
            System.out.println(allRounderList.get(i).getName() + " " + allRounderList.get(i).cumulativeScore());
        }
    }

    public String findBestBatsmenTeam(List<Player> listOfPlayers){
        int totalPlayerInATeam = 11;
        int maxTeamNameSize = 20;
        int totalTeams = 8;
        int maxRunsByTeam = 0;

        char[] winnerTeam = new char[maxTeamNameSize];

        String[] listOfTeams = new String[totalTeams];


        listOfTeams[0] =  "CSK";
        listOfTeams[1] =  "PBKS";
        listOfTeams[2] =  "RCB";
        listOfTeams[3] =  "SRH";
        listOfTeams[4] =  "MI";
        listOfTeams[5] =  "RR";
        listOfTeams[6] =  "DC";
        listOfTeams[7] =  "KKR";

        Collections.sort(listOfPlayers,new RunComparator());

        // team building process
        for(String team: listOfTeams){

            int i = 0;
            int currentRunCount = 0;

            for (Player p : listOfPlayers) {
                if(p.getTeam().equals(team)){
                    currentRunCount = currentRunCount + p.getRuns();
                    i = i + 1;
                    if( i == totalPlayerInATeam + 1) break;

                }
            }

            if( currentRunCount > maxRunsByTeam){
                maxRunsByTeam = currentRunCount;
                winnerTeam = team.toCharArray();
            }

            System.out.println(team + " " + currentRunCount);
        }

        System.out.println("Winner is " + String.valueOf(winnerTeam) + " and runs scored " + maxRunsByTeam);
        return String.valueOf(winnerTeam);
    }

    public static void showNextGenPlayer(List<Player> listOfPlayers){

        int matchBar = 20;
        int runBar = 200;
        int wicketBar = 20;
        int cumulativeScoreBar = 600;

        List<Player> battingList = listOfPlayers.stream().filter(p -> p.getRole().equals("BATSMAN")).collect(Collectors.toList());
        List<Player> nextGenBatsmanList = battingList.parallelStream().filter(p -> p.getMatches() < matchBar && p.getRuns() > runBar).collect(Collectors.toList());

        System.out.println("======================= Next gen batsmen =========================");
        for(Player player: nextGenBatsmanList){
            System.out.println(player.getName() + " played matches: " + player.getMatches() + " scored runs: " + player.getRuns());
        }

        List<Player> bowlingList = listOfPlayers.stream().filter(p -> p.getRole().equals("BOWLER")).collect(Collectors.toList());
        List<Player> nextGenBowlingList = bowlingList.parallelStream().filter(p -> p.getMatches() < matchBar && p.getWicket() > wicketBar).collect(Collectors.toList());

        System.out.println("======================= Next gen bowlers =========================");
        for(Player player: nextGenBowlingList){
            System.out.println(player.getName() + " played matches: " + player.getMatches() + " scored wicket: " + player.getWicket());
        }

        List<Player> allRounderList = listOfPlayers.stream().filter(p -> p.getRole().equals("ALL ROUNDER")).collect(Collectors.toList());
        List<Player> nextGenAllRounderList = allRounderList.parallelStream().filter(p -> p.getMatches() < matchBar && p.cumulativeScore() > cumulativeScoreBar).collect(Collectors.toList());

        System.out.println("======================= Next gen all rounders =========================");
        for(Player player: nextGenAllRounderList){
            System.out.println(player.getName() + " played matches: " + player.getMatches() + " cumulative score: " + player.cumulativeScore());
        }
    }




    public static void main(String[] args){
        putPlayers();
    }
}

