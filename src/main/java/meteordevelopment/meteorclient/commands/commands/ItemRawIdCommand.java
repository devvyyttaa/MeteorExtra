/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ItemRawIdCommand extends Command {
	public ItemRawIdCommand() {
		super("rawitemid", "Get raw item id");
	}

	public void build(LiteralArgumentBuilder<CommandSource> builder) {
		builder.executes(context -> {
			ItemStack itemStack = mc.player.getMainHandStack();
			if (itemStack != null) {
				int raw_id = Item.getRawId(itemStack.getItem());
				ChatUtils.sendMsg(Text.of("Raw Item ID: " + raw_id));
			}
			return SINGLE_SUCCESS;
		});


	}
}
