package me.LeviCppn.listeners;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.List;
import java.util.Random;

public class OreGenerationListener extends ChunkGenerator implements Listener {

    private final int veinSizeMultiplier;
    private static final List<Material> ORES = List.of(
            Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE,
            Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE,
            Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE,
            Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE,
            Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE,
            Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE,
            Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE,
            Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE
    );

    public OreGenerationListener(int veinSizeMultiplier) {
        this.veinSizeMultiplier = veinSizeMultiplier;
    }

    @Override
    public void generateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 5; y < worldInfo.getMaxHeight(); y++) {
                    if (random.nextDouble() < 0.05 * veinSizeMultiplier) { // Kans op grotere veins
                        Material ore = ORES.get(random.nextInt(ORES.size()));
                        chunkData.setBlock(x, y, z, ore);
                    }
                }
            }
        }
    }
}
