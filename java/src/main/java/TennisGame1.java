
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
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (m_score1==m_score2) {
            score = getEqualityScore();
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getLeadingPlayerResult();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
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
            score ="Advantage " + (m_score1 > m_score2 ? player1 : player2);
        else
            score = "Win for " + (m_score1 > m_score2 ? player1 : player2);
        return score;
    }
}
