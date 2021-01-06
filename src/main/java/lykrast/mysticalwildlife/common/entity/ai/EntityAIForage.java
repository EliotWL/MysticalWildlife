package lykrast.mysticalwildlife.common.entity.ai;

import java.util.EnumSet;

import lykrast.mysticalwildlife.common.entity.EntityKrill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIForage extends Goal {
    protected final EntityKrill forager;
    protected final World world;
    protected int timer;
    
    public EntityAIForage(EntityKrill forager) {
        this.forager = forager;
        this.world = forager.world;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }
    
    @Override
    public boolean shouldExecute() {
        if (forager.isChild() || !forager.onGround || forager.forageCooldown > 0) return false;
        else {
            BlockPos pos = new BlockPos(forager.serverPosX, forager.serverPosY - 1, forager.serverPosZ);
            return world.getBlockState(pos).getMaterial() == Material.SAND;
        }
    }

    @Override
    public void startExecuting() {
        timer = 40;
        world.setEntityState(forager, (byte)10);
        forager.getNavigator().clearPath();
    }
    
    public int getForageProgress() {
    	return timer;
    }

    @Override
    public void resetTask() {
    	timer = 0;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return timer > 0;
    }
    
    @Override
    public void tick() {
        timer = Math.max(0, timer - 1);

        if (timer == 4) {
			BlockPos blockpos = new BlockPos(forager.serverPosX, forager.serverPosY - 1, forager.serverPosZ);

			if (world.getBlockState(blockpos).getMaterial() == Material.SAND)
			{
				world.playEvent(2001, blockpos, Block.getStateId(world.getBlockState(blockpos)));
				forager.eatGrassBonus();
			}
        }
    }
}
