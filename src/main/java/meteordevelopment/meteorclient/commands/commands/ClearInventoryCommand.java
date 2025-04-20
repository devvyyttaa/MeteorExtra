/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

import static meteordevelopment.meteorclient.systems.modules.player.AutoDropPlus.invIndexToSlotId;

public class ClearInventoryCommand extends Command {
	public ClearInventoryCommand() {
		super("clearinv", "Clear inventory");
	}
	public void build(LiteralArgumentBuilder<CommandSource> builder) {
		builder.executes(context -> {
			for (int i = 0; i < mc.player.getInventory().size(); i++) {
				ItemStack itemStack = mc.player.getInventory().getStack(i);
				if (itemStack != null) {
					mc.interactionManager.clickSlot(0, invIndexToSlotId(i), 300, SlotActionType.SWAP, mc.player);
				}
			}
			return SINGLE_SUCCESS;
		});


	}
}
