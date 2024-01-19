plugins {
    id("com.android.application")

    //firebase
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.didaktikapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.didaktikapp"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    //Mapa
    implementation ("org.osmdroid:osmdroid-android:6.1.17")

    //ROOM
        //falta el def si se revisa en documentacion pero no hace falta ponerlo
        implementation ("androidx.room:room-runtime:2.4.0"); //se usa el 2.4 porque el 5 no va en todos los dispositibos
        annotationProcessor ("androidx.room:room-compiler:2.4.0");//se usa el 2.4 porque el 5 no va en todos los dispositibos


    //FIREBASE
        // Import the Firebase BoM
        implementation(platform("com.google.firebase:firebase-bom:32.5.0"))

        // Declare the dependency for the Cloud Firestore library
        // When using the BoM, you don't specify versions in Firebase library dependencies
        implementation("com.google.firebase:firebase-firestore")
        // Import the BoM for the Firebase platform
        implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

        // Add the dependency for the Firebase Authentication library
        // When using the BoM, you don't specify versions in Firebase library dependencies
        implementation("com.google.firebase:firebase-auth")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Add this in addition to your other dependencies
    implementation ("androidx.activity:activity:1.9.0-alpha01")
    implementation ("com.google.code.gson:gson:2.8.5")

}