import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    private String player1Name;
    private String player2Name;
    Map<Integer, String> scores;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        initScoresMap();
    }

    public String getScore(){
        String score = "";

        if (isEqualScores()) {
            if(P1point >= 3)
                score = "Deuce";
            else
                score = getPlayerScore(P1point) + "-All";
        }
        else {
            if(isWin())
                score = "Win for " + getPlayerName();
            else if(isAdvantage())
                score = "Advantage " + getPlayerName();
            else score = getPlayerScore(P1point) + "-" + getPlayerScore(P2point);
        }

        return score;
    }

    private boolean isEqualScores() {
        return P1point == P2point;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            IncP1Score();
        else
            IncP2Score();
    }


    private void initScoresMap() {
        scores = new HashMap<>();
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
    }

    private String getPlayerScore(int score) {
        return scores.get(score);
    }
    private void IncP1Score(){
        P1point++;
    }

    private void IncP2Score(){
        P2point++;
    }
    private String getPlayerName() {
        return P1point > P2point ? player1Name : player2Name;
    }
    private boolean isAdvantage() {
        return (P1point > P2point && P2point >= 3) || (P2point > P1point && P1point >= 3);
    }
    private boolean isWin() {
        boolean isFourAtLeast = P1point >= 4 || P2point >= 4;
        int difference = Math.abs(P1point - P2point);
        return isFourAtLeast && difference >= 2;
    }
}