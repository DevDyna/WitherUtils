package geni.witherutils.base.common.config;

import org.apache.commons.lang3.tuple.Pair;

import geni.witherutils.base.common.config.client.BaseClientConfig;
import geni.witherutils.base.common.config.common.BaseCommonConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class BaseConfig {
    
    public static final BaseCommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final BaseClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        
        Pair<BaseCommonConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(BaseCommonConfig::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();

        Pair<BaseClientConfig, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(BaseClientConfig::new);
        CLIENT = clientSpecPair.getLeft();
        CLIENT_SPEC = clientSpecPair.getRight();
    }
}
