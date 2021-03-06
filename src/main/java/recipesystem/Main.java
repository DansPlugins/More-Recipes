package recipesystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import recipesystem.Subsystems.CommandSubsystem;
import recipesystem.Subsystems.ItemStackSubsystem;
import recipesystem.Subsystems.RecipeSubsystem;

public final class Main extends JavaPlugin {

    // version
    public static String version = "v1.3";

    // subsystems
    public ItemStackSubsystem itemstacks = new ItemStackSubsystem(this);
    public RecipeSubsystem recipes = new RecipeSubsystem(this);

    @Override
    public void onEnable() {
        recipes.registerRecipes();
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSubsystem commandInterpreter = new CommandSubsystem(this);
        return commandInterpreter.interpretCommand(sender, label, args);
    }
}
