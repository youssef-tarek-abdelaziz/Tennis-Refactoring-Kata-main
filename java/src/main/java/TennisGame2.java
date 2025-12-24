
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if (isEqualScores())
        {
            if(P1point >= 3) {
                score = "Deuce";
            }
            else {
                score = getPlayerScore(P1point) + "-All";
            }
        }
        else {
            score = getPlayerScore(P1point) + "-" + getPlayerScore(P2point);
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
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

    private String getPlayerScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
    private void IncP1Score(){
        P1point++;
    }

    private void IncP2Score(){
        P2point++;
    }
}