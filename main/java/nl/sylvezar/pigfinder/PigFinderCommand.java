package nl.sylvezar.pigfinder;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

public class PigFinderCommand implements ICommand {

	@SuppressWarnings("unused")
	private final Main main1;
	public PigFinderCommand(Main exampleMod) {
		this.main1 = exampleMod;
	}

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "pigfinder";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "Toggles pigfinder";
	}

	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		List<String> commandAliases = new ArrayList<String>();
		commandAliases.add("pigfinder");
		commandAliases.add("pf");
		return commandAliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		main1.findpigs = !main1.findpigs;
		utils.sendMessage("PigFinder set to: "+String.valueOf(main1.findpigs), EnumChatFormatting.WHITE);
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
