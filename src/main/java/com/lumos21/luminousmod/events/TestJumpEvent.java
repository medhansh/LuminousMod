package com.lumos21.luminousmod.events;

import com.lumos21.luminousmod.LuminousMod;
import com.lumos21.luminousmod.init.BlockInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LuminousMod.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent
{
	@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event)
	{
		LuminousMod.LOGGER.info("testJumpEvent fired");
		//LivingEntity livingEntity = event.getEntityLiving();
		
		//livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 127));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 255));
		//livingEntity.setGlowing(true);
	}
}
