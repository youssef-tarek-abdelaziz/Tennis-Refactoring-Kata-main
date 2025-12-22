
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private final String player1 = "player1";
    private final String player2 = "player2";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            score = getEqualityScore();
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getLeadingPlayerResult();
        }
        else
        {
            score = getCurrentResult(score);
        }
        return score;
    }

    private String getEqualityScore() {
        String score;
        switch (m_score1) {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }

    private String getLeadingPlayerResult() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (Math.abs(minusResult) == 1)
            score ="Advantage " + getWinnerPlayerName();
        else
            score = "Win for " + getWinnerPlayerName();
        return score;
    }

    private String getWinnerPlayerName() {
        return m_score1 > m_score2 ? player1 : player2;
    }

    private String getCurrentResult(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            score = getPlayerScore(tempScore);
        }
        return score;
    }

    private static String getPlayerScore(int tempScore) {
        return switch (tempScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
}
