package com.codilla.rps.CheatingChancesVersion;

import java.util.Objects;

public class RpsRoundResult {
    private final int playerResult;
    private final int computerResult;

    RpsRoundResult(int playerResult, int computerResult) {
        this.playerResult = playerResult;
        this.computerResult = computerResult;
    }

    public int getPlayerResult() {
        return playerResult;
    }

    public int getComputerResult() {
        return computerResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpsRoundResult)) return false;
        RpsRoundResult that = (RpsRoundResult) o;
        return getPlayerResult() == that.getPlayerResult() && getComputerResult() == that.getComputerResult();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerResult(), getComputerResult());
    }
}
