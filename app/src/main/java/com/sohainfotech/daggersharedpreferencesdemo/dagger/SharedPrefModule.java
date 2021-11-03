package com.sohainfotech.daggersharedpreferencesdemo.dagger;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

//step3: create module class

@Module
public class SharedPrefModule {
    //declare Context
    private Context context;

    //initialize Context
    public SharedPrefModule(Context context){
        this.context = context;
    }

    //provide Context
    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    //provide SharedPreferences
    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
      return   PreferenceManager.getDefaultSharedPreferences(context);
    }
}
