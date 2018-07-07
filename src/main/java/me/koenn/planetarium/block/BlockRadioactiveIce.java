package me.koenn.planetarium.block;

import me.koenn.planetarium.Planetarium;
import net.minecraft.block.BlockIce;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockRadioactiveIce extends BlockIce {

    private static final Random RANDOM = ThreadLocalRandom.current();

    private final String name;

    public BlockRadioactiveIce(String name) {
        this.name = name;
        this.setHardness(0.5F);
        this.setLightLevel(1.0F);
        this.setLightOpacity(5);
        this.setSoundType(SoundType.GLASS);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }

    public void registerItemModel(Item itemBlock) {
        Planetarium.proxy.registerItemRenderer(itemBlock, 0, this.name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(this.name).setCreativeTab(Planetarium.CREATIVE_TAB);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return 8;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if (worldIn.isRemote) {
            return;
        }

        if (RANDOM.nextInt(10) == 1) {
            this.explode(worldIn, pos);
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.2F);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            this.explode(worldIn, pos);
        }
    }

    private void explode(World world, BlockPos pos) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true);
    }
}
