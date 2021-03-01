import java.time.Year

plugins {
    java
    id("org.cadixdev.licenser") version("0.5.0")
}

val jdaVersion = project.property("jda.version").toString()
val logbackVersion = project.property("logback.version").toString()
val brigadierVersion = project.property("brigadier.version").toString()
val gsonVersion = project.property("gson.version").toString()

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