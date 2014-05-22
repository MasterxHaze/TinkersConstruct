package tconstruct.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import tconstruct.library.modifier.IModifyable;

public class SlotCraftingStation extends SlotCrafting
{
    private final IInventory matrix;
    private EntityPlayer player;
    public SlotCraftingStation(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3iInventory, int par4, int par5, int par6)
    {
        super(par1EntityPlayer, par2IInventory, par3iInventory, par4, par5, par6);
        this.matrix = par2IInventory;
        this.player = par1EntityPlayer;
    }

    @Override
    public void onPickupFromSlot (EntityPlayer player, ItemStack stack)
    {
        ItemStack tool = this.matrix.getStackInSlot(4);
        if (stack.getItem() instanceof IModifyable && tool != null && tool.getItem() instanceof IModifyable)
        {
            matrix.setInventorySlotContents(4, null);
            player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "tinker:little_saw", 1.0F, (player.rand.nextFloat() - player.rand.nextFloat()) * 0.2F + 1.0F);
        }
        super.onPickupFromSlot(player, stack);
    }
}
