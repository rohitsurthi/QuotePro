// Generated by Dagger (https://dagger.dev).
package com.example.quotepro.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  public NetworkModule_ProvidesRetrofitFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return providesRetrofit(module);
  }

  public static NetworkModule_ProvidesRetrofitFactory create(NetworkModule module) {
    return new NetworkModule_ProvidesRetrofitFactory(module);
  }

  public static Retrofit providesRetrofit(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesRetrofit());
  }
}
