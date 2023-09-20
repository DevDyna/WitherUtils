package geni.witherutils.base.common.base;

import javax.annotation.Nullable;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IHudDisplay {

	@OnlyIn(Dist.CLIENT)
	boolean renderHud(GuiGraphics gui, BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result, @Nullable BlockEntity te);
}
