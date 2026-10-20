import java.util.Properties
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
val signProps = Properties().apply {
    val f = file(System.getenv("SCREENLOCK_SIGNING_PROPS") ?: "/workspace/keys/screenlock-signing.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}
android {
    namespace = "com.github.toober77.screenlock"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.github.toober77.screenlock"
        minSdk = 28
        targetSdk = 35
        versionCode = 4
        versionName = "1.1.2"
    }
    signingConfigs {
        create("release") {
            val sf = signProps.getProperty("storeFile") ?: System.getenv("SCREENLOCK_STORE_FILE")
            if (sf != null) {
                storeFile = file(sf)
                storePassword = signProps.getProperty("storePassword") ?: System.getenv("SCREENLOCK_STORE_PASSWORD")
                keyAlias = signProps.getProperty("keyAlias") ?: System.getenv("SCREENLOCK_KEY_ALIAS")
                keyPassword = signProps.getProperty("keyPassword") ?: System.getenv("SCREENLOCK_KEY_PASSWORD")
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            val rc = signingConfigs.getByName("release")
            if (rc.storeFile != null) signingConfig = rc
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}
