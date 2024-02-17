plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
}

android {
    namespace = "com.test.kotlinex"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.test.kotlinex"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled= true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding =true
        buildConfig =true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    android{
        aaptOptions.cruncherEnabled = false
        aaptOptions.useNewCruncher = false
    }

    dataBinding{
       enable=true
   }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //GSON (Conversion of String to Map & Vice-Versa)
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.localebro:okhttpprofiler:1.0.8")
    /*implementation("com.google.http-client:google-http-client-gson:1.43.3") {
        exclude group ("org.apache.httpcomponents")
    }*/
    //retrofit library
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp:okhttp:2.7.5")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")

    //image loading library
    implementation ("com.squareup.picasso:picasso:2.71828")
    /*font library*/
    implementation ("io.github.inflationx:calligraphy3:3.1.1")
    implementation ("io.github.inflationx:viewpump:2.0.3")

    //circular image view library
    implementation ("de.hdodenhof:circleimageview:3.1.0")

}