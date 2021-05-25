import java.time.Year

plugins {
    java
    id("org.cadixdev.licenser") version("0.5.0")
}

val jdaVersion       = "4.2.0_247"
val logbackVersion   = "1.2.3"
val brigadierVersion = "1.0.500"
val gsonVersion      = "2.8.7"

group = "dev.galacticraft"
version = "0.0.0"

repositories {
    mavenCentral()
    jcenter()
    maven("https://libraries.minecraft.net") {
        content {
            includeGroup("com.mojang")
        }
    }
}

dependencies {
    implementation("net.dv8tion:JDA:$jdaVersion") {
        exclude(module = "opus-java") // exclude voice module
    }
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("com.mojang:brigadier:$brigadierVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")
}

license {
    header = file("LICENSE_HEADER.txt")
    include("**/dev/galacticraft/**/*.java")
    ext {
        set("year", Year.now().toString())
        set("company", "Team Galacticraft")
    }
}