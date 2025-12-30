
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = getEqualityScore();
        }
        else if (m_score1>=4 || m_score2>=4) {
            score = getLeadingPlayerResult();
        }
        else {
            score = getCurrentResult();
        }
        return score;
    }

    private String getEqualityScore() {
        return switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
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
        return m_score1 > m_score2 ? player1Name : player2Name;
    }

    private String getCurrentResult() {
        return getPlayerScore(m_score1) + "-" + getPlayerScore(m_score2);
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
