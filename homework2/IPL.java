class Player{
    String name;
    int matches;
    String team;
    int runScored;
    int wicketCount;

    Player(String name, int matches, String team, int runScored, int wicketCount){
        this.name = name;
        this.matches = matches;
        this.team = team;
        this.runScored = runScored;
        this.wicketCount = wicketCount;
    }

    public String getName(){
        return name;
    }

    public int getMatches(){
        return matches;
    }

    public int getRunScored(){
        return runScored;
    }

    public String getTeam(){
        return team;
    }

    public int getWicketCount(){
        return wicketCount;
    }

    public int getHigher(Player player){
        if(player.getRunScored() > this.getRunScored()){
            return player.getRunScored();
        }
        return this.getRunScored();
    }
    
}



public class IPL {
    public static void main(String[] args) {
        Player p1 = new Player("shambhu",10,"csk",10,10);
        Player p2 = new Player("bambu",10,"csk",10,10);
        System.out.println(p1.getHigher(p2));
    }    
}
