package net.pl3x.fabric.purpurclient.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pl3x.fabric.purpurclient.PurpurClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TropicalFishEntity.class)
public abstract class MixinTropicalFish extends LivingEntity {
    private final Vec3d offset = new Vec3d(-0.1D, 0.7D, 0.0D);

    public MixinTropicalFish(EntityType<? extends TropicalFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * offset.y;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        PurpurClient.updatePassengerPosition(this, passenger, offset, bodyYaw);
    }
}