package escapee.essencearmory2.common.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import escapee.essencearmory2.EssenceArmory;
import escapee.essencearmory2.common.blocks.base.TEBlockEA;
import escapee.essencearmory2.common.tile.TEChipCreator;

public class BlockChipCreator extends TEBlockEA
{
	public BlockChipCreator(String name)
	{
		super(name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TEChipCreator();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote) return true;
		TileEntity te = world.getTileEntity(pos);
		if (!(te instanceof TEChipCreator)) return false;
		player.openGui(EssenceArmory.instance, 1, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
