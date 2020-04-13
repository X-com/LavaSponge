package lavasponge;

import com.mumfrey.liteloader.core.LiteLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Keyboard;
/*
Hotkey class to implement hotkeys for lava sponge. Changeable in the hotkey menu ingame.
 */
public class Hotkeys {

    public static KeyBinding toggleLavaSponge = new KeyBinding("Lava Sponge", Keyboard.KEY_E, "Lava Sponge");

    public static void init() {
        LiteLoader.getInput().registerKeyBinding(toggleLavaSponge);
    }

    public static void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {
        if (toggleLavaSponge.isPressed()) {
            new BucketHack(minecraft).useBucketer();
        }
    }

    public static boolean isKeyDown(int code){
        try{
            return Keyboard.isKeyDown(code);
        }catch(Exception e){
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("Something went wrong with the hotkey. Reset it in the menu to get it working again."));
        }

        return false;
    }
}
