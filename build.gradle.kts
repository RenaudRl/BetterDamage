plugins {
    alias(libs.plugins.conventions.standard)
    id("xyz.jpenilla.run-paper") version "3.0.2"
    id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.3.1"
    id("com.gradleup.shadow") version "9.5.1"
}

val minecraft = property("minecraft_version").toString()
val adventure = libs.versions.adventure.get()

val pluginVersion = version.toString()
val groupString = group.toString()

val dependenciesContent = libs.bundles.library.standard.map {
    it.map(Any::toString)
}.get()

dependencies {
    implementation(libs.bundles.library.shaded) {
        exclude(group = "org.jetbrains", module = "annotations")
        exclude(group = "io.leangen.geantyref", module = "geantyref")
    }

    implementation(project(":api")) { isTransitive = false }
    implementation(project(":core")) { isTransitive = false }

    // Legacy NMS (v1_20/v1_21) dropped: this fork targets 26.2 only. Old modules also fail
    // paperweight remapMinecraft for those old versions.
    implementation(project(":nms:v26_R1")) { isTransitive = false }
    implementation(project(":nms:v26_R2")) { isTransitive = false }

    implementation(project(":modelengine:current")) { isTransitive = false }
}

tasks {
    runServer {
        pluginJars(fileTree("plugins"))
        minecraftVersion(minecraft)
        downloadPlugins {
            hangar("ViaVersion", "5.10.0")
            hangar("ViaBackwards", "5.10.0")
        }
    }
    jar {
        finalizedBy(shadowJar)
    }
    shadowJar {
        manifest {
            attributes(
                "paperweight-mappings-namespace" to "spigot",
                "Version" to pluginVersion,
                "Author" to "toxicity188",
                "Url" to "https://github.com/toxicity188/BetterDamage",
                "Created-By" to "Gradle $gradle",
                "Build-Jdk" to "${System.getProperty("java.vendor")} ${System.getProperty("java.version")}",
                "Build-OS" to "${System.getProperty("os.arch")} ${System.getProperty("os.name")}"
            )
        }
        archiveClassifier = ""
        dependencies {
            exclude(dependency("org.jetbrains:annotations:13.0"))
        }
        fun prefix(pattern: String) {
            relocate(pattern, "$groupString.shaded.$pattern")
        }
        prefix("kotlin")
        prefix("org.bstats")
    }
}

bukkitPluginYaml {
    main = "${project.group}.BetterDamagePluginImpl"
    version = project.version.toString()
    website = "https://github.com/toxicity188/BetterDamage"
    name = rootProject.name
    foliaSupported = true
    apiVersion = "1.20.6"
    author = "toxicity"
    description = "Provides simple damage skin for Minecraft Bukkit."
    softDepend = listOf(
        "BetterModel",
        "MMOCore",
        "MMOItems",
        "ModelEngine",
        "CraftEngine",
        "Nexo"
    )
    libraries = listOf(
        "net.kyori:adventure-api:$adventure",
        "net.kyori:adventure-text-serializer-gson:$adventure"
    ) + dependenciesContent
}