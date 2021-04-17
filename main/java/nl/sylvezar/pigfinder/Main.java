package nl.sylvezar.pigfinder;


import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "SylvePigFinder", version = "1.0",name = "Sylve Pig Finder")
public class Main
{
	public static boolean findpigs  = false;
	public static boolean debug  = false;
	public static Entity pig;
	public static Vec3 goal;
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("SylvePigFinder Loaded");
        MinecraftForge.EVENT_BUS.register(new PigTracer(this));
        MinecraftForge.EVENT_BUS.register(new PigHitDetector(this));
        ClientCommandHandler.instance.registerCommand(new PigFinderCommand(this));
        ClientCommandHandler.instance.registerCommand(new DebugCommand(this));
    }
}
