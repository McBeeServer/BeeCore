package net.acticraft.plugin.beecore.TabList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class BelowName implements Listener {
    public Scoreboard belowName(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("BelowName", "name");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName("");

        return board;
    }
}
