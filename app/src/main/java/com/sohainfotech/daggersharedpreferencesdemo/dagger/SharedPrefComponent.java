package com.sohainfotech.daggersharedpreferencesdemo.dagger;
import com.sohainfotech.daggersharedpreferencesdemo.activity.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

//step4: create component interface to communication between Provider and Consumer

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface SharedPrefComponent {

    //pass component inside the method where we want to use di
    void inject(MainActivity activity);
}
