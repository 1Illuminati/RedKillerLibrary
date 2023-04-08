package org.red.library.world.rule;

public class RGameRule<T> {
    public static final RGameRule<Boolean> SWAP_HAND = new RGameRule<>("swap_hand", true);
    public static final RGameRule<Boolean> BREED = new RGameRule<>("breed", true);
    public static final RGameRule<Boolean> RIDING = new RGameRule<>("riding", true);
    public static final RGameRule<Boolean> DROP = new RGameRule<>("drop", true);
    public static final RGameRule<Boolean> MOVE = new RGameRule<>("move", true);
    public static final RGameRule<Boolean> INTERACT = new RGameRule<>("interact", true);
    public static final RGameRule<Boolean> COMMAND = new RGameRule<>("command", true);
    public static final RGameRule<Boolean> PLACE = new RGameRule<>("place", true);
    public static final RGameRule<Boolean> BREAK = new RGameRule<>("break", true);
    public static final RGameRule<Boolean> PVP = new RGameRule<>("pvp", true);
    public static final RGameRule<Boolean> ATTACK = new RGameRule<>("attack", true);
    public static final RGameRule<Boolean> FISHING = new RGameRule<>("fishing", true);
    public static final RGameRule<Boolean> CHAT = new RGameRule<>("chat", true);
    public static final RGameRule<Boolean> FALL_DAMAGE = new RGameRule<>("fall_damage", true);
    private final String key;
    private final T defaultValue;
    private RGameRule(String key, T defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public T getDefaultValue() {
        return defaultValue;
    }
}
