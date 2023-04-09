package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.red.library.event.area.player.*;
import org.red.library.event.listener.AbstractListener;

public class PlayerEventListener extends AbstractListener {
    @EventHandler
    public void playerAdvancementDoneEvent(PlayerAdvancementDoneEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAdvancementDoneEvent.class);
    }
    @EventHandler
    public void playerBedEnterEvent(PlayerBedEnterEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAdvancementDoneEvent.class);
    }
    @EventHandler
    public void playerBedLeaveEvent(PlayerBedLeaveEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerBedLeaveEvent.class);
    }
    @EventHandler
    public void playerAnimationEvent(PlayerAnimationEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAnimationEvent.class);
    }
    @EventHandler
    public void playerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerArmorStandManipulateEvent.class);
    }
    @EventHandler
    public void playerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerBucketEmptyEvent.class);
    }
    @EventHandler
    public void playerBucketFillEvent(PlayerBucketFillEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerBucketFillEvent.class);
    }
    @EventHandler
    public void playerBucketEntityEvent(PlayerBucketEntityEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerBucketEntityEvent.class);
    }
}
