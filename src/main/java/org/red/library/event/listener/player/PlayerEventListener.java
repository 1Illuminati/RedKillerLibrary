package org.red.library.event.listener.player;

import org.bukkit.event.player.*;
import org.red.library.event.area.player.AreaPlayerAdvancementDoneEvent;
import org.red.library.event.area.player.AreaPlayerAnimationEvent;
import org.red.library.event.area.player.AreaPlayerArmorStandManipulateEvent;
import org.red.library.event.area.player.AreaPlayerBedLeaveEvent;
import org.red.library.event.listener.AbstractListener;

public class PlayerEventListener extends AbstractListener {
    public void playerAdvancementDoneEvent(PlayerAdvancementDoneEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAdvancementDoneEvent.class);
    }

    public void playerBedEnterEvent(PlayerBedEnterEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAdvancementDoneEvent.class);
    }

    public void playerBedLeaveEvent(PlayerBedLeaveEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerBedLeaveEvent.class);
    }

    public void playerAnimationEvent(PlayerAnimationEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerAnimationEvent.class);
    }

    public void playerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerArmorStandManipulateEvent.class);
    }
}
