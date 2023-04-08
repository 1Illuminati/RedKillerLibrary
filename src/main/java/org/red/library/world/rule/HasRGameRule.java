package org.red.library.world.rule;

public interface HasRGameRule {
    <T> T getRGameRuleValue(RGameRule<T> rule);
    <T> void setRGameRuleValue(RGameRule<T> rule, T value);
}
