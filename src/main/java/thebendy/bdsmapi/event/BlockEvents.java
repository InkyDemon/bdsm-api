package thebendy.bdsmapi.event;

import thebendy.bdsmapi.event.block.OnUse;

public class BlockEvents {
    public OnUse onUse;

    public BlockEvents() {
        this.onUse = (state, world, pos, player, hand, hit) -> {};
    }
}
