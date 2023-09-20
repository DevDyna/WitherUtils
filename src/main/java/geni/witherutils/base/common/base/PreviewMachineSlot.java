package geni.witherutils.base.common.base;

import geni.witherutils.base.common.io.item.MachineInventory;
import geni.witherutils.base.common.io.item.MachineInventoryLayout;
import geni.witherutils.base.common.io.item.SingleSlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PreviewMachineSlot extends MachineSlot {
    
    public PreviewMachineSlot(MachineInventory itemHandler, int index, int xPosition, int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);

        MachineInventoryLayout layout = itemHandler.getLayout();
        if (layout.canInsert(index) || layout.canExtract(index))
            throw new RuntimeException("Preview slot can be externally modified!!");
    }

    public PreviewMachineSlot(MachineInventory itemHandler, SingleSlotAccess access, int xPosition, int yPosition)
    {
        this(itemHandler, access.getIndex(), xPosition, yPosition);
    }

    @Override
    public boolean mayPickup(Player playerIn)
    {
        return false;
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return false;
    }
}
