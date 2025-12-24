import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int p1point = 0;
    public int p2point = 0;
    
    private String player1Name;
    private String player2Name;
    Map<Integer, String> scores;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        initScoresMap();
    }

    public String getScore(){
        if (isEqualScores()) {
            if(isDeuce())
                return  "Deuce";
            else
                return getPlayerScore(p1point) + "-All";
        }
        else {
            return getCurrentScore();
        }
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

    private boolean isDeuce() {
        return p1point >= 3;
    }

    private String getCurrentScore() {
        if(isWin())
            return "Win for " + getWinnerPlayerName();
        else if(isAdvantage())
            return "Advantage " + getWinnerPlayerName();
        else return getPlayerScore(p1point) + "-" + getPlayerScore(p2point);
    }

    private boolean isEqualScores() {
        return p1point == p2point;
    }

    private String getPlayerScore(int score) {
        return scores.get(score);
    }
    private void IncP1Score(){
        p1point++;
    }

    private void IncP2Score(){
        p2point++;
    }
    private String getWinnerPlayerName() {
        return p1point > p2point ? player1Name : player2Name;
    }
    private boolean isAdvantage() {
        boolean isMinScoreAtLeastThree = Math.min(p1point, p2point) >= 3;
        int difference = getAbsDifference();
        return isMinScoreAtLeastThree && difference == 1;
    }
    private boolean isWin() {
        boolean isFourAtLeast = p1point >= 4 || p2point >= 4;
        int difference = getAbsDifference();
        return isFourAtLeast && difference >= 2;
    }
    private int getAbsDifference() {
        return Math.abs(p1point - p2point);
    }
}