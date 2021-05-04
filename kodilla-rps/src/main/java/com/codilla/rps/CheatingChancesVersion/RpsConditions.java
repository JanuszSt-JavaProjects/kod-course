package com.codilla.rps.CheatingChancesVersion;

import java.util.HashMap;
import java.util.Map;

public class RpsConditions {

    private final Map<RpsRoundResult, String> scoresMap = new HashMap<>();

    RpsConditions() {

        scoresMap.put(new RpsRoundResult(1, 1),
                "Your choice is \"rock\",  computer's choice is also \"rock\" - there is no point.");
        scoresMap.put(new RpsRoundResult(2, 2),
                "Your choice is \"paper\",  computer's choice is also \"paper\" - there is no point.");
        scoresMap.put(new RpsRoundResult(3, 3),
                "Your choice is \"scissors\",  computer's choice is also \"scissors\" - there is no point.");


        scoresMap.put(new RpsRoundResult(1, 2),
                "Your choice is \"rock\",  computer's choice is  \"paper\" - computer Wins!");
        scoresMap.put(new RpsRoundResult(1, 3),
                "Your choice is \"rock\",  computer's choice is  \"scissors\" - You Win!");


        scoresMap.put(new RpsRoundResult(2, 1),
                "Your choice is \"paper\",  computer's choice is  \"rock\" - You  Win!");
        scoresMap.put(new RpsRoundResult(2, 3),
                "Your choice is \"paper\",  computer's choice is  \"scissors\" - computer Wins!");


        scoresMap.put(new RpsRoundResult(3, 1),
                "Your choice is \"scissors\",  computer's choice is  \"rock\" - computer Wins!");
        scoresMap.put(new RpsRoundResult(3, 2),
                "Your choice is \"scissors\",  computer's choice is  \"paper\" - You Win!");
    }

    public String scoreActionSelector(RpsRoundResult rpsRoundResult) {
        String returnString = "";
        for (Map.Entry<RpsRoundResult, String> element : scoresMap.entrySet()
        ) {
            if (element.getKey().equals(rpsRoundResult)) {
                returnString = element.getValue();
                System.out.println(returnString);
            }
        }
        return returnString;
    }

}
