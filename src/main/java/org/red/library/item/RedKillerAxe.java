package org.red.library.item;

import org.bukkit.event.player.PlayerInteractEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.item.event.EventItem;
import org.red.library.item.event.EventItemAnnotation;

public class RedKillerAxe implements EventItem {
    @Override
    public String getCode() {
        return "red_killer_axe";
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.LEFT_CLICK_BLOCK)
    public void leftClickBlock(PlayerInteractEvent event) {
        NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
        player.getDataMap().put("pos1", event.getClickedBlock().getLocation());
        player.sendMessage("pos1 설정 완료");
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_BLOCK)
    public void rightClickBlock(PlayerInteractEvent event) {
        NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
        player.getDataMap().put("pos2", event.getClickedBlock().getLocation());
        player.sendMessage("pos2 설정 완료");
    }
}
