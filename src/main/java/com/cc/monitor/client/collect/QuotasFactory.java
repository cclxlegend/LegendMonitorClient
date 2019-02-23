package com.cc.monitor.client.collect;

import com.cc.monitor.client.collect.vo.*;

public final class QuotasFactory {

    private QuotasFactory(){

    }

    public static SysQuotas getSysQuotas(){
        return new SysQuotas();
    }

    public static ClassLoadingQuotas getClassLoadingQuotas(){
        return new ClassLoadingQuotas();
    }

    public static GCQuotas getGCQuotas(){
        return new GCQuotas();
    }

    public static JVMMemoryQuotas getJVMMemoryQuotas(){
        return new JVMMemoryQuotas();
    }

    public static JVMThreadQuotas getJVMThreadQuotas(){
        return new JVMThreadQuotas();
    }
}
