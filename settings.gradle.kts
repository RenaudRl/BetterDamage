pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://nexus.phoenixdevt.fr/repository/maven-public/") //MMOItems, MMOCore, MythicLib
        maven("https://mvn.lumine.io/repository/maven-public/")
        maven("https://repo.alessiodp.com/releases/")
        maven("https://repo.momirealms.net/releases/")
        maven("https://repo.nexomc.com/releases/")
        // for development builds
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/") {
            name = "central-snapshots"
            mavenContent { snapshotsOnly() }
        }
    }
}

rootProject.name = "BetterDamage"

include(
    "api",
    "core",

    "nms:v26_R1",
    "nms:v26_R2",

    "modelengine:current",
)