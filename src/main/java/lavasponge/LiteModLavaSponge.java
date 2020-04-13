package lavasponge;


import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.Tickable;
import net.minecraft.client.Minecraft;

import java.io.File;

public class LiteModLavaSponge implements Tickable, LiteMod {

    private boolean gameRunnin = false;
    private boolean loggedOut = false;

    @Override
    public String getVersion() {
        return "@VERSION@";
    }

    @Override
    public void init(File configPath) {
        Hotkeys.init();
    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {
    }

    @Override
    public String getName() {
        return "Lava Sponge";
    }

    @Override
    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {
        gameRunnin = minecraft.isIntegratedServerRunning() || minecraft.getCurrentServerData() != null;

        if (gameRunnin) {
            Hotkeys.onTick(minecraft, partialTicks, inGame, clock);
        }
    }
}