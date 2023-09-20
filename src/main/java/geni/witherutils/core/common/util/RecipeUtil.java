package geni.witherutils.core.common.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeUtil {

	public static NonNullList<Ingredient> getIngredientsArray(JsonObject obj)
	{
		JsonArray array = GsonHelper.getAsJsonArray(obj, "ingredients");
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		for (int i = 0; i < array.size(); ++i)
		{
			Ingredient ingredient = Ingredient.fromJson(array.get(i));
			if (!ingredient.isEmpty())
			{
				nonnulllist.add(ingredient);
			}
		}
		return nonnulllist;
	}

	public static FluidStack getFluid(JsonObject fluidJson)
	{
		if (fluidJson.has("fluidTag"))
		{
		}
		String fluidId = GsonHelper.getAsString(fluidJson, "fluid");
		ResourceLocation resourceLocation = new ResourceLocation(fluidId);
		Fluid fluid = ForgeRegistries.FLUIDS.getValue(resourceLocation);
		int count = fluidJson.get("count").getAsInt();
		if (count < 1)
		{
			count = 1;
		}
		return new FluidStack(fluid, count);
	}
	
	public static ItemStack getItemStack(JsonObject ItemJson)
	{
		String itemId = GsonHelper.getAsString(ItemJson, "item");
		ResourceLocation resourceLocation = new ResourceLocation(itemId);
		Item item = ForgeRegistries.ITEMS.getValue(resourceLocation);
		int count = ItemJson.get("count").getAsInt();
		if (count < 1)
		{
			count = 1;
		}
		return new ItemStack(item, count);
	}
}
