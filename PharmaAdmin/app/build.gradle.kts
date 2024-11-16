plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)

	kotlin("plugin.serialization") version "2.0.20"
	id("kotlin-kapt")
	id("com.google.dagger.hilt.android")
	alias(libs.plugins.compose.compiler)
}

android {
	namespace = "com.rushi.pharmaadmin"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.rushi.pharmaadmin"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	//navigation
	implementation("androidx.navigation:navigation-compose:2.8.2")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
	//dagger hilt
	implementation("com.google.dagger:hilt-android:2.51.1")
	kapt("com.google.dagger:hilt-android-compiler:2.51.1")
	implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

	//Api integration retrofit
	implementation("com.squareup.retrofit2:retrofit:2.11.0")
	implementation("com.squareup.retrofit2:converter-gson:2.11.0")
	implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

	implementation("io.coil-kt.coil3:coil-compose:3.0.0-rc01")
	implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.0-rc01")


	implementation("androidx.compose.material:material:1.5.1")
	implementation(kotlin("script-runtime"))

	implementation("androidx.compose.material:material-icons-extended:1.7.5")

	//preferance dependancies
	implementation("androidx.datastore:datastore-preferences:1.1.1")
}