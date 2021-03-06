package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.container.ContainerPCP;
import com.miningmark48.pearcelmod.container.ContainerPearcelWorkbench;
import com.miningmark48.pearcelmod.gui.GuiPCP;
import com.miningmark48.pearcelmod.gui.GuiPearcelWorkbench;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.GUIs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.gui_id_pearcel_workbench){
            return ID == GUIs.gui_id_pearcel_workbench && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.pearcel_workbench ? new ContainerPearcelWorkbench(player.inventory, world, x, y, z) : null;
        }
        if (ID == GUIs.gui_id_pcp){
            return new ContainerPCP(player.inventory, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.gui_id_pearcel_workbench){
            return ID == GUIs.gui_id_pearcel_workbench && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.pearcel_workbench ? new GuiPearcelWorkbench(player.inventory, world, x, y, z) : null;
        }
        if (ID == GUIs.gui_id_pcp){
            return new GuiPCP(player.inventory, world, x, y, z);
        }
        return null;
    }

}
