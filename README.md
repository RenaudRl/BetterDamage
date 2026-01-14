# BetterDamage

![Java Version](https://img.shields.io/badge/Java-21-orange)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Target](https://img.shields.io/badge/Target-Folia%20/%20Paper/BTC--CORE%20-blue)

**BetterDamage** is a high-performance, strictly optimized fork of **toxicity188's BetterDamage**, engineered specifically for the **BTC Studio** infrastructure. This fork drops support for legacy platforms (Spigot, Bukkit, older NMS) to provide native, blazingly fast damage indicators and skins for **Paper** and **Folia**.

> [!WARNING]
> **PLATFORM COMPATIBILITY NOTICE**
> This fork is **STRICTLY** for Paper 1.21.11+ and Folia 1.21.11+. Legacy compatibility layers have been removed to maximize performance. If you are not running modern Paper/Folia, this plugin **will not function**.

---

## 🚀 Key Features in Detail

### ⚡ Concurrency & Threading (Folia Native)
- **Native Folia Support**: Deeply integrated `PaperScheduler` ensures that all damage indicators and cosmetic tasks are handled correctly using the region scheduler.
- **Zero-Overhead Logic**: Slashed unnecessary logic checks for non-Folia/non-Paper platforms, resulting in instant feedback and faster rendering.

### 🛠️ Core Optimisations & Debloating
- **Java 21 Native**: Leveraging the latest JVM optimizations for maximum throughput and memory efficiency.
- **Legacy Cleanup**: Removed support for legacy NMS versions (1.17 - 1.21.10) and Spigot-specific compatibility.
- **BTC Core Integration**: Native detection of BTC Core platform to enable specialized optimizations.

### � Advanced Visuals & Customizability
- **Dynamic Damage Skins**: Highly configurable damage indicators that support images, text, and animations.
- **Model Engine Support**: Seamless integration with ModelEngine to display damage on custom models.
- **RPG Integration**: Built-in support for **MMOItems**, **MMOCore**, **Nexo**, and **CraftEngine** to display custom damage types and effects.
- **Pack Management**: Efficient pack generation and management for custom assets.

---

## ⚙️ Configuration

BetterDamage is optimized out-of-the-box, but stays configurable via `config.yml`.

### Key Settings
| Key | Default | Description |
|-----|---------|-------------|
| `metrics` | `true` | Enables/Disables bStats metrics. |
| `debug` | `false` | Enables debug mode for development. |
| `default_skin` | `default` | The default damage skin to use. |

---

## 🛠 Building & Deployment

Requires **Java 21**.

```bash
# Clean and compile the project
./gradlew clean build
```

---

## 🤝 Credits & Inspiration
This project is built upon the innovation of the broader Minecraft development community:
- **[BetterDamage](https://github.com/toxicity188/BetterDamage)** - The original project by toxicity188.

---

## 📜 License
- **Custom BTC-CORE Patches**: Proprietary to **BTC Studio**.
- **Upstream Source**: Original licenses apply to their respective components from BetterDamage (MIT).

---
**Fork maintained by BTCSTUDIO**
