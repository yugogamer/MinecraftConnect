package fr.yugogamer.minecraftconnect.modele;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MinecraftStatus {
    private String name;
    private String version;
    private String description;
    private String gameType;
    private int currentPlayer;
    private int maxPlayer;
    private boolean whitelist;
    private boolean modded;
    private boolean hardcore;
    private boolean pvp;
    private List<String> playerName;

    MinecraftStatus(JSONObject response)
    {
        try {
            this.name = response.getString("name");
            this.version = response.getString("version");
            this.description = response.getString("description");
            this.gameType = response.getString("gametype");
            this.currentPlayer = response.getInt("currentplayer");
            this.maxPlayer = response.getInt("maxplayer");
            this.whitelist = response.getBoolean("whitelist");
            this.modded = response.getBoolean("modded");
            this.hardcore = response.getBoolean("hardcore");
            this.pvp = response.getBoolean("true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void upDate(JSONObject response)
    {
        try {
            this.name = response.getString("name");
            this.version = response.getString("version");
            this.description = response.getString("description");
            this.gameType = response.getString("gametype");
            this.currentPlayer = response.getInt("currentplayer");
            this.maxPlayer = response.getInt("maxplayer");
            this.whitelist = response.getBoolean("whitelist");
            this.modded = response.getBoolean("modded");
            this.hardcore = response.getBoolean("hardcore");
            this.pvp = response.getBoolean("true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerList(JSONObject response)
    {
        try {
            JSONArray array = response.getJSONArray("players");
            this.maxPlayer = response.getInt("maxplayer");
            this.currentPlayer = response.getInt("currentplayer");
            this.playerName = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                this.playerName.add(array.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getGameType() {
        return gameType;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public boolean isWhitelist() {
        return whitelist;
    }

    public boolean isModded() {
        return modded;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public boolean isPvp() {
        return pvp;
    }
}
