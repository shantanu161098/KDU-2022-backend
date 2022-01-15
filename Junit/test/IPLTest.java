import static org.junit.jupiter.api.Assertions.*;

class IPLTest {

    @org.junit.jupiter.api.Test
    void findBestBatsmenTeamTest() {
        IPL iplInstance = new IPL();
        assertEquals("CSK",iplInstance.findBestBatsmenTeam(iplInstance.putPlayers()));
    }
}