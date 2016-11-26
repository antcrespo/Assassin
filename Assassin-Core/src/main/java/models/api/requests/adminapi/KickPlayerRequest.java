package models.api.requests.adminapi;

import models.api.requests.CommonRequest;

/**
 * A request sent by admin to kick a player from the game.
 */
public class KickPlayerRequest extends CommonRequest{

    private int kickPlayerId;

    public int getKickPlayerId() {
        return kickPlayerId;
    }

    public void setKickPlayerId(int kickPlayerId) {
        this.kickPlayerId = kickPlayerId;
    }
}
