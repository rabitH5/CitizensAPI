package net.citizensnpcs.api.abstraction;

import java.util.Map;

import com.google.common.collect.Maps;

public class SimpleItemStack implements ItemStack {
    private int amount;
    private short durability;
    private final Map<Enchantment, Integer> enchantments = Maps.newHashMap();
    private Material type;

    public SimpleItemStack(Material type, int amount, short durability) {
        this.type = type;
        this.amount = amount;
        this.durability = durability;
    }

    @Override
    public void addEnchantments(Map<Enchantment, Integer> enchantments) {
        this.enchantments.putAll(enchantments);
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public short getDurability() {
        return durability;
    }

    @Override
    public int getEnchantmentLevel(Enchantment enchantment) {
        return enchantments.containsKey(enchantment) ? enchantments.get(enchantment) : -1;
    }

    @Override
    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    @Override
    public Material getType() {
        return type;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void setDurability(short durability) {
        this.durability = durability;
    }

    @Override
    public void setType(Material type) {
        this.type = type;
    }
}